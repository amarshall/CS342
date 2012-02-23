package toyThreads.factors;

import java.util.AbstractSet;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

import toyThreads.util.Debug;

public class Results extends AbstractSet<Integer> implements Set<Integer> {
  private Set<Integer> results;

  public Results() {
    Debug.LOGGER.finer("Entered Results.Results()");
    results = Collections.synchronizedSet(new TreeSet<Integer>());
  }

  /**
   * Add a result to the collection.
   * @param result The result to add.
   * @return If the result was added.
   */
  public boolean add(Integer result) {
    return results.add(result);
  }

  /**
   * @return The number of results.
   */
  public int size() {
    return results.size();
  }

  /**
   * @return An iterator for the results
   */
  public Iterator<Integer> iterator() {
    return results.iterator();
  }
}

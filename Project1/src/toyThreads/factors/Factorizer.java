package toyThreads.factors;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import toyThreads.MathThreadRunner;
import toyThreads.util.Debug;

public class Factorizer implements MathThreadRunner {
  private int number;
  private int numberOfThreads;
  private Set<Integer> results;
  private List<Thread> threads;

  /**
   * @param number The number to factor.
   * @param numberOfThreads The number of threads to start.
   */
  public Factorizer(int number, int numberOfThreads) {
    Debug.LOGGER.finer("Entered Factorizer.Factorizer()");
    this.number = number;
    this.numberOfThreads = numberOfThreads;
    results = Collections.synchronizedSortedSet(new TreeSet<Integer>());
    threads = new ArrayList<Thread>();
  }

  /**
   * Starts all the threads; returns without waiting for threads to
   * finish.
   */
  public void start() {
    int range = number / numberOfThreads;
    for(int i = 1, start = 1; i <= numberOfThreads; ++i, start += range + 1) {
      int end = (i == numberOfThreads) ? number : start + range;
      Thread thread = new FactorizerThread(number, start, end, results);
      threads.add(thread);
    }
    for(Thread thread : threads) {
      thread.start();
    }
    results.add(number);
  }

  /**
   * Does not return until all threads have finished running.
   */
  public void waitForThreadsToFinish() throws InterruptedException {
    for(Thread thread : threads) {
      thread.join();
    }
  }

  /**
   * @return String containing the values of all data members; useful
   *   for inspection.
   */
  public String toString() {
    return "<number: " + number + ", numberOfThreads: " + numberOfThreads + ">";
  }

  public int getNumber() { return number; }
  public int getNumberOfThreads() { return numberOfThreads; }

  /**
   * @return The (sorted and synchronized) set of results.
   */
  public Set<Integer> getResults() { return results; }
}

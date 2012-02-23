package toyThreads.factors;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import toyThreads.util.Debug;
import toyThreads.factors.Results;

public class Factorizer {
  private int number;
  private int numberOfThreads;
  private Set<Integer> results;
  private List<Thread> threads;

  /**
   * @param number The number to factor.
   * @param numberOfThreads The number of threads to start.
   * @param results The set to which the results will be added.
   */
  public Factorizer(int number, int numberOfThreads, Set<Integer> results) {
    Debug.LOGGER.finer("Entered Factorizer.Factorizer()");
    this.number = number;
    this.numberOfThreads = numberOfThreads;
    this.results = results;
    threads = new ArrayList<Thread>();
  }

  /**
   * Starts all the threads; does not return until all threads are
   * finished
   */
  public void run() throws InterruptedException {
    int range = number / numberOfThreads;
    for(int i = 1, start = 1; i <= numberOfThreads; ++i, start += range + 1) {
      int end = (i == numberOfThreads) ? number : start + range;
      Thread thread = new FactorizerThread(number, start, end, results);
      threads.add(thread);
    }

    for(Thread thread : threads) { thread.start(); }

    results.add(number);

    for(Thread thread : threads) { thread.join(); }
  }

  /**
   * @return String containing the values of all data members; useful
   *   for inspection.
   */
  public String toString() {
    return "<number: " + number + ", numberOfThreads: " + numberOfThreads + ">";
  }
}

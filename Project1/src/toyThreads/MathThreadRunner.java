package toyThreads;

import java.util.Set;

public interface MathThreadRunner {
  /**
   * Starts all the threads; returns without waiting for threads to
   * finish.
   */
  public void start();

  /**
   * Does not return until all threads have finished running.
   */
  public void waitForThreadsToFinish() throws InterruptedException;

  public int getNumber();

  public int getNumberOfThreads();

  /**
   * @return The (sorted and synchronized) set of results.
   */
  public Set getResults();
}

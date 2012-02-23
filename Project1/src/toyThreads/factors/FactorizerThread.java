package toyThreads.factors;

import java.util.Set;

import toyThreads.util.Debug;
import toyThreads.factors.Results;

public class FactorizerThread extends Thread implements Runnable {
  private int number;
  private int startValue;
  private int endValue;
  private Set<Integer> results;

  /**
   * @param number The number to factor.
   * @param startValue The value to start checking at (inclusive).
   * @param endValue The value to stop checking at (inclusive).
   * @param results The set to which the results will be added.
   */
  public FactorizerThread(int number, int startValue, int endValue, Set<Integer> results) {
    super();
    Debug.LOGGER.finer("Entered FactorizerThread.FactorizerThread()");
    this.number = number;
    this.startValue = startValue;
    this.endValue = endValue;
    this.results = results;
  }

  /**
   * Begins factoring and adding the results
   */
  public void run() {
    Debug.LOGGER.finer("Starting FactorizerThread " + toString());
    for(int potentialFactor = startValue; potentialFactor <= endValue / 2; ++potentialFactor) {
      if(number % potentialFactor == 0) {
        results.add(potentialFactor);
      }
    }
    Debug.LOGGER.finer("Exited FactorizerThread " + toString());
  }

  /**
   * @return String containing the values of all data members; useful
   *   for inspection.
   */
  public String toString() {
    return "<ID: " + getId() + ", number: " + number + ", startValue: " + startValue + ", endValue: " + endValue + ">";
  }

  public int getNumber() { return number; }
  public int getStartValue() { return startValue; }
  public int getEndValue() { return endValue; }
}

package toyThreads.primeFactors;

import toyThreads.util.Debug;
import toyThreads.primeFactors.Results;

public class Factorizer implements Runnable {
  private int id;
  private int number;
  private int startValue;
  private int endValue;

  /**
   * @param id An ID for the thread; should be unique.
   * @param number The number to factor
   * @param startValue The value to start checking at (inclusive).
   * @param endValue The value to stop checking at (inclusive).
   */
  public Factorizer(int id, int number, int startValue, int endValue) {
    Debug.LOGGER.finer("Entered Factorizer.Factorizer()");
    this.id = id;
    this.number = number;
    this.startValue = startValue;
    this.endValue = endValue;
  }

  /**
   * Begins factoring and adding the results
   */
  public void run() {
    Debug.LOGGER.finer("Starting Factorizer thread " + id);

    for(int potentialFactor = startValue; potentialFactor <= endValue / 2; ++potentialFactor) {
      if(number % potentialFactor == 0) {
        Results.getInstance().add(potentialFactor);
      }
    }

    Debug.LOGGER.finer("Exited Factorizer thread " + id);
  }

  /**
   * @return String containing the values of all data members; useful
   *   for inspection.
   */
  public String toString() {
    return "<ID: " + id + ", number: " + number + ", startValue: " + startValue + ", endValue: " + endValue + ">";
  }
}

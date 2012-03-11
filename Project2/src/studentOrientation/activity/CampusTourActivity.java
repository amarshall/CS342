package studentOrientation.activity;

import studentOrientation.util.Currency;

public abstract class CampusTourActivity implements Activity {
  private int carbonFootprint;
  private Currency cost;
  private int effort;
  private int timeInMinutes;

  /**
   * @param carbonFootprint The carbon footprint in tons of C02.
   * @param cost The cost to take the tour.
   * @param effort The effort in calories.
   * @param timeInMinutes The time in minutes.
   */
  public CampusTourActivity(int carbonFootprint, Currency cost, int effort, int timeInMinutes) {
    this.carbonFootprint = carbonFootprint;
    this.cost = cost;
    this.effort = effort;
    this.timeInMinutes = timeInMinutes;
  }

  public int getCarbonFootprint() {
    return carbonFootprint;
  }

  public Currency getCost() {
    return cost;
  }

  public int getEffort() {
    return effort;
  }

  public int getTime() {
    return timeInMinutes;
  }
}

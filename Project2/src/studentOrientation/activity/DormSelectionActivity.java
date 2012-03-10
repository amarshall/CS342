package studentOrientation.activity;

import studentOrientation.util.Currency;

public abstract class DormSelectionActivity implements Activity {
  private int carbonFootprint;
  private Currency cost;
  private int effort;
  private int timeInMinutes;

  public DormSelectionActivity(int carbonFootprint, Currency cost, int effort, int timeInMinutes) {
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

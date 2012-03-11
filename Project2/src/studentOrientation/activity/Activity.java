package studentOrientation.activity;

import studentOrientation.util.Currency;

public interface Activity {
  public int getCarbonFootprint();
  public Currency getCost();
  public int getEffort();
  public int getTime();
}

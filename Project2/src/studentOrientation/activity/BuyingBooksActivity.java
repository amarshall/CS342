package studentOrientation.activity;

import studentOrientation.bookstore.Bookstore;
import studentOrientation.util.Currency;

public class BuyingBooksActivity implements Activity {
  private int carbonFootprint;
  private Currency cost;
  private int effort;
  private int timeInMinutes;

  /**
   * @param bookstore The bookstore the books are being bought at.
   * @param cost The retail cost of the books being bought.
   */
  public BuyingBooksActivity(Bookstore bookstore, Currency cost) {
    this.carbonFootprint = 100;
    this.cost = cost.multiply(bookstore.getCostFactor());
    this.effort = 10;
    this.timeInMinutes = 30;
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

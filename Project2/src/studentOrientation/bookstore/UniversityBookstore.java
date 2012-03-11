package studentOrientation.bookstore;

import studentOrientation.util.Currency;

public class UniversityBookstore implements Bookstore {
  private final double costFactor = 0.05;

  public double getCostFactor() {
    return costFactor;
  }
}

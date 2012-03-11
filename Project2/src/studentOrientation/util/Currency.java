package studentOrientation.util;

import java.math.BigDecimal;
import java.math.MathContext;

public class Currency {
  private BigDecimal value;
  private final MathContext mathContext = new MathContext(2);

  /**
   * @param dollars The number of dollars.
   * @param cents The number of cents.
   */
  public Currency(int dollars, int cents) {
    value = new BigDecimal(dollars + "." + cents, mathContext);
  }

  /**
   * @param value The monetary value.
   */
  public Currency(BigDecimal value) {
    this.value = value;
  }

  /**
   * @param c The currency to add
   * @return A new Currency that is the sum of this and the argument.
   */
  public Currency add(Currency c) {
    return new Currency(value.add(c.getValue()));
  }

  /**
   * @param d The value by which to multiply
   * @return A new Currency that is the product of this and the argument.
   */
  public Currency multiply(double d) {
    return new Currency(value.multiply(new BigDecimal(d, mathContext)));
  }

  public BigDecimal getValue() {
    return value;
  }

  public String toString() {
    return "$" + value;
  }
}

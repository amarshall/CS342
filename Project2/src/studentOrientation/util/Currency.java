package studentOrientation.util;

import java.math.BigDecimal;
import java.math.MathContext;

public class Currency {
  private BigDecimal value;
  private final MathContext mathContext = new MathContext(2);

  public Currency(int dollars, int cents) {
    value = new BigDecimal(dollars + "." + cents, mathContext);
  }

  public Currency(BigDecimal value) {
    this.value = value;
  }

  public Currency add(Currency c) {
    return new Currency(value.add(c.getValue()));
  }

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

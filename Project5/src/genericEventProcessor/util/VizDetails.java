package genericEventProcessor.util;

public class VizDetails extends SerializableObject {
  private Integer foo;
  private Double bar;

  public Integer getFoo() { return foo; }
  public void setFoo(Integer foo) { this.foo = foo; }
  public Double getBar() { return bar; }
  public void setBar(Double bar) { this.bar = bar; }

  public boolean equals(VizDetails other) {
    boolean equal = true;
    equal = equal && getFoo().equals(other.getFoo());
    equal = equal && getBar().equals(other.getBar());
    return equal;
  }
}

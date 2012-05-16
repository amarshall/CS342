package genericEventProcessor.util;

public class ExecDetails extends SerializableObject {
  private Integer foo;
  private Integer bar;

  public Integer getFoo() { return foo; }
  public void setFoo(Integer foo) { this.foo = foo; }
  public Integer getBar() { return bar; }
  public void setBar(Integer bar) { this.bar = bar; }

  public boolean equals(ExecDetails other) {
    boolean equal = true;
    equal = equal && getFoo().equals(other.getFoo());
    equal = equal && getBar().equals(other.getBar());
    return equal;
  }
}

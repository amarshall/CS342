package genericEventProcessor.util;

public class VizDetails extends SerializableObject {
  private Integer foo;
  private Double baz;

  public Integer getFoo() { return foo; }
  public void setFoo(Integer foo) { this.foo = foo; }
  public Double getBaz() { return baz; }
  public void setBaz(Double baz) { this.baz = baz; }

  public boolean equals(VizDetails other) {
    boolean equal = true;
    equal = equal && getFoo().equals(other.getFoo());
    equal = equal && getBaz().equals(other.getBaz());
    return equal;
  }
}

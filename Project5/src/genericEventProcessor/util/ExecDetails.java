package genericEventProcessor.util;

public class ExecDetails extends SerializableObject {
  private int foo;
  private int bar;

  public int getFoo() { return foo; }
  public void setFoo(int foo) { this.foo = foo; }
  public int getBar() { return bar; }
  public void setBar(int bar) { this.bar = bar; }
}

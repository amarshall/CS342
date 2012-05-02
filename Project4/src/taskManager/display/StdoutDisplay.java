package taskManager.display;

import java.util.Observable;

import taskManager.tabs.Tab;

public class StdoutDisplay implements Display {
  public void update(Observable o, Object arg) {
    Tab t = (Tab)o;
    System.out.println(t.display());
  }
}

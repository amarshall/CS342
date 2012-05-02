package taskManager.tabs;

import java.util.Observable;
import java.util.Observer;

public abstract class Tab extends Observable implements Observer {
  public abstract String display();
  public void update(Observable o) { update(o, null); }
}

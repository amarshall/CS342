package taskManager.tabs;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import taskManager.data.Performance;

public class PerformanceTab extends Tab {
  private List<Performance> performances;

  public PerformanceTab() {
    performances = new ArrayList<Performance>();
  }

  public String display() {
    return performances.get(performances.size() - 1).toString();
  }

  public void update(Observable o, Object arg) {
    o.addObserver(this);
    performances.add((Performance)o);
    setChanged();
    notifyObservers();
  }
}

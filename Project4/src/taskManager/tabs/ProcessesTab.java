package taskManager.tabs;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import taskManager.data.Process;

public class ProcessesTab extends Tab {
  private List<Process> processes;

  public ProcessesTab() {
    processes = new ArrayList<Process>();
  }

  public String display() {
    return processes.get(processes.size() - 1).toString();
  }

  public void update(Observable o, Object arg) {
    o.addObserver(this);
    processes.add((Process)o);
    setChanged();
    notifyObservers();
  }
}

package taskManager.driver;

import java.io.File;
import java.util.Observer;

import taskManager.TaskManager;
import taskManager.display.Display;
import taskManager.display.NullDisplay;
import taskManager.display.StdoutDisplay;
import taskManager.data.Process;
import taskManager.tabs.ProcessesTab;
import taskManager.tabs.Tab;

public class Driver {
  private static int debugLevel;

  public static void main(String[] args) {
    debugLevel = 1;

    Display display;
    if(debugLevel >= 1) {
      display = new StdoutDisplay();
    } else {
      display = new NullDisplay();
    }
    TaskManager taskManager = new TaskManager(new File("data/input.txt"), display);
    taskManager.processInput();
  }
}

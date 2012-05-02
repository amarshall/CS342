package taskManager.driver;

import java.io.File;
import java.util.Observer;

import taskManager.TaskManager;
import taskManager.display.Display;
import taskManager.display.StdoutDisplay;
import taskManager.data.Process;
import taskManager.tabs.ProcessesTab;
import taskManager.tabs.Tab;

public class Driver {
  public static void main(String[] args) {
    Display display = new StdoutDisplay();
    TaskManager taskManager = new TaskManager(new File("data/input.txt"), display);
    taskManager.processInput();
  }
}

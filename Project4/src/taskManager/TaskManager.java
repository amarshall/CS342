package taskManager;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Observable;
import java.util.Scanner;

import taskManager.display.Display;
import taskManager.data.Process;
// import taskManager.data.System;
// import taskManager.data.User;
// import taskManager.tabs.PerformanceTab;
import taskManager.tabs.ProcessesTab;
// import taskManager.tabs.UsersTab;

public class TaskManager extends Observable {
  private Display display;
  // private PerformanceTab performanceTab;
  private ProcessesTab processesTab;
  // private UsersTab usersTab;
  private File input;

  public TaskManager(File input, Display display) {
    this.input = input;
    this.display = display;
    processesTab = new ProcessesTab();
    processesTab.addObserver(display);
    // performanceTab = new PerformanceTab();
    // performanceTab.addObserver(display);
    // usersTab = new UsersTab();
    // usersTab.addObserver(display);
  }

  public void processInput() {
    Scanner reader = null;
    try {
      reader = new Scanner(input);
      while(reader.hasNext()) {
        String line = reader.nextLine();
        if(line.length() > 0) {
          filterInput(line);
        }
      }
    } catch(FileNotFoundException e) {
      System.err.println("File " + input + " not found.");
      System.exit(1);
    } finally {
      if(reader != null) reader.close();
    }
  }

  public void filterInput(String line) {
    String[] l = line.split(":");
    String tab = l[0];
    String[] fields = l[1].split(",");
    if(tab.equals("process")) {
      Process p = null;
      try {
        p = new Process(fields[0], fields[1], Double.parseDouble(fields[2]), Integer.parseInt(fields[3]), fields[4]);
      } catch(NumberFormatException e) {
        System.err.println("Bad input.");
        System.exit(1);
      }
      processesTab.update(p);
    }
  }
}

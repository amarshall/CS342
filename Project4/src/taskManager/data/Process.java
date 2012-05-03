package taskManager.data;

import java.util.Observable;

public class Process extends Observable {
  private String name;
  private String owner;
  private double cpuUsage;
  private double memoryUsage;
  private String description;

  public Process(String name, String owner, double cpuUsage, double memoryUsage, String description) {
    this.name = name;
    this.owner = owner;
    this.cpuUsage = cpuUsage;
    this.memoryUsage = memoryUsage;
    this.description = description;
  }

  public String getName() { return name; }
  public String getOwner() { return owner; }
  public double getCpuUsage() { return cpuUsage; }
  public double getMemoryUsage() { return memoryUsage; }
  public String getDescription() { return description; }

  public void setName(String name) { this.name = name; setChanged(); }
  public void setOwner(String owner) { this.owner = owner; setChanged(); }
  public void setCpuUsage(double cpuUsage) { this.cpuUsage = cpuUsage; setChanged(); }
  public void setMemoryUsage(double memoryUsage) { this.memoryUsage = memoryUsage; setChanged(); }
  public void setDescription(String description) { this.description = description; setChanged(); }

  public String toString() {
    return "Process '"      + getName()        + "' | " + 
           "Owner: '"       + getOwner()       + "' | " +
           "CpuUsage: '"    + getCpuUsage()    + "' | " +
           "MemoryUsage: '" + getMemoryUsage() + "' | " +
           "Description: '" + getDescription() + "'";
  }
}

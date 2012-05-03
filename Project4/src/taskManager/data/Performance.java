package taskManager.data;

import java.util.Observable;

public class Performance extends Observable {
  private double memoryUsage;
  private double cpuUsage;
  private double totalMemory;
  private double totalCached;

  public Performance(double memoryUsage, double cpuUsage, double totalMemory, double totalCached) {
    this.memoryUsage = memoryUsage;
    this.cpuUsage = cpuUsage;
    this.totalMemory = totalMemory;
    this.totalCached = totalCached;
  }

  public double getMemoryUsage() { return memoryUsage; }
  public double getCpuUsage() { return cpuUsage; }
  public double getTotalMemory() { return totalMemory; }
  public double getTotalCached() { return totalCached; }

  public void setMemoryUsage(double memoryUsage) { this.memoryUsage = memoryUsage; setChanged(); }
  public void setCpuUsage(double cpuUsage) { this.cpuUsage = cpuUsage; setChanged(); }
  public void TotalMemory(double totalMemory) { this.totalMemory = totalMemory; setChanged(); }
  public void setTotalCached(double totalCached) { this.totalCached = totalCached; setChanged(); }

  public String toString() {
    return "MemoryUsage: '" + getMemoryUsage() + "' | " +
           "CpuUsage: '"    + getCpuUsage()    + "' | " +
           "Total Memory '" + getTotalMemory() + "' | " +
           "Total Cached: '"+ getTotalCached() + "'";
  }
}

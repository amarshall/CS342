package toyThreads;

import java.util.Set;

public interface MathThreadRunner {
  public void start();
  public void waitForThreadsToFinish() throws InterruptedException;

  public int getNumber();
  public int getNumberOfThreads();
  public Set getResults();
}

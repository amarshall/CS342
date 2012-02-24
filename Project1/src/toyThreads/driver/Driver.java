package toyThreads.driver;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import toyThreads.factors.Factorizer;
import toyThreads.util.Debug;
import toyThreads.util.LogFormatter;

public class Driver {
  private static int number;
  private static int numberOfThreads;
  private static List<Thread> threads;

  public static void main(String[] args) {
    if(args.length != 3) {
      System.err.println("Arguments are: <number> <number_of_threads> <debug_level>");
      System.exit(128);
    }

    try {
      if(!Debug.setLogLevel(Integer.parseInt(args[2]))) {
        System.err.println("Debug level must be between 5 & 10, inclusive.");
        System.exit(128);
      }
      number = Integer.parseInt(args[0]);
      numberOfThreads = Integer.parseInt(args[1]);
      Debug.LOGGER.info("Received args: " + Arrays.deepToString(args));
    } catch(NumberFormatException e) {
      System.err.println("All argument must be integers");
      System.exit(128);
    } finally {}

    if(!numberIsValid()) {
      System.err.println("Number must be greater than zero.");
      System.exit(128);
    }
    if(!numberOfThreadsIsValid()) {
      System.err.println("Number of threads must be between 1 & 5, inclusive.");
      System.exit(128);
    }

    Factorizer factorizer = new Factorizer(number, numberOfThreads);
    factorizer.start();
    try {
      factorizer.waitForThreadsToFinish();
    } catch(InterruptedException e) {
      e.printStackTrace();
      System.exit(1);
    } finally {}

    System.out.println("Results: " + factorizer.getResults());
  }

  private static boolean numberIsValid() {
    return number > 0;
  }

  private static boolean numberOfThreadsIsValid() {
    return numberOfThreads >= 1 && numberOfThreads <= 5;
  }
}

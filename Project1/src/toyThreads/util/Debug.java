package toyThreads.util;

import java.util.logging.ConsoleHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Debug {
  public static Logger LOGGER = Logger.getLogger("toyThreads");

  static {
    Handler handler = new ConsoleHandler();
    handler.setLevel(Level.ALL);
    handler.setFormatter(new LogFormatter());
    Debug.LOGGER.addHandler(handler);
    Debug.LOGGER.setUseParentHandlers(false);
  }

  private Debug() {}

  /**
   * @param l The level to set logging to, between 5 and 10.
   * @return If the level given was valid.
   */
  public static boolean setLogLevel(int l) {
    Level level;
    switch(l) {
      case 9:
      case 10:
        level = Level.FINEST;
        break;
      case 7:
      case 8:
        level = Level.FINE;
        break;
      case 6:
        level = Level.INFO;
        break;
      case 5:
      default:
        level = Level.WARNING;
        break;
    }
    LOGGER.setLevel(level);
    return l >=5 && l <= 10;
  }
}

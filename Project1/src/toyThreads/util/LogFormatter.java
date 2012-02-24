package toyThreads.util;

import java.util.logging.Formatter;
import java.util.logging.LogRecord;

public class LogFormatter extends Formatter {
  public synchronized String format(LogRecord record) {
    StringBuffer string = new StringBuffer();
    string.append(record.getLevel().getName());
    string.append(": ");
    string.append(formatMessage(record));
    string.append("\n");
    return string.toString();
  }
}

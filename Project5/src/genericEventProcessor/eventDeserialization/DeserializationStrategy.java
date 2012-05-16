package genericEventProcessor.eventDeserialization;

import java.lang.Class;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Set;

public interface DeserializationStrategy {
  public void parse(String input);
  public Set<String> fieldNames();
  public String fieldType(String fieldName);
  public String fieldValue(String fieldName);
  public String objectClass();
}

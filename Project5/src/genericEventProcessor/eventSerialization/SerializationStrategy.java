package genericEventProcessor.eventSerialization;

import java.lang.Class;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;

public interface SerializationStrategy {
  public void addField(Field field, Object value);
  public void addObject(Object object);
  public void endObject();

  public void addCallingMethod(Method method);
  public void addCallingArgs(Object[] args);
  public void addCallingClass(Class klass);

  public List<String> getOutput();
  public String fileExtension();
}

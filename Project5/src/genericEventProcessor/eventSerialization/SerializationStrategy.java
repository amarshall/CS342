package genericEventProcessor.eventSerialization;

import java.lang.reflect.Field;
import java.util.List;

public interface SerializationStrategy {
  public void addField(Field field, Object value);
  public void addObject(Object object);
  public void endObject();
  public List<String> getOutput();
  public String fileExtension();
}

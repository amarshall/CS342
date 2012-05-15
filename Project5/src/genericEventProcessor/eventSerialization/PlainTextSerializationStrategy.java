package genericEventProcessor.eventSerialization;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class PlainTextSerializationStrategy implements SerializationStrategy {
  private List<String> output;

  public PlainTextSerializationStrategy() {
    output = new ArrayList<String>();
  }

  public void addField(Field field, Object value) {
    String name = field.getName();
    String typeName = field.getType().getName();
    output.add(typeName + ":" + name + ":" + value);
  }

  public void addObject(Object object) {
    String name = object.getClass().getName();
    output.add(name);
  }

  public void endObject() {}

  public List<String> getOutput() {
    return output;
  }

  public String fileExtension() { return ".txt"; }
}

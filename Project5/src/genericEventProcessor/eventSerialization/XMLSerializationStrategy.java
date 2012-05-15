package genericEventProcessor.eventSerialization;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class XMLSerializationStrategy implements SerializationStrategy {
  private List<String> output;

  public XMLSerializationStrategy() {
    output = new ArrayList<String>();
  }

  public void addField(Field field, Object value) {
    String name = field.getName();
    String typeName = field.getType().getName();
    output.add("<field name='" + name + "' class='" + typeName + "'>" + value + "</field>");
  }

  public void addObject(Object object) {
    String name = object.getClass().getName();
    output.add("<object class='" + name + "'>");
  }

  public void endObject() {
    output.add("</object>");
  }

  public List<String> getOutput() {
    return output;
  }

  public String fileExtension() { return ".xml"; }
}

package genericEventProcessor.eventSerialization;

import java.lang.Class;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
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
    output.add("field:" + typeName + ":" + name + ":" + value);
  }

  public void addObject(Object object) {
    String name = object.getClass().getName();
    output.add(name);
  }

  public void endObject() {}

  public void addCallingMethod(Method method) {
    output.add("method:" + method.getName());
  }

  public void addCallingArgs(Object[] args) {
    for(Object o : args) {
      String typeName = o.getClass().getName();
      output.add("arg:" + typeName + ":" + o);
    }
  }

  public void addCallingClass(Class klass) {
    output.add("class:" + klass.getName());
  }

  public List<String> getOutput() {
    return output;
  }

  public String fileExtension() { return ".txt"; }
}

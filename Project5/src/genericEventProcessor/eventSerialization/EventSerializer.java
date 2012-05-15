package genericEventProcessor.eventSerialization;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;

import genericEventProcessor.eventSerialization.PlainTextSerializationStrategy;
import genericEventProcessor.eventSerialization.SerializationStrategy;
import genericEventProcessor.eventSerialization.XMLSerializationStrategy;
import genericEventProcessor.util.LogStore;
import genericEventProcessor.util.SerializableObject;

public class EventSerializer implements InvocationHandler {
  public Object invoke(Object proxy, Method method, Object[] args) {
    String methodName = method.getName();
    Class klass = method.getDeclaringClass();
    SerializableObject object = (SerializableObject) args[0];
    Integer sequenceNumber = (Integer) args[1];
    String format = (String) args[2];

    SerializationStrategy serializer = null;
    if(format.equals("xml")) {
      serializer = new XMLSerializationStrategy();
    } else if(format.equals("plaintext")) {
      serializer = new PlainTextSerializationStrategy();
    } else {
      System.err.println("Invalid serialization format");
      System.exit(1);
    }

    serializer.addObject(object);

    // FIXME add these to the serialization strategy
    // for(Object o : args) { output.add("arg : " + o.getClass().getName()); }
    // output.add("method : " + methodName);
    // output.add("class : " + klass.getName());

    for(Field field : object.getClass().getDeclaredFields()) {
      try {
        Method accessor = getAccessorMethod(object.getClass(), field);
        Object value = accessor.invoke(object);
        serializer.addField(field, value);
      } catch(java.lang.IllegalAccessException e) {
        System.exit(1);
      } catch(java.lang.reflect.InvocationTargetException e) {
        System.exit(1);
      }
    }
    serializer.endObject();
    writeFile(sequenceNumber + serializer.fileExtension(), serializer.getOutput());

    return null;
  }

  private Method getAccessorMethod(Class<?> klass, Field field) {
    String name = field.getName();
    name = Character.toUpperCase(name.charAt(0)) + name.substring(1);
    Method m = null;
    try {
      m = klass.getMethod("get" + name);
    } catch(java.lang.NoSuchMethodException e) {
      System.exit(1);
    }
    return m;
  }

  private void writeFile(String filename, List<String> contents) {
    try {
      BufferedWriter bw = new BufferedWriter(new FileWriter(filename));
      for(String s : contents) {
        bw.write(s);
        bw.newLine();
      }
      bw.close();
    } catch(IOException x) {
      System.err.format("IOException: %s%n", x);
      System.exit(1);
    } finally {}
  }
}

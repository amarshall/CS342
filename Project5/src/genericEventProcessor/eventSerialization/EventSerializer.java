package genericEventProcessor.eventSerialization;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import genericEventProcessor.util.LogStore;
import genericEventProcessor.util.SerializableObject;

public class EventSerializer implements InvocationHandler {
  public Object invoke(Object proxy, Method method, Object[] args) {
    String methodName = method.getName();
    Class klass = method.getDeclaringClass();
    SerializableObject object = (SerializableObject) args[0];
    Integer sequenceNumber = (Integer) args[1];
    String format = (String) args[2];

    List<String> output = new ArrayList<String>();

    if(object.getClass() == LogStore.class) {
      if(format.equals("xml")) {

        output.add("<object class='" + object.getClass().getName() + "'>");
        for(Method m : object.getClass().getMethods()) {
          String name = m.getName();
          if(name.startsWith("get")) {
            name = name.substring(3);
            try {
              Object value = m.invoke(object);
              output.add("<field name='" + name + "' type='" + m.getReturnType() + "'>" + value + "</field>");
            } catch(java.lang.IllegalAccessException e) {
              System.exit(1);
            } catch(java.lang.reflect.InvocationTargetException e) {
              System.exit(1);
            }
          }
        }
        output.add("</object>");

        writeFile(sequenceNumber + ".xml", output);
      } else if(format.equals("plain")) {

        for(Object o : args) { output.add("arg : " + o.getClass().getName()); }
        output.add("method : " + methodName);
        output.add("class : " + klass.getName());
        for(Method m : object.getClass().getMethods()) {
          if(m.getName().startsWith("get")) {
            try {
              Object value = m.invoke(object);
              output.add(m.getReturnType() + " : " + value);
            } catch(java.lang.IllegalAccessException e) {
              System.exit(1);
            } catch(java.lang.reflect.InvocationTargetException e) {
              System.exit(1);
            }
          }
        }
        writeFile(sequenceNumber + ".txt", output);

      }
    }

    return null;
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

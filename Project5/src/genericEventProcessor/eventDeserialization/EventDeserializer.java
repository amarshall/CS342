package genericEventProcessor.eventDeserialization;

import java.lang.Class;
import java.lang.ClassNotFoundException;
import java.lang.IllegalAccessException;
import java.lang.InstantiationException;
import java.lang.NoSuchMethodException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class EventDeserializer implements InvocationHandler {
  public Object invoke(Object o, Method m, Object[] args) {
    String input = (String)args[0];
    DeserializationStrategy deserializer = (DeserializationStrategy)args[1];
    DeserializedObject rawObject = deserializer.parse(input);
    Object object = null;

    try {
      Class<?> klass = Class.forName(rawObject.getType());
      object = klass.newInstance();
      for(Field field : rawObject.getFields()) {
        Class<?> valueClass = Class.forName(field.getType());
        Constructor valueConstructor = valueClass.getConstructor(String.class);
        Object value = valueConstructor.newInstance(field.getValue());

        Method writerMethod = getWriterMethod(klass, field.getName(), valueClass);
        writerMethod.invoke(object, value);
      }
    } catch(ClassNotFoundException e) {
      System.err.println("Class not found");
      e.printStackTrace();
      System.exit(1);
    } catch(IllegalAccessException e) {
      System.err.println("Illegal access");
      e.printStackTrace();
      System.exit(1);
    } catch(InstantiationException e) {
      System.err.println("Instantiation failure");
      e.printStackTrace();
      System.exit(1);
    } catch(InvocationTargetException e) {
      System.err.println("Invocation failure");
      e.printStackTrace();
      System.exit(1);
    } catch(NoSuchMethodException e) {
      System.err.println("No such method");
      e.printStackTrace();
      System.exit(1);
    }

    return object;
  }

  private Method getWriterMethod(Class<?> klass, String name, Class<?> argClass) {
    name = Character.toUpperCase(name.charAt(0)) + name.substring(1);
    Method m = null;
    try {
      m = klass.getDeclaredMethod("set" + name, argClass);
    } catch(java.lang.NoSuchMethodException e) {
      System.err.println("No such method");
      e.printStackTrace();
      System.exit(1);
    }
    return m;
  }
}

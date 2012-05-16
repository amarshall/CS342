package genericEventProcessor.eventDeserialization;

import java.lang.Class;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class PlainTextDeserializationStrategy implements DeserializationStrategy {
  private String objectClass;
  private Set<String> fieldNames;
  private Map<String, String> fieldTypes;
  private Map<String, String> fieldValues;

  public PlainTextDeserializationStrategy() {
    objectClass = "";
    fieldNames = new HashSet<String>();
    fieldTypes = new HashMap<String, String>();
    fieldValues = new HashMap<String, String>();
  }

  public void parse(String input) {
    String[] lines = input.split("\n");
    for(String line : lines) {
      if(line.startsWith("object:")) {
        parseObjectTag(line);
      } else if(line.startsWith("field:")) {
        parseFieldTag(line);
      }
    }
  }

  public Set<String> fieldNames() {
    return fieldNames;
  }

  public String fieldType(String fieldName) {
    return fieldTypes.get(fieldName);
  }

  public String fieldValue(String fieldName) {
    return fieldValues.get(fieldName);
  }

  public String objectClass() {
    return objectClass;
  }

  private void parseObjectTag(String line) {
    String[] parts = line.split(":");
    objectClass = parts[1];
  }

  private void parseFieldTag(String line) {
    String[] parts = line.split(":");
    String name = parts[2];
    String type = parts[1];
    String value = parts[3];
    fieldNames.add(name);
    fieldTypes.put(name, type);
    fieldValues.put(name, value);
  }
}

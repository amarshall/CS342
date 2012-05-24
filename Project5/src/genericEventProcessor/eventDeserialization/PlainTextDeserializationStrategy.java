package genericEventProcessor.eventDeserialization;

import java.lang.Class;
import java.util.HashSet;
import java.util.Set;

public class PlainTextDeserializationStrategy implements DeserializationStrategy {
  public DeserializedObject parse(String input) {
    String type = "";
    Set<Field> fields = new HashSet<Field>();

    String[] lines = input.split("\n");
    for(String line : lines) {
      if(line.startsWith("object:")) {
        type = parseObjectTag(line);
      } else if(line.startsWith("field:")) {
        Field f = parseFieldTag(line);
        fields.add(f);
      }
    }

    return new DeserializedObject(type, fields);
  }

  private String parseObjectTag(String line) {
    String[] parts = line.split(":");
    String objectClass = parts[1];
    return objectClass;
  }

  private Field parseFieldTag(String line) {
    String[] parts = line.split(":");
    String name = parts[2];
    String type = parts[1];
    String value = parts[3];
    return new Field(name, type, value);
  }
}

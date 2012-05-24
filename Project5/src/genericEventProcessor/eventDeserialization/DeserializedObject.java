package genericEventProcessor.eventDeserialization;

import java.util.Set;

public class DeserializedObject {
  private String type;
  private Set<Field> fields;

  public DeserializedObject(String type, Set<Field> fields) {
    this.type = type;
    this.fields = fields;
  }

  public String getType() { return type; }
  public Set<Field> getFields() { return fields; }
}

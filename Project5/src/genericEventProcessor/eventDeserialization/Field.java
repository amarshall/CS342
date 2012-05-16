package genericEventProcessor.eventDeserialization;

public class Field {
  private String name;
  private String type;
  private String value;

  public Field(String name, String type, String value) {
    this.name = name;
    this.type = type;
    this.value = value;
  }

  public String getName() { return name; }
  public String getType() { return type; }
  public String getValue() { return value; }
}

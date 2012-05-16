package genericEventProcessor.eventDeserialization;

import java.lang.Class;
import java.util.Set;

import genericEventProcessor.eventDeserialization.Field;

public interface DeserializationStrategy {
  public DeserializedObject parse(String input);
}

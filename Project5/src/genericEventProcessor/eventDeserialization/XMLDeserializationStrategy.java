package genericEventProcessor.eventDeserialization;

import java.lang.Class;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class XMLDeserializationStrategy implements DeserializationStrategy {
  public DeserializedObject parse(String input) {
    String type = "";
    Set<Field> fields = new HashSet<Field>();

    String[] lines = input.split("\n");
    for(String line : lines) {
      if(line.startsWith("<object")) {
        type = parseObjectTag(line);
      } else if(line.startsWith("<field")) {
        Field f = parseFieldTag(line);
        fields.add(f);
      }
    }

    return new DeserializedObject(type, fields);
  }

  private String parseObjectTag(String line) {
    Pattern pattern = Pattern.compile("class='([^']+)'");
    Matcher matcher = pattern.matcher(line);
    matcher.find();
    String objectClass = matcher.group(1);
    return objectClass;
  }

  private Field parseFieldTag(String line) {
    String name = "";
    String type = "";
    String value = "";
    {
      Pattern pattern = Pattern.compile(" (\\w+)='([^']+)'");
      Matcher matcher = pattern.matcher(line);
      while(matcher.find()) {
        String k = matcher.group(1);
        String v = matcher.group(2);
        if(k.equals("name")) {
          name = v;
        } else if(k.equals("class")) {
          type = v;
        }
      }
    }
    {
      Pattern pattern = Pattern.compile(">([^<>]+)<");
      Matcher matcher = pattern.matcher(line);
      matcher.find();
      value = matcher.group(1);
    }
    return new Field(name, type, value);
  }
}

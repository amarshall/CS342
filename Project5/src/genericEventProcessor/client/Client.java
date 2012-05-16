package genericEventProcessor.client;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import genericEventProcessor.eventDeserialization.EventDeserializer;
import genericEventProcessor.eventDeserialization.PlainTextDeserializationStrategy;
import genericEventProcessor.eventDeserialization.DeserializationStrategy;
import genericEventProcessor.eventDeserialization.XMLDeserializationStrategy;
import genericEventProcessor.eventSerialization.EventSerializer;
import genericEventProcessor.eventSerialization.PlainTextSerializationStrategy;
import genericEventProcessor.eventSerialization.SerializationStrategy;
import genericEventProcessor.eventSerialization.XMLSerializationStrategy;
import genericEventProcessor.server.execution.RemoteExecution;
import genericEventProcessor.server.RemoteEvent;
import genericEventProcessor.server.logger.RemoteLogger;
import genericEventProcessor.server.viz.RemoteViz;
import genericEventProcessor.util.ExecDetails;
import genericEventProcessor.util.LogStore;
import genericEventProcessor.util.VizDetails;
import genericEventProcessor.util.ProxyCreator;

public class Client {
  public static void main(String[] args) {
    ProxyCreator pc = new ProxyCreator();
    Class[] classes = new Class[] { RemoteExecution.class, RemoteLogger.class, RemoteViz.class };

    {
      ExecDetails before;
      ExecDetails after;

      RemoteExecution serializedEvent = (RemoteExecution) pc.createProxy(classes, new EventSerializer());
      before = new ExecDetails();
      before.setFoo(314);
      before.setBar(true);
      serializedEvent.writeExecution(before, 117, new PlainTextSerializationStrategy());

      RemoteExecution deserializedEvent = (RemoteExecution) pc.createProxy(classes, new EventDeserializer());
      String data = readFile("117.txt");
      after = (ExecDetails) deserializedEvent.readExecution(data, new PlainTextDeserializationStrategy());

      assert before.equals(after);
    }
    {
      VizDetails before;
      VizDetails after;

      RemoteViz serializedEvent = (RemoteViz) pc.createProxy(classes, new EventSerializer());
      before = new VizDetails();
      before.setFoo(42);
      before.setBar(3.14);
      serializedEvent.writeViz(before, 118, new PlainTextSerializationStrategy());

      RemoteViz deserializedEvent = (RemoteViz) pc.createProxy(classes, new EventDeserializer());
      String data = readFile("118.txt");
      after = (VizDetails) deserializedEvent.readViz(data, new PlainTextDeserializationStrategy());

      assert before.equals(after);
    }
    {
      LogStore before;
      LogStore after;

      RemoteLogger serializedEvent = (RemoteLogger) pc.createProxy(classes, new EventSerializer());
      before = new LogStore();
      before.setFoo(314);
      before.setBar(42);
      serializedEvent.writeLogger(before, 119, new PlainTextSerializationStrategy());

      RemoteLogger deserializedEvent = (RemoteLogger) pc.createProxy(classes, new EventDeserializer());
      String data = readFile("119.txt");
      after = (LogStore) deserializedEvent.readLogger(data, new PlainTextDeserializationStrategy());

      assert before.equals(after);
    }
  }

  private static String readFile(String filename) {
    String data = "";
    File file = new File(filename);
    try {
      Scanner scanner = new Scanner(file);
      while(scanner.hasNextLine()) {
        data += scanner.nextLine() + "\n";
      }
      scanner.close();
    } catch(FileNotFoundException e) {
      System.err.println("File not found");
      System.exit(1);
    } finally {}
    return data;
  }
}

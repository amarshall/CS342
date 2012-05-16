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
import genericEventProcessor.util.LogStore;
import genericEventProcessor.util.ProxyCreator;

public class Client {
  public static void main(String[] args) {
    ProxyCreator pc = new ProxyCreator();

    // create a proxy
    RemoteEvent serializedEvent = pc.createProxy(new Class[] {
        RemoteExecution.class, RemoteLogger.class, RemoteViz.class
    }, new EventSerializer());

    // invoke a method on the proxy
    LogStore store = new LogStore();
    store.setFoo(314);
    store.setBar(42);
    ((RemoteLogger) serializedEvent).writeLogger(store, 117, new PlainTextSerializationStrategy());

    // rest of the code for invoking methods on other interfaces using the
    // proxy reference

    // use remote proxy to deserialize object
    RemoteEvent deserializedEvent = pc.createProxy(new Class[] {
        RemoteExecution.class, RemoteLogger.class, RemoteViz.class
    }, new EventDeserializer());

    String data = readFile("117.txt");
    LogStore anotherStore = (LogStore) ((RemoteLogger) deserializedEvent).readLogger(data, new PlainTextDeserializationStrategy());
    System.out.println(anotherStore.getFoo());
    System.out.println(anotherStore.getBar());

    // compare and confirm that anotherStore and store are the same
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

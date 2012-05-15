package genericEventProcessor.client;

import genericEventProcessor.eventDeserialization.EventDeserializer;
import genericEventProcessor.eventSerialization.EventSerializer;
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
    ((RemoteLogger) serializedEvent).writeLogger(store, 117, "xml");

    // rest of the code for invoking methods on other interfaces using the
    // proxy reference

    // use remote proxy to deserialize object
    RemoteEvent deserializedEvent = pc.createProxy(new Class[] {
        RemoteExecution.class, RemoteLogger.class, RemoteViz.class
    }, new EventDeserializer());

    // LogStore anotherStore = (LogStore) ((RemoteLogger) deserializedEvent).readLogger(builder.toString(), "xml");

    // compare and confirm that anotherStore and store are the same
  }
}

package genericEventProcessor.server.logger;

import genericEventProcessor.eventDeserialization.DeserializationStrategy;
import genericEventProcessor.eventSerialization.SerializationStrategy;
import genericEventProcessor.server.RemoteEvent;
import genericEventProcessor.util.LogStore;
import genericEventProcessor.util.SerializableObject;

public interface RemoteLogger extends RemoteEvent {
  void writeLogger(LogStore logStoreIn, int sequenceNo, SerializationStrategy serializationFormat);
  SerializableObject readLogger(String wireFormat, DeserializationStrategy serializationFormat);
}

package genericEventProcessor.server.logger;

import genericEventProcessor.server.RemoteEvent;
import genericEventProcessor.util.LogStore;
import genericEventProcessor.util.SerializableObject;

public interface RemoteLogger extends RemoteEvent {
  void writeLogger(LogStore logStoreIn, int sequenceNo, String serializationFormat);
  SerializableObject readLogger(String wireFormat, String serializationFormat);
}

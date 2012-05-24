package genericEventProcessor.server.execution;

import genericEventProcessor.eventDeserialization.DeserializationStrategy;
import genericEventProcessor.eventSerialization.SerializationStrategy;
import genericEventProcessor.server.RemoteEvent;
import genericEventProcessor.util.ExecDetails;
import genericEventProcessor.util.LogStore;
import genericEventProcessor.util.SerializableObject;

public interface RemoteExecution extends RemoteEvent {
  void writeExecution(ExecDetails execDetailsIn, int sequenceNo, SerializationStrategy serializationFormat);
  SerializableObject readExecution(String wireFormat, DeserializationStrategy serializationFormat);
}

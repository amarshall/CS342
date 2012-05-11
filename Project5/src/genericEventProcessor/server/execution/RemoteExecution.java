package genericEventProcessor.server.execution;

import genericEventProcessor.server.RemoteEvent;
import genericEventProcessor.util.ExecDetails;
import genericEventProcessor.util.LogStore;
import genericEventProcessor.util.SerializableObject;

public interface RemoteExecution extends RemoteEvent {
  void writeExecution(ExecDetails execDetailsIn, int sequenceNo, String serializationFormat);
  SerializableObject readExecution(String wireFormat, String serializationFormat);
}

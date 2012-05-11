package genericEventProcessor.server.viz;

import genericEventProcessor.server.RemoteEvent;
import genericEventProcessor.util.LogStore;
import genericEventProcessor.util.SerializableObject;
import genericEventProcessor.util.VizDetails;

public interface RemoteViz extends RemoteEvent {
  void writeViz(VizDetails vizDetailsIn, int sequenceNo, String serializationFormat);
  SerializableObject readViz(String wireFormat, String serializationFormat);
}

package genericEventProcessor.server.viz;

import genericEventProcessor.eventDeserialization.DeserializationStrategy;
import genericEventProcessor.eventSerialization.SerializationStrategy;
import genericEventProcessor.server.RemoteEvent;
import genericEventProcessor.util.LogStore;
import genericEventProcessor.util.SerializableObject;
import genericEventProcessor.util.VizDetails;

public interface RemoteViz extends RemoteEvent {
  void writeViz(VizDetails vizDetailsIn, int sequenceNo, SerializationStrategy serializationFormat);
  SerializableObject readViz(String wireFormat, DeserializationStrategy serializationFormat);
}

package main.controlstation;

import main.model.TimingstationData;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service("controllingStationService")
public class ControllingStationService {
    private static final HashMap<String, TimingstationData> data = new HashMap<>();

    public void updateData(TimingstationData timingstationData) {
        data.put(timingstationData.getTimingstationID(), timingstationData);
    }

    public TimingstationData getTimingstationData(String inTimingstationID) {
        return data.get("t" + inTimingstationID);
    }

    public HashMap<String, TimingstationData> getData() {
        for (int i = 0; i < data.keySet().size(); i++) {
            data.put("t" + (i + 1), data.get(Integer.toString(i + 1)));
            data.remove(Integer.toString(i + 1));
        }
        return data;
    }
}

package main.controlstation;

import lombok.extern.slf4j.Slf4j;
import main.model.TimingstationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ControllingStationReceiver {
    @Autowired
    ControllingStationService controllingStationService;

    @JmsListener(destination = "${station_queue}")
    public void onReceive(TimingstationData timingstationData) {
        log.info("Received Data: " + timingstationData.getTimingstationID());
        controllingStationService.updateData(timingstationData);
    }
}

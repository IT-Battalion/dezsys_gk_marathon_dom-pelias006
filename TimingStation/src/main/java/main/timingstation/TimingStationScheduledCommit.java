package main.timingstation;

import lombok.extern.slf4j.Slf4j;
import main.model.TimingstationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class TimingStationScheduledCommit {
    @Autowired
    TimingstationService timingstationService;
    @Value("${STATION_ID}")
    String station_id;

    @Scheduled(fixedRate = 30000)
    public void commitData() {
        TimingstationData data = timingstationService.getTimingstationData();
        data.setTimingstationID(station_id);
        log.info("Committing Data: " + data.getTimingstationID());
        timingstationService.commitData(data);
    }
}

package main.centralstation;

import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import main.model.TimingstationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@Component
@Slf4j
public class DataReceiver {
    @Value("{$mongodb.sector-urls}")
    private String[] urls;

    @Autowired
    private CentralStationService service;
    
    @Scheduled(fixedRate = 3000L)
    public void receive() {
        for (String url :
                this.urls) {
            RestTemplate template = new RestTemplate();
            TimingstationData[] data = template.getForObject(url, TimingstationData[].class);
            log.info("Received (" + url + ") data: " + Arrays.toString(data));
            service.saveToDatabase(data);
        }
    }
}

package main.centralstation;

import lombok.extern.slf4j.Slf4j;
import main.model.TimingstationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Component
@Slf4j
public class DataReceiver {
    @Value("${sector-urls}")
    private String[] urls;

    @Autowired
    private CentralStationService service;

    @Scheduled(fixedRate = 3000L, initialDelay = 15000L)
    public void receive() {
        log.debug("URLS: " + Arrays.toString(urls));
        for (String url :
                this.urls) {
            RestTemplate template = new RestTemplate();
            HashMap<String, TimingstationData> data = (HashMap<String, TimingstationData>) template.getForEntity(url, Object.class).getBody();
            log.info("Received (" + url + ") data: " + data);
            if (data != null) service.saveToDatabase(data.values().toArray(new TimingstationData[0]));
        }
    }
}

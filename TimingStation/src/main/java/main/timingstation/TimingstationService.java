package main.timingstation;

import main.model.TimingstationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service("timingstationService")
public class TimingstationService {
    private static final TimingstationSimulation simulation = new TimingstationSimulation();
    @Autowired
    JmsTemplate jmsTemplate;
    @Value("${station_queue}")
    private String station_queue;

    public String getGreetings(String inModule) {
        return "Greetings from " + inModule;
    }

    public TimingstationData getTimingstationData() {
        return simulation.getData();
    }

    public void commitData(TimingstationData timingstationData) {
       jmsTemplate.convertAndSend(station_queue, timingstationData);
    }
}

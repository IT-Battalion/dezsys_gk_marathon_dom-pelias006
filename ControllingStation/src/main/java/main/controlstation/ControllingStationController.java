package main.controlstation;

import main.model.TimingstationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class ControllingStationController {
    @Autowired
    ControllingStationService controllingStationService;

    @RequestMapping("/")
    public String timingstationMain() {
        String mainPage = "This is the ControllingStation application! (DEZSYS_MARATHON_REST) <br/><br/>" +
                "<a href='/data'>Link to /data</a><br/>" +
                "<a href='/data/xml'>Link to /data/xml</a><br/>" +
                "<a href='/data/json'>Link to /data/json</a><br/>" +
                "<a href='/data'>Link to /data</a><br/>" +
                "<a href='/consumer.html'>Link to /consumer</a><br/>" +
                "<a href='/timingstation/1/data'>Link to timingstation/1/data</a><br/>" +
                "<a href='/timingstation/1/xml'>Link to timingstation/1/xml</a><br/>" +
                "<a href='/timingstation/1/json'>Link to timingstation/1/json</a><br/>";
        return mainPage;
    }

    @RequestMapping(value = "/data", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public HashMap<String, TimingstationData> controlstationData() {
        return controllingStationService.getData();
    }

    @RequestMapping(value = "/data/json", produces = MediaType.APPLICATION_JSON_VALUE)
    public HashMap<String, TimingstationData> controlstationDataJson() {
        return controllingStationService.getData();
    }

    @RequestMapping(value = "/data/xml", produces = MediaType.APPLICATION_XML_VALUE)
    public HashMap<String, TimingstationData> controlstationDataXml() {
        return controllingStationService.getData();
    }

    @RequestMapping(value = "/timingstation/{timingstationID}/data", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public TimingstationData timingstationData(@PathVariable String timingstationID) {
        return controllingStationService.getTimingstationData(timingstationID);
    }

    @RequestMapping(value = "/timingstation/{timingstationID}/xml", produces = MediaType.APPLICATION_XML_VALUE)
    public TimingstationData timingstationXML(@PathVariable String timingstationID) {
        return controllingStationService.getTimingstationData(timingstationID);
    }

    @RequestMapping(value = "/timingstation/{timingstationID}/json", produces = MediaType.APPLICATION_JSON_VALUE)
    public TimingstationData timingstationJSON(@PathVariable String timingstationID) {
        return controllingStationService.getTimingstationData(timingstationID);
    }
}

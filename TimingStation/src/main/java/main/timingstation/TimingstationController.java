package main.timingstation;

import main.model.TimingstationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TimingstationController {

    @Autowired
    private TimingstationService service;

    @RequestMapping("/")
    public String timingstationMain() {
        String mainPage = "This is the timingstation application! (DEZSYS_MARATHON_REST) <br/><br/>" +
                "<a href='/data'>Link to /data</a><br/>" +
                "<a href='/data/xml'>Link to /data/xml</a><br/>" +
                "<a href='/data/json'>Link to /data/json</a><br/>" +
                "<a href='/consumer.html'>Link to /consumer</a><br/>" +
                "<a href='/transfer'>Link to timingstation/001/transfer</a><br/>";
        return mainPage;
    }

    @RequestMapping(value = "/data", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public TimingstationData timingstationData() {
        return service.getTimingstationData();
    }

    @RequestMapping(value = "/data/json", produces = MediaType.APPLICATION_JSON_VALUE)
    public TimingstationData timingstationJSON() {
        return service.getTimingstationData();
    }

    @RequestMapping(value = "/data/xml", produces = MediaType.APPLICATION_XML_VALUE)
    public TimingstationData timingstationXML() {
        return service.getTimingstationData();
    }

    @RequestMapping("/transfer")
    public String timingstationTransfer() {
        return service.getGreetings("Timingstation.Transfer!");
    }
}

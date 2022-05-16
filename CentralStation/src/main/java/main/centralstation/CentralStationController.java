package main.centralstation;

import com.mongodb.client.MongoCollection;
import main.model.TimingstationData;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class CentralStationController {
    @Autowired
    private CentralStationService service;

    @RequestMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<TimingstationData> data() {
        return service.getData();
    }
}

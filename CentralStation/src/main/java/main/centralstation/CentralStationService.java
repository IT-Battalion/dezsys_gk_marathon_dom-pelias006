package main.centralstation;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.client.MongoCollection;
import main.model.TimingstationData;
import main.mongodb.DataService;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.*;

@Service("service")
public class CentralStationService implements DataService {
    @Autowired
    MongoTemplate mongoTemplate;

    public void saveToDatabase(Collection<TimingstationData> data) {
        //mongoTemplate.save(Arrays.toString(data));
        ObjectMapper mapper = new ObjectMapper(); // or inject it as a dependency
        List<TimingstationData> pojos = mapper.convertValue(data, new TypeReference<>() {
        });
        for (TimingstationData d :
                pojos) {
            if (d != null) /*mongoTemplate.save(d);*/ addData(d);
        }
    }

    public MongoCollection<Document> getData() {
        return mongoTemplate.getCollection("data");
    }

    @Override
    public TimingstationData addData(TimingstationData newdata) {
        TimingstationData data = new TimingstationData();
        data.setId(newdata.getId());
        data.setAltitude(newdata.getAltitude());
        data.setCompetitionData(newdata.getCompetitionData());
        data.setWeatherData(newdata.getWeatherData());
        data.setDistance(newdata.getDistance());
        data.setUnitDistance(newdata.getUnitDistance());
        data.setUnitAltitude(newdata.getUnitAltitude());
        data.setTimingstationID(newdata.getTimingstationID());
        data.setTimestamp(newdata.getTimestamp());
        return mongoTemplate.save(data);
    }

    @Override
    public TimingstationData updateData(TimingstationData oldData) {

        TimingstationData dataOpt = mongoTemplate.findById(oldData.getId(), TimingstationData.class);
        if (dataOpt == null) {
            throw new ResourceNotFoundException("data not found");
        }
        dataOpt.setId(oldData.getId());
        dataOpt.setAltitude(oldData.getAltitude());
        dataOpt.setCompetitionData(oldData.getCompetitionData());
        dataOpt.setWeatherData(oldData.getWeatherData());
        dataOpt.setDistance(oldData.getDistance());
        dataOpt.setUnitDistance(oldData.getUnitDistance());
        dataOpt.setUnitAltitude(oldData.getUnitAltitude());
        dataOpt.setTimingstationID(oldData.getTimingstationID());
        dataOpt.setTimestamp(oldData.getTimestamp());
        return mongoTemplate.save(dataOpt);
    }

    @Override
    public void deleteData(String dataID) {

        if (dataID == null) {
            throw new IllegalArgumentException("dataId must not be null");
        }
        TimingstationData dataOpt = mongoTemplate.findById(dataID, TimingstationData.class);
        if (dataOpt == null) {
            throw new ResourceNotFoundException("data not found");
        }
        mongoTemplate.remove(dataOpt);

    }

    @Override
    public TimingstationData getDataById(String dataID) {
        if (dataID == null) {
            throw new IllegalArgumentException("dataID must not be null");
        }

        TimingstationData dataOpt = mongoTemplate.findById(dataID, TimingstationData.class);
        if (dataOpt == null) {
            throw new ResourceNotFoundException("data not found");
        }
        return dataOpt;
    }

    @Override
    public Collection<TimingstationData> getAllDates() {

        return mongoTemplate.findAll(TimingstationData.class);

    }

}

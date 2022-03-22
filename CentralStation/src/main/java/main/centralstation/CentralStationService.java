package main.centralstation;

import com.mongodb.client.MongoCollection;
import main.model.TimingstationData;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

@Service("service")
public class CentralStationService {
    @Autowired
    MongoTemplate mongoTemplate;

    public void saveToDatabase(TimingstationData[] data) {
        mongoTemplate.save(data);
    }

    public MongoCollection<Document> getData() {
        return mongoTemplate.getCollection("data");
    }
}

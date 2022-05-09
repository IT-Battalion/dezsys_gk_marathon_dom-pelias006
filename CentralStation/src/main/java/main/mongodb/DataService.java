package main.mongodb;

import main.model.TimingstationData;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Collection;

public interface DataService {
    TimingstationData addData(TimingstationData data);

    TimingstationData updateData(TimingstationData data);

    void deleteData(String dataID);

    TimingstationData getDataById(String dataID);

    Collection<TimingstationData> getAllDates();
}

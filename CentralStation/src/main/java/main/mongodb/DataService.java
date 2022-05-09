package main.mongodb;

import main.model.TimingstationData;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface DataService {
    TimingstationData addData(TimingstationData data);

    TimingstationData updateData(TimingstationData data);

    void deleteData(String dataID);

    TimingstationData getDataById(String dataID);

    Page<TimingstationData> getAllDates(Pageable dataPage);
}

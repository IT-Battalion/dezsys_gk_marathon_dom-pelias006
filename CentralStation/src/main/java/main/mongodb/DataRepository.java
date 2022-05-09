package main.mongodb;

import main.model.TimingstationData;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DataRepository extends MongoRepository<TimingstationData, String> {
    public Page<TimingstationData> findAll(Pageable pageable);
}

package server.mongo.db.com.example.accessingdatamongodb;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface StatesRepository extends MongoRepository<State, String> {

  public State findByAbbreviation(String abbreviation);
}
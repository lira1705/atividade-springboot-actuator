package com.example.accessingdatamongodb;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface StatesRepository extends MongoRepository<States, String> {

  public States findByAbbreviation(String abbreviation);
}
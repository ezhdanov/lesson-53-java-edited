package com.webinar52.demo.model;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface TrainingRepository extends MongoRepository<Training, String> {

    List<Training> findAllByManId(String manId);

    @Query("{time: { '$gt': ?0 }}")
    List<Training> customFind(long time);

}

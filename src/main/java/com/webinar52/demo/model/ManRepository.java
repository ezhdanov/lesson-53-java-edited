package com.webinar52.demo.model;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ManRepository extends MongoRepository<Man, String> {
    Man findByName(String s);
    List<Man> findAllByAgeGreaterThan(int age);
    List<Man> findAllByAgeGreaterThanAndNameContainsIgnoreCase(int age, String name);
}

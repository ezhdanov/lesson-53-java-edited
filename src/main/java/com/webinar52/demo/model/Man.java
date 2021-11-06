package com.webinar52.demo.model;

import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@Document(collection = "people")
public class Man {
    @Id
    private String id;
    private String name;
    private int age;

    @DBRef
    private List<Training> trainings = new ArrayList<>();

    public Man(String name, int age) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Man{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", trainings=" + trainings +
                '}';
    }

}


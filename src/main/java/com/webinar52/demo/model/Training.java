package com.webinar52.demo.model;

import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Document(collection = "trainings")
public class Training {
    @Id
    private String id;
    @DBRef
    private Man man;
    private long time;
    private LocalDate date;
    private int averagePulse;

    public Training(Man man, long time, LocalDate date, int averagePulse) {
        this.id = UUID.randomUUID().toString();
        this.man = man;
        this.time = time;
        this.date = date;
        this.averagePulse = averagePulse;
    }

    @Override
    public String toString() {
        return "Training{" +
                "time=" + time +
                ", date=" + date +
                ", averagePulse=" + averagePulse +
                '}';
    }

}

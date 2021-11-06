package com.webinar52.demo.service;

import com.webinar52.demo.model.Man;
import com.webinar52.demo.model.ManRepository;
import com.webinar52.demo.model.Training;
import com.webinar52.demo.model.TrainingRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@AllArgsConstructor
public class ManService {

    private final ManRepository manRepository;
    private final TrainingRepository trainingRepository;

    public Man save(Man man) {
        this.trainingRepository.saveAll(man.getTrainings());
        return this.manRepository.save(man);
    }

    public Man addTraining(Man man, long time, LocalDate date, int averagePulse) {
        Training training = new Training(man, time, date, averagePulse);
        training = this.trainingRepository.save(training);
        man.getTrainings().add(training);
        return this.manRepository.save(man);
    }

}

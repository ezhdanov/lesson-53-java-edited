package com.webinar52.demo.controller;

import com.webinar52.demo.model.Man;
import com.webinar52.demo.model.ManRepository;
import com.webinar52.demo.model.TrainingRepository;
import com.webinar52.demo.service.ManService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.List;

@Controller
@AllArgsConstructor
public class ManController {

    private final ManRepository _db;
    private final ManService manService;
    private final TrainingRepository trainingRepository;

    @GetMapping // localhost:8000/
    public String root(){
        return "index";
    }

    @GetMapping("/people")
    public String getPeople(
            @RequestParam(name = "age", required = false) Integer age,
            @RequestParam(name = "name", required = false) String name,
            Model model) {
        List<Man> people = null;

        if(age != null) {
            people = _db.findAllByAgeGreaterThanAndNameContainsIgnoreCase(age, name);
        } else {
            people = _db.findAll();
        }
        model.addAttribute("people", people);
        return "people";
    }

    @GetMapping("/people/{id}")
    public String getMan(Model model,
                         @PathVariable String id) {
        Man man = _db.findById(id).orElse(null);
        if(man == null)
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    String.format("Пользователь с id %s не найден", id));
        model.addAttribute("man", man);
        return "profile";
    }

    @PostMapping("/people")
    public String addMan(
            @RequestParam int age,
            @RequestParam String name,
            @RequestParam String firstTrainingTime){
        Man man = new Man(name, age);
        _db.save(man);
        return "redirect:/people";
    }

    @PostMapping("/people/{id}/add-training")
    public String addTraining(@PathVariable String id,
                              @RequestParam long time,
                              @RequestParam String date,
                              @RequestParam int avgPulse){
        Man man = _db.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        String.format("Пользователь с id %s не найден", id)));

        LocalDate d = LocalDate.parse(date);

        man = manService.addTraining(man, time, d, avgPulse);
        _db.save(man);
        return "redirect:/people/" + man.getId();
    }

}

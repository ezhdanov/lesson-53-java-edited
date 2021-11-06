package com.webinar52.demo.controller;

import com.webinar52.demo.model.TrainingRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@AllArgsConstructor
public class TrainingController {

    private final TrainingRepository trainingRepository;

    @GetMapping("/people/trainings")
    public String getTrainings(Model model,
                               @RequestParam(name = "time", defaultValue = "0") Long time) {
        model.addAttribute("trainings", trainingRepository.customFind(time));
        return "trainings";
    }

    @GetMapping("/people/{manId}/trainings")
    public String getManTrainings(Model model,
                                  @PathVariable String manId) {
        model.addAttribute("trainings", trainingRepository.findAllByManId(manId));
        return "trainings";
    }

}

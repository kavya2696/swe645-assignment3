package com.hw3.survey_form.controller;

import com.hw3.survey_form.interfaces.SurveyInterface;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.hw3.survey_form.model.Survey;
import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/v1")

public class SurveyController {
    private SurveyInterface surveyService;

    public SurveyController(SurveyInterface surveyInterface) {
        super();
        this.surveyService = surveyInterface;
    }

    @PostMapping("/surveys")
    public ResponseEntity<Survey> saveSurvey(@RequestBody Survey survey) {
        System.out.println("Post Mapping surveys");
        return new ResponseEntity<Survey>(surveyService.saveSurvey(survey), HttpStatus.CREATED);
    }

    @GetMapping("/surveys")
    public List<Survey> getAllSurveys() {
        return surveyService.getAllSurveys();
    }

    @GetMapping("/surveys/{id}")
    public ResponseEntity<Survey> getSurveyById(@PathVariable("id") long id) {
        return new ResponseEntity<Survey>(surveyService.getSurveyById(id), HttpStatus.OK);

    }

    @DeleteMapping("/surveys/{id}")
    public ResponseEntity<Void> deleteSurvey(@PathVariable("id") long id) {
        surveyService.deleteSurveyById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/surveys/{id}")
    public ResponseEntity<Survey> updateService(@PathVariable("id") long id, @RequestBody Survey survey) {
        return new ResponseEntity<Survey>(surveyService.updateService(id, survey), HttpStatus.OK);

    }
}

package com.hw3.survey_form.service;

import com.hw3.survey_form.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import com.hw3.survey_form.interfaces.SurveyInterface;
import com.hw3.survey_form.model.Survey;
import com.hw3.survey_form.repository.SurveyRepositoryInterface;

import java.util.List;

@Service
public class SurveyService implements SurveyInterface {

    private SurveyRepositoryInterface surveyRepository;

    public SurveyService(SurveyRepositoryInterface surveyRepository) {
        super();
        this.surveyRepository = surveyRepository;
    }

    @Override
    public Survey saveSurvey(Survey survey) {
        return surveyRepository.save(survey);
    }

    @Override
    public List<Survey> getAllSurveys() {
        return surveyRepository.findAll();
    }

    @Override
    public Survey getSurveyById(long id) {
        return surveyRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Survey", "Id", id));
    }

    @Override
    public void deleteSurveyById(long id) {
        surveyRepository.deleteById(id);
    }

    @Override
    public Survey updateService(long id, Survey updateSurvey) {
        Survey survey = getSurveyById(id);
        survey.setFirst_name(updateSurvey.getFirst_name());
        survey.setLast_name(updateSurvey.getLast_name());
        survey.setAddress(updateSurvey.getAddress());
        survey.setCity(updateSurvey.getCity());
        survey.setState(updateSurvey.getState());
        survey.setZip(updateSurvey.getZip());
        survey.setTelephone(updateSurvey.getTelephone());
        survey.setEmail(updateSurvey.getEmail());
        survey.setSurvey_date(updateSurvey.getSurvey_date());
        survey.setLikings(updateSurvey.getLikings());
        survey.setInterest(updateSurvey.getInterest());
        survey.setRecommendation(updateSurvey.getRecommendation());
        survey.setComments(updateSurvey.getComments());

        return surveyRepository.save(survey);
    }
}

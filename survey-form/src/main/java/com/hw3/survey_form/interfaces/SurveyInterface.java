package com.hw3.survey_form.interfaces;

import com.hw3.survey_form.model.Survey;

import java.util.List;

public interface SurveyInterface {
    Survey saveSurvey(Survey survey);

    List<Survey> getAllSurveys();

    Survey getSurveyById(long id);

    void deleteSurveyById(long id);

    Survey updateService(long id, Survey survey);
}

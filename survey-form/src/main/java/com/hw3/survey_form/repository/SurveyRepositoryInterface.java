package com.hw3.survey_form.repository;

import com.hw3.survey_form.model.Survey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SurveyRepositoryInterface extends JpaRepository<Survey, Long> {
}

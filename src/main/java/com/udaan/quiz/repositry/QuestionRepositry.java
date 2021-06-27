package com.udaan.quiz.repositry;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.udaan.quiz.entity.QuestionEntity;

@Repository
public interface QuestionRepositry extends CrudRepository<QuestionEntity, Long>{

//	public QuestionEntity updateListOfAnswers(Long id, String listOfAnswers, int correctAnswer);
}

package com.udaan.quiz.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.udaan.quiz.entity.CommonEntity;
import com.udaan.quiz.entity.QuestionEntity;
import com.udaan.quiz.model.PossibleAnswersForQuestion;
import com.udaan.quiz.model.Question;
import com.udaan.quiz.repositry.CommonRepositry;
import com.udaan.quiz.repositry.QuestionRepositry;

@Service
public class QuestionService {

	@Autowired
	private QuestionRepositry questionRepositry;
	
	@Autowired
	private CommonRepositry commonRepositry;
	
	@Autowired
	private ObjectMapper objectMapper;
	
	public Question createQuestion(Question question) throws Exception {
		QuestionEntity questionEntity = questionRepositry.save(new QuestionEntity(question.getName(), objectMapper.writeValueAsString(question.getListOfAnswers()), question.getCorrectAnswer()));
//		for(String s : question.getListOfQuizes()) {
//			commonRepositry.save(new CommonEntity(s+questionEntity.getId(), Long.parseLong(s), questionEntity.getId()));
//		}
		
		question.setId(questionEntity.getId());
		return question;
	}
	
	public boolean createPossibleAnswers(Long id,  PossibleAnswersForQuestion answersForQuestion) throws JsonProcessingException {
		QuestionEntity entity = questionRepositry.updateListOfAnswers(id, objectMapper.writeValueAsString(answersForQuestion.getListOfAnswers()), answersForQuestion.getCorrectOption());
		if(entity != null) {
			return true;
		}
		return false;
	}
	
	public boolean existsOrNot(Long id) {
		return questionRepositry.existsById(id);
	}
}

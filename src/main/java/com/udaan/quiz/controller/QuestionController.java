package com.udaan.quiz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.udaan.quiz.model.PossibleAnswersForQuestion;
import com.udaan.quiz.model.Question;
import com.udaan.quiz.responses.BadResponse;
import com.udaan.quiz.service.QuestionService;

@RestController
@RequestMapping("/question")
public class QuestionController {

	@Autowired
	private QuestionService questionService; 
	
	@PostMapping("/createQuestion")
	public ResponseEntity<Object> createQuestion(@RequestBody Question question) {
		try {
			if (question.getName() != null) {
				return new ResponseEntity<Object>(questionService.createQuestion(question), HttpStatus.CREATED);
			}

			return new ResponseEntity<Object>(new BadResponse("All Parameters are not found ", 400),
					HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Object>(new BadResponse("Internal Error ", 500),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/{id}/possibleAnswers")
	public ResponseEntity<Object> createPossibleAnswers(@PathVariable("id") String id, PossibleAnswersForQuestion answersForQuestion) throws Exception, NumberFormatException{
		if(answersForQuestion.getListOfAnswers() != null ) {
			if(questionService.existsOrNot(Long.parseLong(id))) {
				questionService.createPossibleAnswers(Long.parseLong(id), answersForQuestion);
				return new ResponseEntity<Object>("true" ,HttpStatus.OK);
			}else {
				return new ResponseEntity<Object>(new BadResponse("Sorry question not found ", 404), HttpStatus.NOT_FOUND);
			}
		}
		
		return new ResponseEntity<Object>(new BadResponse("All the parameters are not present ", 400), HttpStatus.BAD_REQUEST);
	}
}

package com.udaan.quiz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.udaan.quiz.model.Quiz;
import com.udaan.quiz.responses.BadResponse;
import com.udaan.quiz.service.QuizService;

@RestController
@RequestMapping("/quiz")
public class QuizController {

	@Autowired
	private QuizService quizService; 
	
	@PostMapping("/createQuiz")
	public ResponseEntity<Object> createQuiz(@RequestBody Quiz quiz) {
		
		if(quiz.getName() != null) {
			return new ResponseEntity<Object>(quizService.createQuiz(quiz), HttpStatus.CREATED);
		}
		
		return new ResponseEntity<Object>(new BadResponse("paramters not found ", 400), HttpStatus.BAD_REQUEST);
	}
	
	@GetMapping("/getQuizes/{noOfPages}")
	public ResponseEntity<Object> getQuizs(@PathVariable String pages){
		try {
			return new ResponseEntity<Object>(quizService.getQuizes(Integer.parseInt(pages)), HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<Object>(new BadResponse("Internal Error ", 500), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
}

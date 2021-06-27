package com.udaan.quiz.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class QuestionEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String name;

	private String listOfAnswers;

	private int correctAnswer;

	public QuestionEntity(String name, String listOfAnswers, int correctAnswer) {
		super();
		this.name = name;
		this.listOfAnswers = listOfAnswers;
		this.correctAnswer = correctAnswer;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getListOfAnswers() {
		return listOfAnswers;
	}

	public void setListOfAnswers(String listOfAnswers) {
		this.listOfAnswers = listOfAnswers;
	}

	public int getCorrectAnswer() {
		return correctAnswer;
	}

	public void setCorrectAnswer(int correctAnswer) {
		this.correctAnswer = correctAnswer;
	}

}

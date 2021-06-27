package com.udaan.quiz.model;

import java.util.List;

public class Question {

	private Long id;
	private String name;
	private List<Answer> listOfAnswers;
	private Integer correctAnswer;
	private List<String> listOfQuizes;

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

	public List<Answer> getListOfAnswers() {
		return listOfAnswers;
	}

	public void setListOfAnswers(List<Answer> listOfAnswers) {
		this.listOfAnswers = listOfAnswers;
	}

	public Integer getCorrectAnswer() {
		return correctAnswer;
	}

	public void setCorrectAnswer(Integer correctAnswer) {
		this.correctAnswer = correctAnswer;
	}

	public List<String> getListOfQuizes() {
		return listOfQuizes;
	}

	public void setListOfQuizes(List<String> listOfQuizes) {
		this.listOfQuizes = listOfQuizes;
	}

}

package com.udaan.quiz.model;

import java.util.List;

public class Quiz {

	private Long id;
	private String name;
	private List<String> listOfQuestions;
	private List<Question> questions;

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

	public List<String> getListOfQuestions() {
		return listOfQuestions;
	}

	public void setListOfQuestions(List<String> listOfQuestions) {
		this.listOfQuestions = listOfQuestions;
	}

	public List<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}

}

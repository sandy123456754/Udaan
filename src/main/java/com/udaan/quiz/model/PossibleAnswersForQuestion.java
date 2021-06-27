package com.udaan.quiz.model;

import java.util.List;

public class PossibleAnswersForQuestion {

	private List<Answer> listOfAnswers;
	private int correctOption;

	public List<Answer> getListOfAnswers() {
		return listOfAnswers;
	}

	public void setListOfAnswers(List<Answer> listOfAnswers) {
		this.listOfAnswers = listOfAnswers;
	}

	public int getCorrectOption() {
		return correctOption;
	}

	public void setCorrectOption(int correctOption) {
		this.correctOption = correctOption;
	}

}

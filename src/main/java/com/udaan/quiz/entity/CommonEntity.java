package com.udaan.quiz.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CommonEntity {

	@Id
	private String id;

	private Long quizId;

	private Long questionId;

	public CommonEntity(String id, Long quizId, Long questionId) {
		this.id = id;
		this.quizId = quizId;
		this.questionId = questionId;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Long getQuizId() {
		return quizId;
	}

	public void setQuizId(Long quizId) {
		this.quizId = quizId;
	}

	public Long getQuestionId() {
		return questionId;
	}

	public void setQuestionId(Long questionId) {
		this.questionId = questionId;
	}

}

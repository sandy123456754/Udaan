package com.udaan.quiz.responses;

public class BadResponse {

	private String reason;
	private int statusCode;

	public BadResponse(String reason, int statusCode) {
		this.reason = reason;
		this.statusCode = statusCode;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

}

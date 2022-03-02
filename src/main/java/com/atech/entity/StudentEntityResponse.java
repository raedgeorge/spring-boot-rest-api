package com.atech.entity;

import java.time.LocalTime;

public class StudentEntityResponse {

	private int status;
	private String message;
	private LocalTime localTime;
	
	public StudentEntityResponse(int status, String message, LocalTime localTime) {
		this.status = status;
		this.message = message;
		this.localTime = localTime;
	}
	
	
	public StudentEntityResponse() {
	}



	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public LocalTime getLocalTime() {
		return localTime;
	}

	public void setLocalTime(LocalTime localTime) {
		this.localTime = localTime;
	}
		
}

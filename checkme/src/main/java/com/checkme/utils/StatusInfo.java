package com.checkme.utils;

import org.springframework.stereotype.Component;

@Component
public class StatusInfo {

	private boolean success;
	private String message;

	public StatusInfo() {

	}

	public StatusInfo(boolean success, String message) {
		setSuccess(success);
		setMessage(message);
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}

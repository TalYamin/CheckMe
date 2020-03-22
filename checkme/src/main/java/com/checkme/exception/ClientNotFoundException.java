package com.checkme.exception;

public class ClientNotFoundException extends Exception {

	private String clientPhone;

	public ClientNotFoundException(String message, String clientPhone) {
		super(String.format(message + " clientPhone: %s", clientPhone));
		this.clientPhone = clientPhone;
	}

	public String getClientPhone() {
		return clientPhone;
	}

}

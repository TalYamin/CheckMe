package com.checkme.exception;

public class PhoneDuplicationException extends Exception {
	
	private String phone;
	
	public PhoneDuplicationException (String message, String phone) {

		super(String.format(message + "%s", phone));
		this.phone = phone;
		
	}

	public String getPhone() {
		return phone;
	}

	
	
	
}

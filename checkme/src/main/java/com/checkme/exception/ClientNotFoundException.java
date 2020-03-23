package com.checkme.exception;

public class ClientNotFoundException extends Exception {

	private long operatorId;
	private String clientPhone;

	public ClientNotFoundException(String message, long operatorId, String clientPhone) {
		super(String.format(message + " operatorId: %d, clientPhone: %s", operatorId, clientPhone));
		this.operatorId = operatorId;
		this.clientPhone = clientPhone;
	}
	
	

	public long getOperatorId() {
		return operatorId;
	}



	public String getClientPhone() {
		return clientPhone;
	}

}

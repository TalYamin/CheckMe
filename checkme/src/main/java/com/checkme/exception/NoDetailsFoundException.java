package com.checkme.exception;

import com.checkme.service.ClientType;

public class NoDetailsFoundException extends Exception {

	private long operatorId;
	private ClientType clientType;

	public NoDetailsFoundException(String message, long operatorId, ClientType clientType) {
		super(message);
		this.operatorId = operatorId;
		this.clientType = clientType;
	}

	public long getOperatorId() {
		return operatorId;
	}

	public ClientType getClientType() {
		return clientType;
	}
}

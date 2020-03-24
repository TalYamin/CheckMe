package com.checkme.exception;

public class ModelNotFoundException extends Exception {

	private long operatorId;
	private String modelPhone;

	public ModelNotFoundException(String message, long operatorId, String modelPhone) {
		super(String.format(message + " operatorId: %d, modelPhone: %s", operatorId, modelPhone));
		this.operatorId = operatorId;
		this.modelPhone = modelPhone;
	}

	public long getOperatorId() {
		return operatorId;
	}

	public String getModelPhone() {
		return modelPhone;
	}

}

package com.checkme.exception;

public class PhoneDuplicationException extends Exception {
	
	private long operatorId;
	private long targetId;
	private String phone;
	
	public PhoneDuplicationException (String message, long operatorId, long targetId, String phone) {

		super(String.format(message + " operatorId: %d, targetId: %d, clientPhone: %s",operatorId,targetId, phone));
		this.operatorId = operatorId;
		this.targetId = targetId;
		this.phone = phone;
		
		
	}
	
	public long getOperatorId() {
		return operatorId;
	}
	
	public long getTargetId() {
		return targetId;
	}

	public String getPhone() {
		return phone;
	}

	
	
	
}

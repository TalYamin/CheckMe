package com.checkme.exception;

public class NameDuplicationException extends Exception {

	private long operatorId;
	private long targetId;
	private String name;

	public NameDuplicationException(String message, long operatorId, long targetId, String name) {

		super(String.format(message + " operatorId: %d, targetId: %d, name: %s", operatorId, targetId, name));
		this.operatorId = operatorId;
		this.targetId = targetId;

		this.name = name;

	}

	public long getOperatorId() {
		return operatorId;
	}

	public long getTargetId() {
		return targetId;
	}

	public String getName() {
		return name;
	}

}

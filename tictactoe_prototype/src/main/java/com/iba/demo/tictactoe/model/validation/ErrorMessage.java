package com.iba.demo.tictactoe.model.validation;

public class ErrorMessage {
	
	private String code;
	
	private String message;

	public ErrorMessage(String code, String message) {
		super();
		this.code = code;
		this.message = message;
	}

	public String getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}
	

}

package com.iba.demo.tictak.exception;

public class GameException extends Exception {

	private static final long serialVersionUID = 1L;

	public GameException() {
		super();		
	}

	public GameException(String message, Throwable throwable, boolean enableSuppression, boolean writableStackTrace) {
		super(message, throwable, enableSuppression, writableStackTrace);		
	}

	public GameException(String message, Throwable throwable) {
		super(message, throwable);
	}

	public GameException(String message) {
		super(message);
	}

	public GameException(Throwable throwable) {
		super(throwable);
	}
	
	

}

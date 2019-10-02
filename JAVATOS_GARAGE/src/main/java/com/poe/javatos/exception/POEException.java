package com.poe.javatos.exception;


// Exception controllée (checked - try/catch)
@SuppressWarnings("serial")
public class POEException extends Exception {

	public POEException() {
		super();
	}

	public POEException(String msg) {
		super(msg);
	}

}

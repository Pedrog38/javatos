package com.poe.javatos.exception;


// Exception non controllée (unchecked - try/catch pas obligatoire)
@SuppressWarnings("serial")
public class POERuntimeException extends RuntimeException {

	public POERuntimeException() {
		super();
	}

	public POERuntimeException(String msg) {
		super(msg);
	}

}

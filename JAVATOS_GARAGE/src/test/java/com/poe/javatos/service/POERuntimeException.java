package com.poe.javatos.service;

// Exception non controlé, le try catch n'est pas obligatoire
@SuppressWarnings("serial")
public class POERuntimeException extends RuntimeException {

	public POERuntimeException() {
		super();
	}

	public POERuntimeException(String msg) {
		super(msg);

	}
	

}

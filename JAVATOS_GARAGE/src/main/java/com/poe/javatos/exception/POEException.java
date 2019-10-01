package com.poe.javatos.exception;

// exception controlée (checked) si je me sers je devrais mettrais un try catch
@SuppressWarnings("serial")
public class POEException extends Exception {

	public POEException() {
		super();
	}

	public POEException(String msg) {
		super(msg);

	}
	
	

}

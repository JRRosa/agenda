package org.ejemplo.com.dao.exceptions;

public class JPAException extends Exception {
	
	private static final long serialVersionUID = -5589072542239720185L;
	private static final String DEFAULT_MESSAGE = "Has ocurred an error with JPA";
	
	public JPAException() {
		this(DEFAULT_MESSAGE);
	}

	public JPAException(String message) {
		super(message);
	}

	public JPAException(Throwable cause) {
		super(cause);
	}

	public JPAException(String message, Throwable cause) {
		super(message, cause);
	}
}

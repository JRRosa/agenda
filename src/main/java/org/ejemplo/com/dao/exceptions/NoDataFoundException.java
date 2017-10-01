package org.ejemplo.com.dao.exceptions;

public class NoDataFoundException extends Exception {
	
	private static final long serialVersionUID = 9102462187769683187L;
	private static final String DEFAULT_MESSAGE = "No data found";
	
	public NoDataFoundException() {
		this(DEFAULT_MESSAGE);
	}

	public NoDataFoundException(String message) {
		super(message);
	}

	public NoDataFoundException(Throwable cause) {
		super(cause);
	}

	public NoDataFoundException(String message, Throwable cause) {
		super(message, cause);
	}

}

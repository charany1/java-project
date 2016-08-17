package com.adobe.prj.dao;

public class FetchException extends Exception {

	
	private static final long serialVersionUID = -6819280552681525074L;

	
	

	public FetchException() {
	}

	public FetchException(String message) {
		super(message);
	}

	public FetchException(Throwable cause) {
		super(cause);
	}

	public FetchException(String message, Throwable cause) {
		super(message, cause);
	}

	public FetchException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}

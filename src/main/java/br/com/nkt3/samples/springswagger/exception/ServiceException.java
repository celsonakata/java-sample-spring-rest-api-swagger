package br.com.nkt3.samples.springswagger.exception;

public class ServiceException extends Exception {

	private static final long serialVersionUID = -239035741918087427L;

	public ServiceException(String errorMessage, Throwable err) {
		super(errorMessage, err);
	}

	public ServiceException(String errorMessage) {
		super(errorMessage);
	}
}

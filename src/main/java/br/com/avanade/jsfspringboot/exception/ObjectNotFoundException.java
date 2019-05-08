package br.com.avanade.jsfspringboot.exception;

public class ObjectNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;

	public ObjectNotFoundException() {
		super();
	}

	public ObjectNotFoundException(String msg) {
		super(msg);
	}

	public ObjectNotFoundException(String msg, Throwable e) {
		super(msg, e);
	}

}

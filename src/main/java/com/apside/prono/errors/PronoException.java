package com.apside.prono.errors;

public class PronoException extends RuntimeException {

	public PronoException() {
	}

	public PronoException(String message) {
		super(message);
	}

    public PronoException(String message, Throwable cause) {
        super(message, cause);
    }

    public PronoException(Throwable cause) {
        super(cause);
    }
}

package com.happyframework.exception.handling;

public final class ExceptionHandleResult {

	private final Throwable exception;
	private final Throwable newException;
	private final boolean exceptionHandled;

	public ExceptionHandleResult(Throwable exception, Throwable newException,
			boolean exceptionHandled) {
		this.exception = exception;
		this.newException = newException;
		this.exceptionHandled = exceptionHandled;
	}

	public void autoThrowException() throws Throwable {
		if (this.newException != null) {
			throw this.newException;
		}

		if (!exceptionHandled) {
			throw this.exception;
		}
	}

}

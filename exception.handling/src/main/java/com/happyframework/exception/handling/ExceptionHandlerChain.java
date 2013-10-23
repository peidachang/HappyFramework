package com.happyframework.exception.handling;

public interface ExceptionHandlerChain {

	Throwable getException();

	void setNewException(final Throwable newException);

	boolean isExceptionHandled();

	void setExceptionHandled(final boolean exceptionHandled);

	void proceed();

}
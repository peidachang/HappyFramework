package com.happyframework.exception.handling;

public interface ExceptionService {

	ExceptionHandleResult handle(final String policy, final Throwable exception);

	ExceptionService registerHandler(final String policy,
			final ExceptionHandler handler);

}

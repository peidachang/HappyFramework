package com.happyframework.exception.handling;

public interface ExceptionHandler {

	void handle(final ExceptionHandlerChain chain);

}

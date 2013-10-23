package com.happyframework.exception.handling;

final class ConsoleLoggingHandler implements ExceptionHandler {

	@Override
	public final void handle(final ExceptionHandlerChain chain) {
		System.out.println("记录日志：" + chain.getException());

		chain.proceed();
	}

}

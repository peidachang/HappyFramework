package com.happyframework.exception.handling;

final class ConsoleNotificationHandler implements ExceptionHandler {

	@Override
	public final void handle(final ExceptionHandlerChain chain) {
		System.out.println("提示消息：" + chain.getException());

		chain.setExceptionHandled(true);
		chain.proceed();
	}

}

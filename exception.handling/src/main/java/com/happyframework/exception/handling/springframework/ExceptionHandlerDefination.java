package com.happyframework.exception.handling.springframework;

import com.happyframework.exception.handling.ExceptionHandler;

public final class ExceptionHandlerDefination {

	private String policy;
	private ExceptionHandler handler;

	public String getPolicy() {
		return policy;
	}

	public void setPolicy(String policy) {
		this.policy = policy;
	}

	public ExceptionHandler getHandler() {
		return handler;
	}

	public void setHandler(ExceptionHandler handler) {
		this.handler = handler;
	}

}

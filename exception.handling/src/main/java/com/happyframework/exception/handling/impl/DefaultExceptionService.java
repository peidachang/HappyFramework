package com.happyframework.exception.handling.impl;

import java.util.HashMap;
import java.util.ArrayList;

import com.happyframework.exception.handling.ExceptionHandleResult;
import com.happyframework.exception.handling.ExceptionHandler;
import com.happyframework.exception.handling.ExceptionService;

public final class DefaultExceptionService implements ExceptionService {

	private final HashMap<String, ArrayList<ExceptionHandler>> handlers = new HashMap<String, ArrayList<ExceptionHandler>>();

	@Override
	public final ExceptionHandleResult handle(final String policy,
			final Throwable exception) {
		DefaultExceptionHandlerChain chain = new DefaultExceptionHandlerChain(
				this.getPolicyHandlers(policy), exception);
		chain.proceed();

		return chain.createExceptionHandleResult();
	}

	public final ExceptionService registerHandler(final String policy,
			final ExceptionHandler handler) {
		this.getPolicyHandlers(policy).add(handler);

		return this;
	}

	private final ArrayList<ExceptionHandler> getPolicyHandlers(
			final String policy) {
		if (!this.handlers.containsKey(policy)) {
			this.handlers.put(policy, new ArrayList<ExceptionHandler>());
		}

		return this.handlers.get(policy);
	}

}

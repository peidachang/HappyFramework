package com.happyframework.exception.handling.impl;

import java.util.List;

import com.happyframework.exception.handling.ExceptionHandleResult;
import com.happyframework.exception.handling.ExceptionHandler;
import com.happyframework.exception.handling.ExceptionHandlerChain;

final class DefaultExceptionHandlerChain implements ExceptionHandlerChain {

	private final List<ExceptionHandler> handlers;
	private int currentHandlerIndex = -1;
	private final Throwable exception;
	private Throwable newException;
	private boolean exceptionHandled;

	DefaultExceptionHandlerChain(final List<ExceptionHandler> handlers,
			final Throwable exception) {
		this.handlers = handlers;
		this.exception = exception;
	}

	@Override
	public final Throwable getException() {
		return this.exception;
	}

	@Override
	public final void setNewException(final Throwable newException) {
		this.setExceptionHandled(true);
		this.newException = newException;
	}

	@Override
	public final boolean isExceptionHandled() {
		return exceptionHandled;
	}

	@Override
	public final void setExceptionHandled(final boolean exceptionHandled) {
		this.exceptionHandled = exceptionHandled;
	}

	@Override
	public final void proceed() {
		if (this.canProceed()) {
			this.currentHandlerIndex++;
			this.getCurrentHandler().handle(this);
			this.currentHandlerIndex--;
		}
	}

	private final boolean canProceed() {
		return this.currentHandlerIndex < this.handlers.size() - 1;
	}

	private final ExceptionHandler getCurrentHandler() {
		return this.handlers.get(this.currentHandlerIndex);
	}

	ExceptionHandleResult createExceptionHandleResult() {
		return new ExceptionHandleResult(this.exception, this.newException,
				this.exceptionHandled);
	}

}

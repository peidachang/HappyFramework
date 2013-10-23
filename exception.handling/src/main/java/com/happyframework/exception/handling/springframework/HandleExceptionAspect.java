package com.happyframework.exception.handling.springframework;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.AfterThrowing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.happyframework.exception.handling.ExceptionService;
import com.happyframework.exception.handling.impl.DefaultExceptionService;

@Aspect
@Component
public class HandleExceptionAspect {
	private final ExceptionService exceptionService = new DefaultExceptionService();

	@AfterThrowing(value = "@annotation(handleExcepiton)", throwing = "exception")
	public void afterThrowingAdvice(HandleException handleExcepiton,
			Throwable exception) {
		this.exceptionService.handle(handleExcepiton.value(), exception);
	}

	@Autowired
	private void setDefinations(ExceptionHandlerDefination[] definations) {
		if (definations == null) {
			return;
		}
		
		for (ExceptionHandlerDefination defination : definations) {
			this.exceptionService.registerHandler(defination.getPolicy(),
					defination.getHandler());
		}
	}
}

package com.happyframework.exception.handling.springframework;

import java.util.List;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
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

	@Around(value = "@annotation(handleExcepiton)")
	public void handleException(ProceedingJoinPoint pjp,
			HandleException handleExcepiton) throws Throwable {
		try {
			pjp.proceed();
		} catch (Throwable exception) {
			this.exceptionService.handle(handleExcepiton.value(), exception)
					.autoThrowException();
		}
	}

	@Autowired
	private void setDefinations(List<ExceptionHandlerDefination> definations) {
		if (definations == null) {
			return;
		}

		for (ExceptionHandlerDefination defination : definations) {
			this.exceptionService.registerHandler(defination.getPolicy(),
					defination.getHandler());
		}
	}
}

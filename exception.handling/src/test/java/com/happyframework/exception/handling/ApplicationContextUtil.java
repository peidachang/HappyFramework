package com.happyframework.exception.handling;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public final class ApplicationContextUtil {
	private static final ApplicationContext context = new ClassPathXmlApplicationContext(
			"context.xml");

	public static ApplicationContext getContext() {
		return context;
	}
}

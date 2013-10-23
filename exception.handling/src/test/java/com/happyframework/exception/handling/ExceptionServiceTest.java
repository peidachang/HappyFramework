package com.happyframework.exception.handling;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class ExceptionServiceTest {

	@Test
	public void thisHandle() {
		ApplicationContextUtil
		.getContext()
		.getBean(TestController.class)
		.test();
	}

}

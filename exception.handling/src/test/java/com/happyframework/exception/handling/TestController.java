package com.happyframework.exception.handling;

import org.springframework.stereotype.Controller;

import com.happyframework.exception.handling.springframework.HandleException;

@Controller
public class TestController {

	@HandleException("UI")
	public void test() {
		throw new RuntimeException("业务失败");
	}
	
}

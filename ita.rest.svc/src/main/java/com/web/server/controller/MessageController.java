package com.web.server.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(value="http://localhost:8081")
public class MessageController {

	@RequestMapping("/")
	public String home() throws Exception {
		return "This is home page.";
	}
	
	@RequestMapping("/test")
	public String hello() throws Exception{
		return "Hello World! This is Ita Server's message.";
	}
	
}

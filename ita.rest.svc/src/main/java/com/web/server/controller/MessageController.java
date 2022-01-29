package com.web.server.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.web.server.config.AppCode;
import com.web.server.rest.IRestBase;
import com.web.server.rest.RestResult;

@RestController
@CrossOrigin(value="http://localhost:8081")
public class MessageController implements IRestBase {

	@RequestMapping("/")
	public String home() throws Exception {
		return "This is home page.";
	}
	
	@RequestMapping("/test")
	public RestResult hello() throws Exception{
		List<String> objList = new ArrayList<>();
		objList.add("Hello");
		objList.add("World");
		objList.add("The");
		objList.add("test");
		objList.add("is");
		objList.add("work!");
		return buildResult(AppCode.SERVER.SUCCESS.QUERY_SUCCESS.getCode(), objList);
	}
	
}

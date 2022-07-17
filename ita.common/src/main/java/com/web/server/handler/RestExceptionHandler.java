package com.web.server.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.web.server.rest.IRestBase;
import com.web.server.rest.RestResult;

@ControllerAdvice
public class RestExceptionHandler implements IRestBase {
	
	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<RestResult> handler(RuntimeException exception) {
		String[] content = exception.getMessage().split("-");
		String code = content[0];
		String msg = content[1];
		return new ResponseEntity<>(buildResult(code, msg, null), HttpStatus.BAD_REQUEST);
	}
	
}

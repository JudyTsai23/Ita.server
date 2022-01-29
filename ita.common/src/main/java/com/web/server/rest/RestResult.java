package com.web.server.rest;

public class RestResult {

	private String appCode;
	private String appMsg;
	private Object restData;
	
	public RestResult() {}
	
	public RestResult(String appCode, String appMsg, Object restData) {
		this.appCode = appCode;
		this.appMsg = appMsg;
		this.restData = restData;
	}
	
	public RestResult(String appCode, Object restData) {
		this.appCode = appCode;
		this.restData = restData;
	}

	public String getAppCode() {
		return appCode;
	}

	public void setAppCode(String appCode) {
		this.appCode = appCode;
	}

	public String getAppMsg() {
		return appMsg;
	}

	public void setAppMsg(String appMsg) {
		this.appMsg = appMsg;
	}

	public Object getRestData() {
		return restData;
	}

	public void setRestData(Object restData) {
		this.restData = restData;
	}
}

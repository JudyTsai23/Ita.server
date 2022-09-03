package com.web.server.enumcnst;

public enum FeedbackPeriod {

	LUNCH(1, "午餐時段"),
	DINNER(2, "晚餐時段");
	
	private int id;
	private String name;
	
	private FeedbackPeriod(int id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public int getPeriodId() {
		return id;
	}
	
	public String getPeriodName() {
		return name;
	}
	
	public static FeedbackPeriod getEnumById(int id) {
		for(FeedbackPeriod e : FeedbackPeriod.values()) {
			if(e.getPeriodId() == id) {
				return e;
			}
		}
		return null;
	}
}

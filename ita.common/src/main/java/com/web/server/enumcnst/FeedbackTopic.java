package com.web.server.enumcnst;

public enum FeedbackTopic {

	ENVIROMENT(1, "餐廳環境"),
	MEALS(2, "關於餐點"),
	SERVICE(3, "服務品質"),
	WEBSITE(4, "網站相關"),
	OTHER(5, "其他");
	
	private int id;
	private String name;
	
	private FeedbackTopic(int id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public int getTopicId() {
		return id;
	}
	
	public String getTopicName() {
		return name;
	}
	
	public static String getTopicNameById(int id) {
		for(FeedbackTopic e : FeedbackTopic.values()) {
			if(e.getTopicId() == id) {
				return e.getTopicName();
			}
		}
		return "";
	}
	
	public static FeedbackTopic getEnumById(int id) {
		for(FeedbackTopic e : FeedbackTopic.values()) {
			if(e.getTopicId() == id) {
				return e;
			}
		}
		return null;
	}
}

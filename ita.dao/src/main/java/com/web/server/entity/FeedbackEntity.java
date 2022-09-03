package com.web.server.entity;

import com.web.server.enumcnst.FeedbackPeriod;
import com.web.server.enumcnst.FeedbackTopic;

public class FeedbackEntity {

	private String customerName;
	private String phone;
	private String email;
	private boolean subscription;
	private FeedbackTopic topic;
	private String date;
	private FeedbackPeriod period;
	private String opinion;
	private int rating;

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isSubscription() {
		return subscription;
	}

	public void setSubscription(boolean subscription) {
		this.subscription = subscription;
	}

	public FeedbackTopic getTopic() {
		return topic;
	}

	public void setTopic(FeedbackTopic topic) {
		this.topic = topic;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public FeedbackPeriod getPeriod() {
		return period;
	}

	public void setPeriod(FeedbackPeriod period) {
		this.period = period;
	}

	public String getOpinion() {
		return opinion;
	}

	public void setOpinion(String opinion) {
		this.opinion = opinion;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

}

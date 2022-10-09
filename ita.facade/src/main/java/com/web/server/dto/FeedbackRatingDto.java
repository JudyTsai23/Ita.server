package com.web.server.dto;

import java.util.List;

public class FeedbackRatingDto {

	private String avgRate;
	private List<FeedbackRatingDetailDto> ratingList;

	public String getAvgRate() {
		return avgRate;
	}

	public void setAvgRate(String avgRate) {
		this.avgRate = avgRate;
	}

	public List<FeedbackRatingDetailDto> getRatingList() {
		return ratingList;
	}

	public void setRatingList(List<FeedbackRatingDetailDto> ratingList) {
		this.ratingList = ratingList;
	}

}

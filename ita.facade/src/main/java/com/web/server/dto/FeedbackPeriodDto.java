package com.web.server.dto;

import java.util.List;

public class FeedbackPeriodDto {

	List<FeedbackDetailDto> lunchList;
	List<FeedbackDetailDto> dinnerList;

	public List<FeedbackDetailDto> getLunchList() {
		return lunchList;
	}

	public void setLunchList(List<FeedbackDetailDto> lunchList) {
		this.lunchList = lunchList;
	}

	public List<FeedbackDetailDto> getDinnerList() {
		return dinnerList;
	}

	public void setDinnerList(List<FeedbackDetailDto> dinnerList) {
		this.dinnerList = dinnerList;
	}

}

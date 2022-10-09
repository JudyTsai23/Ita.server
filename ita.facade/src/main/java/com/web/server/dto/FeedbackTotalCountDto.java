package com.web.server.dto;

import java.util.List;

public class FeedbackTotalCountDto {

	private int totalCount;
	private List<FeedbackDetailDto> countList;

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public List<FeedbackDetailDto> getCountList() {
		return countList;
	}

	public void setCountList(List<FeedbackDetailDto> countList) {
		this.countList = countList;
	}

}

package com.web.server.dto;

import java.util.List;

public class NewsRangeDto {

	private int total;
	private List<NewsListDto> list;
	
	public int getTotal() {
		return total;
	}
	
	public void setTotal(int total) {
		this.total = total;
	}
	
	public List<NewsListDto> getList() {
		return list;
	}
	
	public void setList(List<NewsListDto> list) {
		this.list = list;
	}
}

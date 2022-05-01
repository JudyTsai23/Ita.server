package com.web.server.dto;

import java.util.List;

import com.web.server.bo.NewsListBo;

public class NewsRangeDto {

	private int total;
	private List<NewsListBo> list;
	
	public int getTotal() {
		return total;
	}
	
	public void setTotal(int total) {
		this.total = total;
	}
	
	public List<NewsListBo> getList() {
		return list;
	}
	
	public void setList(List<NewsListBo> list) {
		this.list = list;
	}
}

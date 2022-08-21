package com.web.server.vo;

public class NewsRangeVo {

	private int count; // 欲查詢的筆數
	private int page; // 頁數
	
	public int getCount() {
		return count;
	}
	
	public void setCount(int count) {
		this.count = count;
	}
	
	public int getPage() {
		return page;
	}
	
	public void setPage(int page) {
		this.page = page;
	}
}

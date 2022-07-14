package com.web.server.dto;

public class MenuSubCategoryDto {
	
	private String name;		// 子類別中文名稱
	private String categoryId;	// 類別ID
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getCategoryId() {
		return categoryId;
	}
	
	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}
}

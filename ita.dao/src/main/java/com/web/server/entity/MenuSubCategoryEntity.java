package com.web.server.entity;

public class MenuSubCategoryEntity {

	private String id;						// 餐點次分類流水號
	private String name;					// 餐點次分類名稱
	private String categoryId;					// 餐點次分類所屬的種類ID
	private int sort;						// 餐點次分類排序

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

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

	public int getSort() {
		return sort;
	}

	public void setSort(int sort) {
		this.sort = sort;
	}
}

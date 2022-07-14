package com.web.server.bo;

public class MenuSubCategoryBo {

	private int id;
	private String name; 			// 餐點次分類名稱
	private int categoryId; 		// 餐點次分類所屬的種類ID
	private int sort;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public int getSort() {
		return sort;
	}

	public void setSort(int sort) {
		this.sort = sort;
	}

}

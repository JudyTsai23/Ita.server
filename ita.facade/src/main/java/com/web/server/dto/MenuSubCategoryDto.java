package com.web.server.dto;

import java.util.List;

public class MenuSubCategoryDto {

	private int categoryId;
	private List<MenuSubCategoryDetailDto> subCateList;

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public List<MenuSubCategoryDetailDto> getSubCateList() {
		return subCateList;
	}

	public void setSubCateList(List<MenuSubCategoryDetailDto> subCateList) {
		this.subCateList = subCateList;
	}

}

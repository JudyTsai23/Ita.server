package com.web.server.dto;

import java.util.List;

public class MenuListDto {

	private int subCateId; // 餐點子分類ID
	private String subCateName; // 餐點子類別名稱
	private int subCateSort; // 餐點子類別順序
	private List<MenuListDetailDto> meals; // 餐點清單

	public int getSubCateId() {
		return subCateId;
	}

	public void setSubCateId(int subCateId) {
		this.subCateId = subCateId;
	}

	public String getSubCateName() {
		return subCateName;
	}

	public void setSubCateName(String subCateName) {
		this.subCateName = subCateName;
	}
	
	public int getSubCateSort() {
		return subCateSort;
	}

	public void setSubCateSort(int subCateSort) {
		this.subCateSort = subCateSort;
	}

	public List<MenuListDetailDto> getMeals() {
		return meals;
	}

	public void setMeals(List<MenuListDetailDto> meals) {
		this.meals = meals;
	}

}

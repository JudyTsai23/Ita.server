package com.web.server.dto;

import java.util.List;

// for 前台 查詢消費者所看的餐點資訊
public class MenuListDto {

	private String subCateName; // 餐點子類別
	private List<MenuListDetailDto> mealList; // 餐點清單
	
	public MenuListDto(String name, List<MenuListDetailDto> list) {
		this.subCateName = name;
		this.mealList = list;
	}

	public String getSubCateName() {
		return subCateName;
	}

	public void setSubCateName(String subCateName) {
		this.subCateName = subCateName;
	}

	public List<MenuListDetailDto> getMealList() {
		return mealList;
	}

	public void setMealList(List<MenuListDetailDto> mealList) {
		this.mealList = mealList;
	}
}

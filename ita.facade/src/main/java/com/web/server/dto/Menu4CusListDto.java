package com.web.server.dto;

import java.util.List;

public class Menu4CusListDto {

	private String subCateName;
	private List<Menu4CusListDetailDto> meals;

	public String getSubCateName() {
		return subCateName;
	}

	public void setSubCateName(String subCateName) {
		this.subCateName = subCateName;
	}

	public List<Menu4CusListDetailDto> getMeals() {
		return meals;
	}

	public void setMeals(List<Menu4CusListDetailDto> meals) {
		this.meals = meals;
	}

}

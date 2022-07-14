package com.web.server.dto;

import java.util.List;

public class MenuCategoryInfoDto {

	private int id;
	private String name;
	private String zhName;
	private String icon;
	private int sort;
	private List<MenuSubCategoryInfoDto> subCateList;

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

	public String getZhName() {
		return zhName;
	}

	public void setZhName(String zhName) {
		this.zhName = zhName;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public int getSort() {
		return sort;
	}

	public void setSort(int sort) {
		this.sort = sort;
	}

	public List<MenuSubCategoryInfoDto> getSubCateList() {
		return subCateList;
	}

	public void setSubCateList(List<MenuSubCategoryInfoDto> subCateList) {
		this.subCateList = subCateList;
	}

}

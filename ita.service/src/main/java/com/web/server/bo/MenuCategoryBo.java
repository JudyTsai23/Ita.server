package com.web.server.bo;

public class MenuCategoryBo {

	private int id; 			// 餐點種類流水號
	private String name; 		// 餐點種類名稱
	private String zhName; 		// 餐點種類中文名稱
	private String icon; 		// 餐點種類圖示檔案名稱
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

}

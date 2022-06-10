package com.web.server.dto;

public class MenuCategoryDetailDto {

	private String id;						// 餐點種類流水號
	private String zhName;					// 餐點種類中文名稱
	private String icon;				// 餐點種類圖示
	


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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
}

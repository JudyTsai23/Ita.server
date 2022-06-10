package com.web.server.bo;

public class MenuCategoryListBo {

	private String id;						// 餐點種類流水號
	private String name;					// 餐點種類名稱
	private String zhName;					// 餐點種類中文名稱

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

	public String getZhName() {
		return zhName;
	}

	public void setZhName(String zhName) {
		this.zhName = zhName;
	}
}

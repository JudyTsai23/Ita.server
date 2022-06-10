package com.web.server.enumcnst;

public enum MenuCategoryEnum {

	SALAD( "沙拉",0),
    PASTA("義大利麵",1),
    PIZZA("披薩",2),
    DESSERT("甜點",3),
    SOFTDRINKS("飲料",4),
    DRINKS("酒類",5);
	
	private String categoryName;
	private int categoryCd;
	
	private MenuCategoryEnum(String name, int cd) {
		this.categoryName = name;
		this.categoryCd = cd;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public int getCategoryCd() {
		return categoryCd;
	}

	public void setCategoryCd(int categoryCd) {
		this.categoryCd = categoryCd;
	}
	
}

package com.web.server.enumcnst;

public enum MenuSubCategoryEnum {

	NONE( "",0),
	RED_SAUCE( "紅醬",1),
    WHITE_SAUCE("白醬",2),
    RED_WINE("紅酒",3),
    WHITE_WINE("白酒",4);
	
	private String categoryName;
	private int categoryCd;
	
	private MenuSubCategoryEnum(String name, int cd) {
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

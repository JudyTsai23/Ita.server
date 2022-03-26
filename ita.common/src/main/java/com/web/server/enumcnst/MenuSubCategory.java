package com.web.server.enumcnst;

public enum MenuSubCategory {

	RED_SAUCE( "紅醬",0),
    WHITE_SAUCE("白醬",1),
    RED_WINE("紅酒",2),
    WHITE_WINE("白酒",3);
	
	private String categoryName;
	private int categoryCd;
	
	private MenuSubCategory(String name, int cd) {
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

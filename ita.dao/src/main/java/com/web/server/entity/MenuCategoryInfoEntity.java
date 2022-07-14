package com.web.server.entity;

public class MenuCategoryInfoEntity {

	private int categoryId; 			// 分類ID
	private String categoryName; 		// 分類名稱slug
	private String cateZhName; 			// 分類中文名稱
	private String categoryIcon;		// 分類icon
	private int categorySort; 			// 分類順序
	private int subCateId; 				// 子類別ID
	private String subCateName; 		// 子類別名稱
	private int subCateSort; 			// 子類別順序

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getCateZhName() {
		return cateZhName;
	}

	public void setCateZhName(String cateZhName) {
		this.cateZhName = cateZhName;
	}

	public String getCategoryIcon() {
		return categoryIcon;
	}

	public void setCategoryIcon(String categoryIcon) {
		this.categoryIcon = categoryIcon;
	}

	public int getCategorySort() {
		return categorySort;
	}

	public void setCategorySort(int categorySort) {
		this.categorySort = categorySort;
	}

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

}

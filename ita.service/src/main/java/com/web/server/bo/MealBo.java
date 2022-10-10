package com.web.server.bo;

import java.time.LocalDateTime;

public class MealBo {

	private String id; // 餐點流水號
	private int category; // 餐點種類
	private int subCategory; // 餐點次分類
	private int subCateSort; // 次分類順序
	private String subCategoryName; // 餐點次分類名稱
	private String name; // 餐點名稱
	private String description; // 餐點描述
	private String ingredient; // 內容物
	private String note; // 餐點提醒
	private int price; // 價格
	private String image; // 餐點圖片
	private int limitDate; // 期間限定的下架日期
	private int sort; // 餐點排序
	private String isPublic; // 是否公開
	private LocalDateTime addedTime; // 創建時間
	private LocalDateTime updTime; // 異動時間

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getCategory() {
		return category;
	}

	public void setCategory(int category) {
		this.category = category;
	}

	public int getSubCategory() {
		return subCategory;
	}

	public void setSubCategory(int subCategory) {
		this.subCategory = subCategory;
	}
	
	public int getSubCateSort() {
		return subCateSort;
	}

	public void setSubCateSort(int subCateSort) {
		this.subCateSort = subCateSort;
	}

	public String getSubCategoryName() {
		return subCategoryName;
	}

	public void setSubCategoryName(String subCategoryName) {
		this.subCategoryName = subCategoryName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getIngredient() {
		return ingredient;
	}

	public void setIngredient(String ingredient) {
		this.ingredient = ingredient;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public int getLimitDate() {
		return limitDate;
	}

	public void setLimitDate(int limitDate) {
		this.limitDate = limitDate;
	}

	public int getSort() {
		return sort;
	}

	public void setSort(int sort) {
		this.sort = sort;
	}

	public String getIsPublic() {
		return isPublic;
	}

	public void setIsPublic(String isPublic) {
		this.isPublic = isPublic;
	}

	public LocalDateTime getAddedTime() {
		return addedTime;
	}

	public void setAddedTime(LocalDateTime addedTime) {
		this.addedTime = addedTime;
	}

	public LocalDateTime getUpdTime() {
		return updTime;
	}

	public void setUpdTime(LocalDateTime updTime) {
		this.updTime = updTime;
	}

}

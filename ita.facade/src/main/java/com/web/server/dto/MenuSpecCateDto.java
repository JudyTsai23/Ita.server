package com.web.server.dto;

public class MenuSpecCateDto {
	
	private String categoryName;		// 餐點名稱
	private String mealName;			// 餐點名稱
	private String description;		// 餐點描述
	private String ingredient;		// 內容物
	private String note;			// 餐點提醒
	private int price;				// 價格
	private String image;			// 餐點圖片
	private int limitDate;			// 期間限定的下架日期
	
	public String getCategoryName() {
		return categoryName;
	}
	
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	
	public String getMealName() {
		return mealName;
	}
	
	public void setMealName(String mealName) {
		this.mealName = mealName;
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
}

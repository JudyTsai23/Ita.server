package com.web.server.dto;

// for 前台 消費者所看的餐點詳細資訊
public class MenuListDetailDto {

	private String name; // 餐點名稱
	private String description; // 餐點描述
	private String ingredient; // 內容物
	private String note; // 餐點提醒
	private int price; // 價格
	private String image; // 餐點圖片
	private int limitDate; // 期間限定的下架日期
	
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
}

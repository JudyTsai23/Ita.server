package com.web.server.dto;

public class Menu4CusListDetailDto {

	private String name;
	private int price;
	private String image;
	private String description;
	private String note;
	private String ingredient;
	private int limitDate; // 期間限定的下架日期
	private int sort; // 餐點順序
	private int subCateSort; // 餐點子類別順序

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getIngredient() {
		return ingredient;
	}

	public void setIngredient(String ingredient) {
		this.ingredient = ingredient;
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

	public int getSubCateSort() {
		return subCateSort;
	}

	public void setSubCateSort(int subCateSort) {
		this.subCateSort = subCateSort;
	}

}

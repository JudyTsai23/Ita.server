package com.web.server.vo;

public class MenuVo {

	private String category;	// 餐點種類
	private String subCategory;	// 餐點次分類
	private String name;		// 餐點名稱
	private String description;	// 餐點描述
	private String ingredient;	// 內容物
	private String note;		// 餐點提醒
	private int price;			// 價格
	private String image;		// 餐點圖片
	private String isLimited;	// 
	private String isPublic;	// 是否公開



	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getSubCategory() {
		return subCategory;
	}

	public void setSubCategory(String subCategory) {
		this.subCategory = subCategory;
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

	public String getIsLimited() {
		return isLimited;
	}

	public void setIsLimited(String isLimited) {
		this.isLimited = isLimited;
	}

	public String getIsPublic() {
		return isPublic;
	}

	public void setIsPublic(String isPublic) {
		this.isPublic = isPublic;
	}

}

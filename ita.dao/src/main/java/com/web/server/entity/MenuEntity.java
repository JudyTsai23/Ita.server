package com.web.server.entity;

import java.time.LocalDateTime;

import com.web.server.enumcnst.MenuCategory;
import com.web.server.enumcnst.MenuSubCategory;

public class MenuEntity {

	private String id;						// 餐點流水號
	private MenuCategory category;			// 餐點種類
	private MenuSubCategory subCategory; 	// 餐點次分類
	private String name;					// 餐點名稱
	private String description;				// 餐點描述
	private String ingredient;				// 內容物
	private String note;					// 餐點提醒
	private int price;						// 價格
	private String image;					// 餐點圖片
	private LocalDateTime addedTime;		// 創建時間
	private int limitDate;					// 期間限定的下架日期
	private int sort;						// 餐點排序
	private String isPublic;				// 是否公開
	private LocalDateTime updTime;			// 異動時間
	


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public MenuCategory getCategory() {
		return category;
	}

	public void setCategory(MenuCategory category) {
		this.category = category;
	}

	public MenuSubCategory getSubCategory() {
		return subCategory;
	}

	public void setSubCategory(MenuSubCategory subCategory) {
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

	public LocalDateTime getAddedTime() {
		return addedTime;
	}

	public void setAddedTime(LocalDateTime addedTime) {
		this.addedTime = addedTime;
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

	public LocalDateTime getUpdTime() {
		return updTime;
	}

	public void setUpdTime(LocalDateTime updTime) {
		this.updTime = updTime;
	}
}

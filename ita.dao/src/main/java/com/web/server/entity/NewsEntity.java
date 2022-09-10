package com.web.server.entity;

import com.web.server.enumcnst.NewsType;

public class NewsEntity {

	private String id; // 訊息流水號
	private NewsType type; // 訊息種類
	private String title; // 訊息標題
	private String description; // 訊息描述
	private String content; // 訊息內文
	private String image; // 圖片
	private int publishDate; // 發布時間
	private String isPublic; // 是否公開
	private String isTop; // 是否為置頂訊息
	private String updTime; // 異動時間

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public NewsType getType() {
		return type;
	}

	public void setType(NewsType type) {
		this.type = type;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public int getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(int publishDate) {
		this.publishDate = publishDate;
	}

	public String getIsPublic() {
		return isPublic;
	}

	public void setIsPublic(String isPublic) {
		this.isPublic = isPublic;
	}

	public String getIsTop() {
		return isTop;
	}

	public void setIsTop(String isTop) {
		this.isTop = isTop;
	}

	public String getUpdTime() {
		return updTime;
	}

	public void setUpdTime(String updTime) {
		this.updTime = updTime;
	}

}

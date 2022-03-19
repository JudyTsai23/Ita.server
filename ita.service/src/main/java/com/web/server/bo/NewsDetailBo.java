package com.web.server.bo;

import com.web.server.enumcnst.NewsType;

public class NewsDetailBo {

	private String id; // 訊息流水號
	private NewsType type; // 訊息種類
	private String title; // 訊息標題
	private String content; // 訊息內文
	private String image; // 圖片
	private String publishTime; // 發布時間
	private String isPublic; // 是否公開
	private String isTop; // 是否為置頂訊息

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

	public String getPublishTime() {
		return publishTime;
	}

	public void setPublishTime(String publishTime) {
		this.publishTime = publishTime;
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
}

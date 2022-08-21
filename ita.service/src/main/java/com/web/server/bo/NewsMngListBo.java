package com.web.server.bo;

import com.web.server.enumcnst.NewsType;

public class NewsMngListBo {

	private String id;
	private NewsType type;
	private String title;
	private int publishDate;
	private String isPublic;
	private String isTop;

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

}

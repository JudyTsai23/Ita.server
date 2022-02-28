package com.web.server.service;

import java.util.List;

import com.web.server.bo.NewsDetailBo;
import com.web.server.bo.NewsListBo;
import com.web.server.entity.NewsEntity;

public interface INewsService {

	/**
	 * 查詢訊息列表
	 */
	List<NewsListBo> queryNewsList();
	
	/**
	 * 新增訊息
	 */
	void addNews(NewsEntity newsEntity);
	
	/**
	 * 查詢特定訊息
	 */
	NewsDetailBo querySpecNews(String id);
	
	/**
	 * 刪除特定訊息
	 */
	void deleteSpecNews(String id);
}

package com.web.server.service;

import java.util.List;

import com.web.server.bo.NewsListBo;

public interface INewsService {

	/**
	 * 查詢訊息列表
	 */
	List<NewsListBo> queryNewsList();
}

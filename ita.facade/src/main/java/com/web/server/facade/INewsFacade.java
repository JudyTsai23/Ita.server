package com.web.server.facade;

import java.util.List;

import com.web.server.dto.NewsListDto;

public interface INewsFacade {

	/**
	 * 查詢訊息列表
	 */
	List<NewsListDto> queryNewsList();
}

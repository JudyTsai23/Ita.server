package com.web.server.facade;

import java.util.List;

import com.web.server.dto.NewsDetailDto;
import com.web.server.dto.NewsListDto;
import com.web.server.dto.NewsRangeDto;
import com.web.server.vo.NewsSpecVo;
import com.web.server.vo.NewsVo;

public interface INewsFacade {

	/**
	 * 查詢訊息列表
	 */
	List<NewsListDto> queryNewsList();
	
	/**
	 * 新增訊息
	 */
	void addNews(NewsVo newVo);
	
	/**
	 * 查詢特定訊息
	 */
	NewsDetailDto querySpecNews(String id);
	
	/**
	 * 刪除特定訊息
	 */
	void deleteSpecNews(String id);
	
	/**
	 * 更新訊息
	 */
	void updateNews(String id, NewsVo newsVo);
	
	/**
	 * 查詢特定範圍內的訊息
	 */
	NewsRangeDto querySpecRangeNews(NewsSpecVo newsSpecVo);
}

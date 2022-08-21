package com.web.server.service;

import java.util.List;

import com.web.server.bo.NewsDetailBo;
import com.web.server.bo.NewsListBo;
import com.web.server.bo.NewsMngDetailBo;
import com.web.server.bo.NewsMngListBo;
import com.web.server.entity.NewsEntity;

public interface INewsService {

	/**
	 * 訊息管理-查詢
	 */
	List<NewsMngListBo> queryNewsList();
	
	/**
	 * 訊息管理-查詢單一訊息詳細資訊
	 */
	NewsMngDetailBo querySingleNewsDetail(String id);
	
	/**
	 * 新增訊息
	 */
	void addNews(NewsEntity newsEntity);
	
	/**
	 * 修改訊息
	 */
	void updateNews(NewsEntity newsEntity);
	
	/**
	 * 查詢特定訊息
	 */
	NewsDetailBo querySingleNews(String id);
	
	/**
	 * 刪除特定訊息
	 */
	void deleteSingleNews(String id);
	
	/**
	 * 查詢特定範圍內的幾筆訊息
	 */
	List<NewsListBo> querySpecRangeNews(int count, int page);
	
	/**
	 * 查詢訊息總筆數
	 */
	int queryTotalNewsCount();
}

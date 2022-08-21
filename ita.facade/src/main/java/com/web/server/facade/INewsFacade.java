package com.web.server.facade;

import java.util.List;

import com.web.server.dto.NewsDetailDto;
import com.web.server.dto.NewsMngDetailDto;
import com.web.server.dto.NewsMngListDto;
import com.web.server.dto.NewsRangeDto;
import com.web.server.vo.NewsRangeVo;
import com.web.server.vo.NewsVo;

public interface INewsFacade {

	/**
	 * 訊息管理-查詢
	 */
	List<NewsMngListDto> queryNewsList();
	
	/**
	 * 訊息管理-查詢單一訊息詳細資訊
	 */
	NewsMngDetailDto querySingleNewsDetail(String id);
	
	/**
	 * 訊息修改-儲存(包含新增及修改)
	 */
	void updateSingleNews(NewsVo newsVo);
	
	/**
	 * 查詢特定訊息
	 */
	NewsDetailDto querySingleNews(String id);
	
	/**
	 * 刪除特定訊息
	 */
	void deleteSingleNews(String id);
	
	/**
	 * 查詢特定範圍內的訊息
	 */
	NewsRangeDto querySpecRangeNews(NewsRangeVo newsSpecVo);
}

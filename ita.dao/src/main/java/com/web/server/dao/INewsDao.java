package com.web.server.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.web.server.entity.NewsEntity;

@Mapper
public interface INewsDao {

	/**
	 * 查詢所有訊息
	 */
	List<NewsEntity> queryNews();

	/**
	 * 新增訊息
	 */
	void insertNews(@Param(value = "newsEntity") NewsEntity newsEntity);

	/**
	 * 查詢特定訊息
	 */
	NewsEntity querySpecNews(@Param(value = "newsId") String id);

	/**
	 * 刪除特定訊息
	 */
	void deleteSpecNews(@Param(value = "newsId") String id);

	/**
	 * 查詢最新幾筆訊息
	 */
	List<NewsEntity> querySpecRangeNews(@Param(value = "count") int count, @Param(value = "overCount") int overCount);
	
	/**
	 * 查詢總筆數
	 */
	int queryTotalNewsCount();
}

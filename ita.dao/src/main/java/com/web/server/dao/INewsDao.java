package com.web.server.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.web.server.entity.NewsEntity;

@Mapper
public interface INewsDao {

	/**
	 * 查詢所有訊息
	 * @return List<NewsEntity>
	 */
	List<NewsEntity> queryNews();
}

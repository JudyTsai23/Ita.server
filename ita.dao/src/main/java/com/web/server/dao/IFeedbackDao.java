package com.web.server.dao;

import org.apache.ibatis.annotations.Param;

import com.web.server.entity.FeedbackEntity;

public interface IFeedbackDao {

	/**
	 * 儲存回饋
	 */
	void insertFeedback(@Param(value = "feedback") FeedbackEntity entity);
}

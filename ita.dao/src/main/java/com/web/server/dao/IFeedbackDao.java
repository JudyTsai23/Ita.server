package com.web.server.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.web.server.entity.FeedbackDetailEntity;
import com.web.server.entity.FeedbackEntity;
import com.web.server.entity.FeedbackRateEntity;
import com.web.server.enumcnst.FeedbackPeriod;

public interface IFeedbackDao {

	/**
	 * 儲存回饋
	 */
	void insertFeedback(@Param(value = "feedback") FeedbackEntity entity);
	
	/**
	 * 查詢總意見回饋數量
	 */
	List<FeedbackDetailEntity> queryTotalCount();
	
	/**
	 * 查詢用餐時段數量
	 */
	List<FeedbackDetailEntity> queryPeriodCount(@Param(value = "period") FeedbackPeriod period);
	
	/**
	 * 查詢顧客感受評分
	 */
	List<FeedbackRateEntity> queryRating();
}

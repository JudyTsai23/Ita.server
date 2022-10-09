package com.web.server.service;

import java.util.List;

import com.web.server.bo.FeedbackDetailBo;
import com.web.server.bo.FeedbackRatingBo;
import com.web.server.entity.FeedbackEntity;
import com.web.server.enumcnst.FeedbackPeriod;

public interface IFeedbackService {

	/**
	 * 儲存回饋
	 */
	void saveFeedback(FeedbackEntity entity);
	
	/**
	 * 查詢總意見回饋數量
	 */
	List<FeedbackDetailBo> queryTotalFeedbackCount();
	
	/**
	 * 查詢用餐時段數量
	 */
	List<FeedbackDetailBo> queryPeriodCount(FeedbackPeriod period);
	
	/**
	 * 查詢顧客感受評分
	 */
	List<FeedbackRatingBo> queryRating();
}

package com.web.server.facade;

import com.web.server.dto.FeedbackPeriodDto;
import com.web.server.dto.FeedbackRatingDto;
import com.web.server.dto.FeedbackTotalCountDto;
import com.web.server.vo.FeedbackVo;

public interface IFeedbackFacade {

	/**
	 * 儲存回饋
	 */
	void saveFeedback(FeedbackVo feedbackVo);
	
	/**
	 * 查詢總意見回饋數量
	 */
	FeedbackTotalCountDto queryTotalFeedbackCount();
	
	/**
	 * 查詢用餐時段數量
	 */
	FeedbackPeriodDto queryPeriodCount();
	
	/**
	 * 查詢顧客感受評分
	 */
	FeedbackRatingDto queryRating();
}

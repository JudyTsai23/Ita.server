package com.web.server.facade;

import com.web.server.vo.FeedbackVo;

public interface IFeedbackFacade {

	/**
	 * 儲存回饋
	 */
	void saveFeedback(FeedbackVo feedbackVo);
}

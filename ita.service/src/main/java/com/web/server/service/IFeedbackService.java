package com.web.server.service;

import com.web.server.entity.FeedbackEntity;

public interface IFeedbackService {

	/**
	 * 儲存回饋
	 */
	void saveFeedback(FeedbackEntity entity);
}

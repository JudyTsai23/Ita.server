package com.web.server.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.web.server.dao.IFeedbackDao;
import com.web.server.entity.FeedbackEntity;
import com.web.server.service.IFeedbackService;

@Component
public class FeedbackServiceImpl implements IFeedbackService {

	@Autowired
	private IFeedbackDao feedbackDao;
	
	/**
	 * 儲存回饋
	 */
	@Override
	public void saveFeedback(FeedbackEntity entity) {
		feedbackDao.insertFeedback(entity);
	}
}

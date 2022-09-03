package com.web.server.facade.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.web.server.entity.FeedbackEntity;
import com.web.server.enumcnst.FeedbackPeriod;
import com.web.server.enumcnst.FeedbackTopic;
import com.web.server.facade.IFeedbackFacade;
import com.web.server.service.IFeedbackService;
import com.web.server.vo.FeedbackVo;

@Component
public class FeedbackFacadeImpl implements IFeedbackFacade {

	@Autowired IFeedbackService feedbackService;
	
	/**
	 * 儲存回饋
	 */
	@Override
	public void saveFeedback(FeedbackVo feedbackVo) {
		FeedbackEntity entity = new FeedbackEntity();
		BeanUtils.copyProperties(feedbackVo, entity);
		entity.setTopic(FeedbackTopic.getEnumById(feedbackVo.getTopic()));
		entity.setPeriod(FeedbackPeriod.getEnumById(feedbackVo.getPeriod()));;
		feedbackService.saveFeedback(entity);
	}
}

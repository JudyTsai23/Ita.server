package com.web.server.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.web.server.bo.FeedbackDetailBo;
import com.web.server.bo.FeedbackRatingBo;
import com.web.server.dao.IFeedbackDao;
import com.web.server.entity.FeedbackDetailEntity;
import com.web.server.entity.FeedbackEntity;
import com.web.server.entity.FeedbackRateEntity;
import com.web.server.enumcnst.FeedbackPeriod;
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
	
	/**
	 * 查詢總意見回饋數量
	 */
	@Override
	public List<FeedbackDetailBo> queryTotalFeedbackCount() {
		List<FeedbackDetailEntity> entityList = feedbackDao.queryTotalCount();
		List<FeedbackDetailBo> boList = new ArrayList<>();
		entityList.forEach((entity) -> {
			FeedbackDetailBo bo = new FeedbackDetailBo();
			BeanUtils.copyProperties(entity, bo);
			boList.add(bo);
		});
		return boList;
	}
	
	/**
	 * 查詢用餐時段數量
	 */
	@Override
	public List<FeedbackDetailBo> queryPeriodCount(FeedbackPeriod period) {
		List<FeedbackDetailEntity> entityList = feedbackDao.queryPeriodCount(period);
		List<FeedbackDetailBo> boList = new ArrayList<>();
		entityList.forEach((entity) -> {
			FeedbackDetailBo bo = new FeedbackDetailBo();
			BeanUtils.copyProperties(entity, bo);
			boList.add(bo);
		});
		return boList;
	}
	
	/**
	 * 查詢顧客感受評分
	 */
	@Override
	public List<FeedbackRatingBo> queryRating() {
		List<FeedbackRatingBo> totalList = new ArrayList<>();
		List<FeedbackRateEntity> entityList = feedbackDao.queryRating();
		for(int i = 1; i <= 5 ; i++) {
			FeedbackRateEntity obj = new FeedbackRateEntity();
			obj.setRating(i);
			obj.setCount(0);
			
			List<FeedbackRateEntity> entity = entityList.stream().filter(e -> e.getRating() == obj.getRating()).collect(Collectors.toList());
			if(entity.size() > 0) {
				obj.setCount(entity.get(0).getCount());
			}
			
			FeedbackRatingBo bo = new FeedbackRatingBo();
			BeanUtils.copyProperties(obj, bo);
			totalList.add(bo);
		}
		return totalList;
	}
}

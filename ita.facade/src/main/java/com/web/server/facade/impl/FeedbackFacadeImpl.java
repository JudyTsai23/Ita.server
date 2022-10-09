package com.web.server.facade.impl;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.web.server.bo.FeedbackDetailBo;
import com.web.server.bo.FeedbackRatingBo;
import com.web.server.dto.FeedbackDetailDto;
import com.web.server.dto.FeedbackPeriodDto;
import com.web.server.dto.FeedbackRatingDetailDto;
import com.web.server.dto.FeedbackRatingDto;
import com.web.server.dto.FeedbackTotalCountDto;
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
	
	/**
	 * 查詢總意見回饋數量
	 */
	@Override
	public FeedbackTotalCountDto queryTotalFeedbackCount() {
		List<FeedbackDetailBo> boList = feedbackService.queryTotalFeedbackCount();
		FeedbackTotalCountDto dto = new FeedbackTotalCountDto();
		List<FeedbackDetailDto> detailList = new ArrayList<>();
		boList.forEach((bo) -> {
			FeedbackDetailDto detailDto = new FeedbackDetailDto();
			BeanUtils.copyProperties(bo, detailDto);
			detailList.add(detailDto);
		});
		
		int totalCount = 0;
		for(FeedbackDetailBo bo : boList) {
			totalCount += bo.getCount();
		}
		dto.setTotalCount(totalCount);
		dto.setCountList(detailList);
		
		return dto;
	}
	
	/**
	 * 查詢用餐時段數量
	 */
	@Override
	public FeedbackPeriodDto queryPeriodCount() {
		List<FeedbackDetailBo> lunchList = feedbackService.queryPeriodCount(FeedbackPeriod.LUNCH);
		List<FeedbackDetailBo> dinnerList = feedbackService.queryPeriodCount(FeedbackPeriod.DINNER);
		List<FeedbackDetailDto> lunchDtoList = new ArrayList<>();
		List<FeedbackDetailDto> dinnerDtoList = new ArrayList<>();
		
		lunchList.forEach((lunch) -> {
			FeedbackDetailDto detailDto = new FeedbackDetailDto();
			BeanUtils.copyProperties(lunch, detailDto);
			lunchDtoList.add(detailDto);
		});
		dinnerList.forEach((dinner) -> {
			FeedbackDetailDto detailDto = new FeedbackDetailDto();
			BeanUtils.copyProperties(dinner, detailDto);
			dinnerDtoList.add(detailDto);
		});
		FeedbackPeriodDto dto = new FeedbackPeriodDto();
		dto.setLunchList(lunchDtoList);
		dto.setDinnerList(dinnerDtoList);
		return dto;
	}
	
	/**
	 * 查詢顧客感受評分
	 */
	@Override 
	public FeedbackRatingDto queryRating() {
		FeedbackRatingDto dto = new FeedbackRatingDto();
		
		List<FeedbackRatingBo> boList = feedbackService.queryRating();
		List<FeedbackRatingDetailDto> rateList = new ArrayList<>();
		boList.forEach((bo) -> {
			FeedbackRatingDetailDto detailDto = new FeedbackRatingDetailDto();
			detailDto.setCount(bo.getCount());
			detailDto.setRating(bo.getRating());
			rateList.add(detailDto);
		});
		
		double sum = 0;
		int totalCount = 0;
		for(FeedbackRatingBo bo : boList) {
			totalCount += bo.getCount();
			sum += (bo.getCount() * bo.getRating());
		}
		double avg = sum / totalCount;
		
		DecimalFormat df = new DecimalFormat("###.#");
		dto.setAvgRate(df.format(avg));
		dto.setRatingList(rateList);
		return dto;
	}
}

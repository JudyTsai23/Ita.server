package com.web.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.web.server.cnst.AppCode;
import com.web.server.dto.FeedbackPeriodDto;
import com.web.server.dto.FeedbackRatingDto;
import com.web.server.dto.FeedbackTotalCountDto;
import com.web.server.facade.IFeedbackFacade;
import com.web.server.rest.IRestBase;
import com.web.server.rest.RestResult;
import com.web.server.vo.FeedbackVo;

@RestController
@RequestMapping("/feedback")
public class FeedbackController implements IRestBase {


	@Autowired IFeedbackFacade feedbackFacade;
	
	/**
	 * 儲存回饋
	 */
	@PostMapping
	public RestResult saveFeedback(@RequestBody FeedbackVo feedbackVo) {
		feedbackFacade.saveFeedback(feedbackVo);
		return buildResult(AppCode.SERVER.SUCCESS.INSERT_SUCCESS.getCode(), null);
	}
	
	/**
	 * 回饋分析-查詢所有意見回饋數量
	 */
	@GetMapping
	public RestResult queryTotalFeedbackCountByMonth() {
		FeedbackTotalCountDto countVo = feedbackFacade.queryTotalFeedbackCount();
		return buildResult(AppCode.SERVER.SUCCESS.QUERY_SUCCESS.getCode(), countVo);
	}
	
	/**
	 * 回饋分析-查詢用餐時段數量
	 */
	@GetMapping("/period")
	public RestResult queryPeriodCountByMonth() {
		FeedbackPeriodDto periodDto = feedbackFacade.queryPeriodCount();
		return buildResult(AppCode.SERVER.SUCCESS.QUERY_SUCCESS.getCode(), periodDto);
	}
	
	/**
	 * 回饋分析-查詢顧客感受評分
	 */
	@GetMapping("/rating")
	public RestResult queryRating() {
		FeedbackRatingDto ratingDto = feedbackFacade.queryRating();
		return buildResult(AppCode.SERVER.SUCCESS.QUERY_SUCCESS.getCode(), ratingDto);
	}
}

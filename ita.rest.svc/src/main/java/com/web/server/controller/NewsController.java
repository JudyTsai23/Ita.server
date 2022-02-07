package com.web.server.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.web.server.config.AppCode;
import com.web.server.dto.NewsListDto;
import com.web.server.facade.INewsFacade;
import com.web.server.rest.IRestBase;
import com.web.server.rest.RestResult;

/**
 * 訊息專區
 */
@RestController
public class NewsController implements IRestBase {

	@Autowired
	private INewsFacade newsFacade;
	
	/**
	 * 查詢訊息列表
	 */
	@GetMapping("/news")
	public RestResult queryNewsList() {
		List<NewsListDto> resultList = newsFacade.queryNewsList();
		return buildResult(AppCode.SERVER.SUCCESS.QUERY_SUCCESS.getCode(), resultList);
	}
	
}

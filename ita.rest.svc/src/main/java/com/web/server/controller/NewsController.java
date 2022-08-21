package com.web.server.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.web.server.cnst.AppCode;
import com.web.server.dto.NewsDetailDto;
import com.web.server.dto.NewsMngDetailDto;
import com.web.server.dto.NewsMngListDto;
import com.web.server.dto.NewsRangeDto;
import com.web.server.facade.INewsFacade;
import com.web.server.rest.IRestBase;
import com.web.server.rest.RestResult;
import com.web.server.vo.NewsRangeVo;
import com.web.server.vo.NewsVo;

/**
 * 訊息專區
 */
@RestController
@RequestMapping("/news")
public class NewsController implements IRestBase {

	@Autowired
	private INewsFacade newsFacade;
	
	/**
	 * 訊息管理-查詢
	 */
	@GetMapping
	public RestResult queryNewsList() {
		List<NewsMngListDto> resultList = newsFacade.queryNewsList();
		return buildResult(AppCode.SERVER.SUCCESS.QUERY_SUCCESS.getCode(), resultList);
	}
	
	/**
	 * 訊息管理-查詢單一訊息詳細資訊
	 */
	@GetMapping("/mng/{id}")
	public RestResult querySingleNewsDetail(@PathVariable String id) {
		NewsMngDetailDto result = newsFacade.querySingleNewsDetail(id);
		return buildResult(AppCode.SERVER.SUCCESS.QUERY_SUCCESS.getCode(), result);
	}
	
	/**
	 * 訊息管理-刪除
	 */
	@DeleteMapping("/{id}")
	public RestResult deleteSingleNews(@PathVariable String id) {
		newsFacade.deleteSingleNews(id);
		return buildResult(AppCode.SERVER.SUCCESS.DELETE_SUCCESS.getCode(), null);
	}
	
	/**
	 * 訊息修改-儲存(包含新增及修改)
	 */
	@PostMapping("/save")
	public RestResult updateSingleNews(@RequestBody NewsVo newsVo) {
		newsFacade.updateSingleNews(newsVo);
		return buildResult(AppCode.SERVER.SUCCESS.UPDATE_SUCCESS.getCode(), null);
	}
	
	
	/**
	 * 訊息專區-查詢
	 */
	@PostMapping("/range")
	public RestResult querySpecRangeNews(@RequestBody NewsRangeVo newsSpecVo) {
		NewsRangeDto resultList = newsFacade.querySpecRangeNews(newsSpecVo);
		return buildResult(AppCode.SERVER.SUCCESS.QUERY_SUCCESS.getCode(), resultList);
	}

	/**
	 * 訊息專區-查詢特定一筆訊息
	 */
	@GetMapping("/{id}")
	public RestResult querySingleNews(@PathVariable String id) {
		NewsDetailDto newsDetailDto = newsFacade.querySingleNews(id);
		return buildResult(AppCode.SERVER.SUCCESS.QUERY_SUCCESS.getCode(), newsDetailDto);
	}
}

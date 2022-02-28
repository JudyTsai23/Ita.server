package com.web.server.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.web.server.cnst.AppCode;
import com.web.server.dto.NewsDetailDto;
import com.web.server.dto.NewsListDto;
import com.web.server.facade.INewsFacade;
import com.web.server.rest.IRestBase;
import com.web.server.rest.RestResult;
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
	 * 查詢訊息列表
	 */
	@GetMapping("")
	public RestResult queryNewsList() {
		List<NewsListDto> resultList = newsFacade.queryNewsList();
		return buildResult(AppCode.SERVER.SUCCESS.QUERY_SUCCESS.getCode(), resultList);
	}
	
	/**
	 * 新增訊息
	 */
	@PostMapping("")
	public RestResult addNews(@RequestBody NewsVo newsVo) {
		newsFacade.addNews(newsVo);
		return buildResult(AppCode.SERVER.SUCCESS.INSERT_SUCCESS.getCode(), null);
	}
	
	/**
	 * 查詢特定一筆訊息
	 */
	@GetMapping("/{id}")
	public RestResult querySpecNews(@PathVariable String id) {
		NewsDetailDto newsDetailDto = newsFacade.querySpecNews(id);
		return buildResult(AppCode.SERVER.SUCCESS.QUERY_SUCCESS.getCode(), newsDetailDto);
	}
	
	/**
	 * 刪除特定訊息
	 */
	@DeleteMapping("/{id}")
	public RestResult deleteSpecNews(@PathVariable String id) {
		newsFacade.deleteSpecNews(id);
		return buildResult(AppCode.SERVER.SUCCESS.DELETE_SUCCESS.getCode(), null);
	}
	
	/**
	 * 更新訊息
	 */
	@PutMapping("/{id}")
	public RestResult updateNews(@PathVariable String id, @RequestBody NewsVo newsVo) {
		newsFacade.updateNews(id, newsVo);
		return buildResult(AppCode.SERVER.SUCCESS.UPDATE_SUCCESS.getCode(), null);
	}
}

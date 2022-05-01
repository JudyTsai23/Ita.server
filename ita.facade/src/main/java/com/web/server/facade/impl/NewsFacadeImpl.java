package com.web.server.facade.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.web.server.bo.NewsDetailBo;
import com.web.server.bo.NewsListBo;
import com.web.server.dto.NewsDetailDto;
import com.web.server.dto.NewsListDto;
import com.web.server.dto.NewsRangeDto;
import com.web.server.entity.NewsEntity;
import com.web.server.facade.INewsFacade;
import com.web.server.service.INewsService;
import com.web.server.util.NumberGenerator;
import com.web.server.vo.NewsSpecVo;
import com.web.server.vo.NewsVo;

@Component
public class NewsFacadeImpl implements INewsFacade {

	@Autowired
	private INewsService newsService;
	
	/**
	 * 查詢訊息列表
	 */
	@Override
	public List<NewsListDto> queryNewsList() {
		List<NewsListBo> newsBoList = newsService.queryNewsList();
		List<NewsListDto> newsDtoList = new ArrayList<>();
		newsBoList.forEach((news) -> {
			NewsListDto target = new NewsListDto();
			target.setType(news.getType().getTypeName());
			BeanUtils.copyProperties(news, target);
			newsDtoList.add(target);
		});
		return newsDtoList;
	}
	
	/**
	 * 新增訊息
	 */
	@Override
	public void addNews(NewsVo newsVo) {
		String serialNum = NumberGenerator.getSerialNum();
		
		NewsEntity newsEntity = new NewsEntity();
		BeanUtils.copyProperties(newsVo, newsEntity);
		newsEntity.setId(serialNum);
		newsEntity.setUpdTime(LocalDateTime.now());
		
		newsService.addNews(newsEntity);
	}
	
	/**
	 * 查詢特定訊息
	 */
	@Override 
	public NewsDetailDto querySpecNews(String id) {
		NewsDetailBo newsDetailBo = newsService.querySpecNews(id);
		NewsDetailDto newsDetailDto = new NewsDetailDto();
		newsDetailDto.setType(newsDetailBo.getType().getTypeName());
		BeanUtils.copyProperties(newsDetailBo, newsDetailDto);
		return newsDetailDto;
	}
	
	/**
	 * 刪除特定訊息
	 */
	@Override
	public void deleteSpecNews(String id) {
		newsService.deleteSpecNews(id);
	}
	
	/**
	 * 更新訊息
	 */
	@Override
	public void updateNews(String id, NewsVo newsVo) {
		newsService.deleteSpecNews(id);
		
		NewsEntity newsEntity = new NewsEntity();
		BeanUtils.copyProperties(newsVo, newsEntity);
		newsEntity.setId(id);
		newsEntity.setUpdTime(LocalDateTime.now());
		
		newsService.addNews(newsEntity);
	}

	/**
	 * 查詢特定範圍內的訊息
	 */
	@Override
	public NewsRangeDto querySpecRangeNews(NewsSpecVo newsSpecVo) {
		List<NewsListBo> newsBoList = newsService.querySpecRangeNews(newsSpecVo.getCount(), newsSpecVo.getPage());
		int totalCount = newsService.queryTotalNewsCount();
		NewsRangeDto rangeDto = new NewsRangeDto();
		rangeDto.setTotal(totalCount);
		rangeDto.setList(newsBoList);
		return rangeDto;
	}
}

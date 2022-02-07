package com.web.server.facade.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.web.server.bo.NewsListBo;
import com.web.server.dto.NewsListDto;
import com.web.server.facade.INewsFacade;
import com.web.server.service.INewsService;

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
			BeanUtils.copyProperties(news, target);
			newsDtoList.add(target);
		});
		return newsDtoList;
	}

}

package com.web.server.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.server.bo.NewsDetailBo;
import com.web.server.bo.NewsListBo;
import com.web.server.dao.INewsDao;
import com.web.server.entity.NewsEntity;
import com.web.server.service.INewsService;

@Service
public class NewsServiceImpl implements INewsService {

	@Autowired
	private INewsDao newsDao;

	/**
	 * 查詢訊息列表
	 */
	@Override
	public List<NewsListBo> queryNewsList() {
		List<NewsEntity> newsEntityList = newsDao.queryNews();
		List<NewsListBo> newsBoList = new ArrayList<>();
		newsEntityList.forEach((news) -> {
			NewsListBo target = new NewsListBo();
			BeanUtils.copyProperties(news, target);
			newsBoList.add(target);
		});
		return newsBoList;
	}

	/**
	 * 新增訊息
	 */
	@Override
	public void addNews(NewsEntity newsEntity) {
		newsDao.insertNews(newsEntity);
	}

	/**
	 * 查詢特定訊息
	 */
	@Override
	public NewsDetailBo querySpecNews(String id) {
		NewsEntity newsEntity = newsDao.querySpecNews(id);
		NewsDetailBo newsDetailBo = new NewsDetailBo();
		BeanUtils.copyProperties(newsEntity, newsDetailBo);
		return newsDetailBo;
	}

	/**
	 * 刪除特定訊息
	 */
	@Override
	public void deleteSpecNews(String id) {
		newsDao.deleteSpecNews(id);
	}

	/**
	 * 查詢最新幾筆訊息
	 */
	@Override
	public List<NewsListBo> querySpecRangeNews(int count, int page) {
		// 跳過的筆數
		int overCount = count * (page - 1);
		List<NewsEntity> newsEntityList = newsDao.querySpecRangeNews(count, overCount);
		List<NewsListBo> newsBoList = new ArrayList<>();
		newsEntityList.forEach((news) -> {
			NewsListBo target = new NewsListBo();
			BeanUtils.copyProperties(news, target);
			newsBoList.add(target);
		});
		return newsBoList;
	}
}

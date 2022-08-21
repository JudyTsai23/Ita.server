package com.web.server.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.server.bo.NewsDetailBo;
import com.web.server.bo.NewsListBo;
import com.web.server.bo.NewsMngDetailBo;
import com.web.server.bo.NewsMngListBo;
import com.web.server.dao.INewsDao;
import com.web.server.entity.NewsEntity;
import com.web.server.service.INewsService;

@Service
public class NewsServiceImpl implements INewsService {

	@Autowired
	private INewsDao newsDao;

	/**
	 * 訊息管理-查詢
	 */
	@Override
	public List<NewsMngListBo> queryNewsList() {
		List<NewsEntity> newsEntityList = newsDao.queryNews();
		List<NewsMngListBo> newsBoList = new ArrayList<>();
		newsEntityList.forEach((news) -> {
			NewsMngListBo target = new NewsMngListBo();
			BeanUtils.copyProperties(news, target);
			newsBoList.add(target);
		});
		return newsBoList;
	}
	
	/**
	 * 訊息管理-查詢單一訊息詳細資訊
	 */
	@Override
	public NewsMngDetailBo querySingleNewsDetail(String id) {
		NewsEntity entity = newsDao.querySingleNewsDetail(id);
		NewsMngDetailBo bo = new NewsMngDetailBo();
		BeanUtils.copyProperties(entity, bo);
		return bo;
	}

	/**
	 * 新增訊息
	 */
	@Override
	public void addNews(NewsEntity newsEntity) {
		newsDao.insertNews(newsEntity);
	}
	
	/**
	 * 修改訊息
	 */
	@Override
	public void updateNews(NewsEntity newsEntity) {
		newsDao.updateNews(newsEntity);
	}

	/**
	 * 查詢特定訊息
	 */
	@Override
	public NewsDetailBo querySingleNews(String id) {
		NewsEntity newsEntity = newsDao.querySingleNews(id);
		NewsDetailBo newsDetailBo = null;
		if(newsEntity != null) {
			newsDetailBo = new NewsDetailBo();
			BeanUtils.copyProperties(newsEntity, newsDetailBo);
		}
		return newsDetailBo;
	}

	/**
	 * 刪除特定訊息
	 */
	@Override
	public void deleteSingleNews(String id) {
		newsDao.deleteSingleNews(id);
	}

	/**
	 * 查詢特定範圍內的幾筆訊息
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

	/**
	 * 查詢訊息總筆數
	 */
	@Override
	public int queryTotalNewsCount() {
		// 查詢總筆數
		int totalCount = newsDao.queryTotalNewsCount();
		return totalCount;
	}
}

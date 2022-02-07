package com.web.server.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
		// 去資料庫查詢
		List<NewsEntity> newsEntityList = newsDao.queryNews();
		// 宣告存放結果的List
		List<NewsListBo> newsBoList = new ArrayList<>();
		// 將需要的部分屬性複製並提取出來
		newsEntityList.forEach((news) -> {
			NewsListBo target = new NewsListBo();
			BeanUtils.copyProperties(news, target);
			newsBoList.add(target);
		});
		return newsBoList;
	}
}

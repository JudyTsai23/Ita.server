package com.web.server.facade.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.web.server.bo.NewsDetailBo;
import com.web.server.bo.NewsListBo;
import com.web.server.bo.NewsMngDetailBo;
import com.web.server.bo.NewsMngListBo;
import com.web.server.dto.NewsDetailDto;
import com.web.server.dto.NewsListDto;
import com.web.server.dto.NewsMngDetailDto;
import com.web.server.dto.NewsMngListDto;
import com.web.server.dto.NewsRangeDto;
import com.web.server.entity.NewsEntity;
import com.web.server.enumcnst.NewsType;
import com.web.server.facade.INewsFacade;
import com.web.server.service.INewsService;
import com.web.server.util.DateTimeGenerator;
import com.web.server.util.NumberGenerator;
import com.web.server.vo.NewsRangeVo;
import com.web.server.vo.NewsVo;

@Component
public class NewsFacadeImpl implements INewsFacade {

	@Autowired
	private INewsService newsService;

	/**
	 * 訊息管理-查詢
	 */
	@Override
	public List<NewsMngListDto> queryNewsList() {
		List<NewsMngListBo> newsBoList = newsService.queryNewsList();
		List<NewsMngListDto> newsDtoList = new ArrayList<>();
		newsBoList.forEach((news) -> {
			NewsMngListDto target = new NewsMngListDto();
			target.setType(news.getType().getTypeName());
			target.setTop("1".equals(news.getIsTop()) ? true : false);
			target.setPublic("1".equals(news.getIsPublic()) ? true : false);
			BeanUtils.copyProperties(news, target);
			newsDtoList.add(target);
		});
		return newsDtoList;
	}

	/**
	 * 訊息管理-查詢單一訊息詳細資訊
	 */
	@Override
	public NewsMngDetailDto querySingleNewsDetail(String id) {
		NewsMngDetailBo bo = newsService.querySingleNewsDetail(id);
		NewsMngDetailDto dto = new NewsMngDetailDto();
		dto.setType(bo.getType().getTypeCd());
		dto.setTop("1".equals(bo.getIsTop()) ? true : false);
		dto.setPublic("1".equals(bo.getIsPublic()) ? true : false);
		BeanUtils.copyProperties(bo, dto);
		return dto;
	}

	/**
	 * 訊息修改-儲存(包含新增及修改)
	 */
	@Override
	public void updateSingleNews(NewsVo newsVo) {
		String newsId = newsVo.getId();
		NewsEntity newsEntity = new NewsEntity();
		BeanUtils.copyProperties(newsVo, newsEntity);
		newsEntity.setType(NewsType.getTypeByCd(newsVo.getType()));
		newsEntity.setIsPublic(newsVo.isPublic() ? "1" : "0");
		newsEntity.setIsTop(newsVo.isTop() ? "1" : "0");
		newsEntity.setUpdTime(DateTimeGenerator.getCurrentDate_YYYY_MM_dd_HH_mm_ss());

		if (!"".equals(newsId)) {
			// 若 ID 不為空，則為修改
			newsService.updateNews(newsEntity);
		} else {
			// 若沒有 ID 則為新增
			String serialNum = NumberGenerator.getSerialNum();
			newsEntity.setId(serialNum);
			newsEntity.setType(NewsType.getTypeByCd(newsVo.getType()));
			newsEntity.setIsPublic(newsVo.isPublic() ? "1" : "0");
			newsEntity.setIsTop(newsVo.isTop() ? "1" : "0");
			newsService.addNews(newsEntity);
		}
	}

	/**
	 * 查詢特定訊息
	 */
	@Override
	public NewsDetailDto querySingleNews(String id) {
		NewsDetailBo newsDetailBo = newsService.querySingleNews(id);
		NewsDetailDto newsDetailDto = null;
		if (newsDetailBo != null) {
			newsDetailDto = new NewsDetailDto();
			newsDetailDto.setType(newsDetailBo.getType().getTypeName());
			BeanUtils.copyProperties(newsDetailBo, newsDetailDto);
		}
		return newsDetailDto;
	}

	/**
	 * 刪除特定訊息
	 */
	@Override
	public void deleteSingleNews(String id) {
		newsService.deleteSingleNews(id);
	}

	/**
	 * 訊息專區-查詢特定範圍內的訊息
	 */
	@Override
	public NewsRangeDto querySpecRangeNews(NewsRangeVo newsSpecVo) {
		List<NewsListBo> newsBoList = newsService.querySpecRangeNews(newsSpecVo.getCount(), newsSpecVo.getPage());
		// 計算總頁數用
		int totalCount = newsService.queryTotalNewsCount();

		// 先轉換過名稱
		List<NewsListDto> newsDtoList = new ArrayList<>();
		newsBoList.forEach((news) -> {
			NewsListDto target = new NewsListDto();
			target.setType(news.getType().getTypeName());
			BeanUtils.copyProperties(news, target);
			newsDtoList.add(target);
		});

		NewsRangeDto rangeDto = new NewsRangeDto();
		rangeDto.setTotal(totalCount);
		rangeDto.setList(newsDtoList);
		return rangeDto;
	}
}

package com.web.server.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.server.bo.MenuListBo;
import com.web.server.dao.IMenuDao;
import com.web.server.entity.MenuEntity;
import com.web.server.entity.MenuSpecCateEntity;
import com.web.server.service.IMenuService;
import com.web.server.util.DateTimeGenerator;

@Service
public class MenuServiceImpl implements IMenuService {

	@Autowired
	private IMenuDao menuDao;

	/**
	 * 查詢所有餐點列表
	 */
	@Override
	public List<MenuListBo> queryMenuList(int today) {
		List<MenuEntity> menuEntityList = menuDao.queryMenu(today);
		List<MenuListBo> menuBoList = new ArrayList<>();
		menuEntityList.forEach((menu) -> {
			MenuListBo target = new MenuListBo();
			BeanUtils.copyProperties(menu, target);
			menuBoList.add(target);
		});
		return menuBoList;
	}
	
	/**
	 * 查詢特定種類的餐點
	 */
	@Override
	public List<MenuSpecCateEntity> queryMenuSpecCate(int category) {
		int today = Integer.parseInt(DateTimeGenerator.getCurrentDate_YYYYMMdd());
		return menuDao.queryMenuSpecCate(category, today);
	}

	/**
	 * 新增餐點
	 */
	@Override
	public void addMenu(MenuEntity menuEntity) {
		menuDao.insertMenu(menuEntity);
	}

	/**
	 * 刪除特定餐點
	 */
	@Override
	public void deleteSpecMenu(String id) {
		menuDao.deleteSpecMenu(id);
	}
}

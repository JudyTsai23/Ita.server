package com.web.server.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.server.bo.MenuListBo;
import com.web.server.dao.IMenuDao;
import com.web.server.entity.MenuEntity;
import com.web.server.service.IMenuService;

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
	 * 新增餐點
	 */
	@Override
	public void addMenu(MenuEntity menuEntity) {
		menuDao.insertMenu(menuEntity);
	}

	/**
	 * 查詢特定餐點
	 */
	@Override
	public MenuListBo querySpecMenu(String id) {
		MenuEntity menuEntity = menuDao.querySpecMenu(id);
		MenuListBo menuListBo = new MenuListBo();
		BeanUtils.copyProperties(menuEntity, menuListBo);
		return menuListBo;
	}

	/**
	 * 刪除特定餐點
	 */
	@Override
	public void deleteSpecMenu(String id) {
		menuDao.deleteSpecMenu(id);
	}

	/**
	 * 查詢特定種類的餐點
	 */
	@Override
	public List<MenuListBo> queryCategoryMenu(String category, int today) {
		List<MenuEntity> menuEntityList = menuDao.queryCategoryMenu(category, today);
		List<MenuListBo> menuBoList = new ArrayList<>();
		menuEntityList.forEach((menu) -> {
			MenuListBo target = new MenuListBo();
			BeanUtils.copyProperties(menu, target);
			menuBoList.add(target);
		});
		return menuBoList;
	}
}

package com.web.server.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.server.bo.MenuCategoryListBo;
import com.web.server.bo.MenuCategoryDetailBo;
import com.web.server.dao.IMenuCategoryDao;
import com.web.server.entity.MenuCategoryEntity;
import com.web.server.service.IMenuCategoryService;

@Service
public class MenuCategoryServiceImpl implements IMenuCategoryService {

	@Autowired
	private IMenuCategoryDao menuCategoryDao;

	/**
	 * 查詢所有餐點種類(列表)
	 */
	@Override
	public List<MenuCategoryListBo> queryMenuCategoryList() {
		List<MenuCategoryEntity> menuCategoryEntityList = menuCategoryDao.queryMenuCategory();
		List<MenuCategoryListBo> menuCategoryBoList = new ArrayList<>();
		menuCategoryEntityList.forEach((menuCategory) -> {
			MenuCategoryListBo target = new MenuCategoryListBo();
			BeanUtils.copyProperties(menuCategory, target);
			menuCategoryBoList.add(target);
		});
		return menuCategoryBoList;
	}

	/**
	 * 查詢所有餐點種類(顯示標題用)
	 */
	@Override
	public List<MenuCategoryDetailBo> queryMenuCategoryIconList() {
		List<MenuCategoryEntity> menuCategoryEntityList = menuCategoryDao.queryMenuCategory();
		List<MenuCategoryDetailBo> menuCategoryBoList = new ArrayList<>();
		menuCategoryEntityList.forEach((menuCategory) -> {
			MenuCategoryDetailBo target = new MenuCategoryDetailBo();
			BeanUtils.copyProperties(menuCategory, target);
			menuCategoryBoList.add(target);
		});
		return menuCategoryBoList;
	}

	/**
	 * 新增餐點種類
	 */
	@Override
	public void addMenuCategory(MenuCategoryEntity menuCategoryEntity) {
		menuCategoryDao.insertMenuCategory(menuCategoryEntity);
	}

	/**
	 * 查詢特定餐點種類
	 */
	@Override
	public MenuCategoryDetailBo querySpecMenuCategory(String id) {
		MenuCategoryEntity menuCategoryEntity = menuCategoryDao.querySpecMenuCategory(id);
		MenuCategoryDetailBo menuCategoryDetailBo = new MenuCategoryDetailBo();
		BeanUtils.copyProperties(menuCategoryEntity, menuCategoryDetailBo);
		return menuCategoryDetailBo;
	}

	/**
	 * 刪除特定餐點種類
	 */
	@Override
	public void deleteSpecMenuCategory(String id) {
		menuCategoryDao.deleteSpecMenuCategory(id);
	}
}

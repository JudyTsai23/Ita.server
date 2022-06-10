package com.web.server.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.server.bo.MenuSubCategoryListBo;
import com.web.server.bo.MenuSubCategorySpecBo;
import com.web.server.dao.IMenuSubCategoryDao;
import com.web.server.entity.MenuSubCategoryEntity;
import com.web.server.service.IMenuSubCategoryService;

@Service
public class MenuSubCategoryServiceImpl implements IMenuSubCategoryService {

	@Autowired
	private IMenuSubCategoryDao menuSubCategoryDao;

	/**
	 * 查詢所有餐點次分類
	 */
	@Override
	public List<MenuSubCategoryListBo> queryMenuSubCategoryList() {
		List<MenuSubCategoryEntity> menuSubCategoryEntityList = menuSubCategoryDao.queryMenuSubCategory();
		List<MenuSubCategoryListBo> menuSubCategoryBoList = new ArrayList<>();
		menuSubCategoryEntityList.forEach((menuSubCategory) -> {
			MenuSubCategoryListBo target = new MenuSubCategoryListBo();
			BeanUtils.copyProperties(menuSubCategory, target);
			menuSubCategoryBoList.add(target);
		});
		return menuSubCategoryBoList;
	}

	/**
	 * 新增餐點次分類
	 */
	@Override
	public void addMenuSubCategory(MenuSubCategoryEntity menuSubCategoryEntity) {
		menuSubCategoryDao.insertMenuSubCategory(menuSubCategoryEntity);
	}

	/**
	 * 刪除特定餐點次分類
	 */
	@Override
	public void deleteSpecMenuSubCategory(String id) {
		menuSubCategoryDao.deleteSpecMenuSubCategory(id);
	}

	/**
	 * 查詢特定餐點種類的餐點次分類
	 */
	@Override
	public List<MenuSubCategorySpecBo> querySpecCategoryMenuSubCategory(String id) {
		List<MenuSubCategoryEntity> menuSubCategoryEntityList = menuSubCategoryDao.querySpecCategoryMenuSubCategory(id);
		List<MenuSubCategorySpecBo> menuSubCategorySpecBoList = new ArrayList<>();
		menuSubCategoryEntityList.forEach((menuSubCategory) -> {
			MenuSubCategorySpecBo target = new MenuSubCategorySpecBo();
			BeanUtils.copyProperties(menuSubCategory, target);
			menuSubCategorySpecBoList.add(target);
		});
		return menuSubCategorySpecBoList;
	}
}

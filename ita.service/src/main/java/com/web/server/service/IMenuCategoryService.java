package com.web.server.service;

import java.util.List;

import com.web.server.bo.MenuCategoryListBo;
import com.web.server.bo.MenuCategoryDetailBo;
import com.web.server.entity.MenuCategoryEntity;

public interface IMenuCategoryService {

	/**
	 * 查詢所有餐點種類(列表)
	 */
	List<MenuCategoryListBo> queryMenuCategoryList();
	
	/**
	 * 查詢所有餐點種類(顯示標題用)
	 */
	List<MenuCategoryDetailBo> queryMenuCategoryIconList();

	/**
	 * 新增餐點種類
	 */
	void addMenuCategory(MenuCategoryEntity menuCategoryEntity);
	
	/**
	 * 查詢特定餐點種類
	 */
	MenuCategoryDetailBo querySpecMenuCategory(String id);
	
	/**
	 * 刪除特定餐點種類
	 */
	void deleteSpecMenuCategory(String id);
}

package com.web.server.service;

import java.util.List;

import com.web.server.bo.MenuListBo;
import com.web.server.entity.MenuEntity;

public interface IMenuService {

	/**
	 * 查詢所有餐點列表
	 */
	List<MenuListBo> queryMenuList();
	
	/**
	 * 新增餐點
	 */
	void addMenu(MenuEntity menuEntity);
	
	/**
	 * 查詢特定餐點
	 */
	MenuListBo querySpecMenu(String id);
	
	/**
	 * 刪除特定餐點
	 */
	void deleteSpecMenu(String id);
	
	/**
	 * 查詢特定種類的餐點
	 */
	List<MenuListBo> queryCategoryMenu(String category);
}

package com.web.server.service;

import java.util.List;

import com.web.server.bo.MenuListBo;
import com.web.server.entity.MenuEntity;
import com.web.server.entity.MenuSpecCateEntity;

public interface IMenuService {

	/**
	 * 查詢所有餐點列表
	 */
	List<MenuListBo> queryMenuList(int today);
	
	/**
	 * 查詢特定種類的餐點
	 */
	List<MenuSpecCateEntity> queryMenuSpecCate(int categoryId);
	
	/**
	 * 新增餐點
	 */
	void addMenu(MenuEntity menuEntity);
	
	/**
	 * 刪除特定餐點
	 */
	void deleteSpecMenu(String id);
	
}

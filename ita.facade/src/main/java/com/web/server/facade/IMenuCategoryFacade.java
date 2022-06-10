package com.web.server.facade;

import java.util.List;

import com.web.server.dto.MenuCategoryListDto;
import com.web.server.dto.MenuCategoryDetailDto;
import com.web.server.vo.MenuCategoryVo;

public interface IMenuCategoryFacade {

	/**
	 * 查詢所有餐點種類(列表)
	 */
	List<MenuCategoryListDto> queryMenuCategoryList();

	/**
	 * 查詢所有餐點種類(顯示標題用)
	 */
	List<MenuCategoryDetailDto> queryMenuCategoryIconList();

	/**
	 * 新增餐點種類
	 */
	void addMenuCategory(MenuCategoryVo menuCategoryVo);
	
	/**
	 * 查詢特定餐點種類
	 */
	MenuCategoryDetailDto querySpecMenuCategory(String id);
	
	/**
	 * 刪除特定餐點種類
	 */
	void deleteSpecMenuCategory(String id);
	
	/**
	 * 更新餐點種類
	 */
	void updateMenuCategory(String id, MenuCategoryVo menuCategoryVo);
}

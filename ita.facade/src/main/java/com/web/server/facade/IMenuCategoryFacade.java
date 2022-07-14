package com.web.server.facade;

import java.util.List;
import java.util.Map;

import com.web.server.dto.MenuCategoryDto;
import com.web.server.dto.MenuCategoryInfoDto;
import com.web.server.vo.MenuCategoryInfoVo;
import com.web.server.vo.SortVo;

public interface IMenuCategoryFacade {

	/**
	 * 查詢所有餐點類別
	 */
	List<MenuCategoryDto> queryMenuCategory();

	/**
	 * 查詢所有餐點子類別
	 */
	Map<Integer, List<String>> querySubCategory();
	
	/**
	 * 查詢分類管理
	 */
	List<MenuCategoryInfoDto> queryCateInfo(int categoryId);
	
	/**
	 * 儲存設定分類修改(包含新增及修改)
	 */
	void updateCateInfo(MenuCategoryInfoVo categoryInfoVo);
	
	/**
	 * 刪除分類
	 */
	void deleteCategory(int categoryId);
	
	/**
	 * 刪除子分類
	 */
	void deleteSubCategory(int subCategoryId);
	
	/**
	 * 更新分類順序
	 */
	void updateCategorySort(List<SortVo> sortList);
}

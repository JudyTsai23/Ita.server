package com.web.server.service;

import java.util.List;

import com.web.server.bo.MenuCategoryBo;
import com.web.server.bo.MenuCategoryInfoBo;
import com.web.server.bo.MenuSubCategoryBo;
import com.web.server.entity.SortEntity;

public interface IMenuCategoryService {

	/**
	 * 查詢所有餐點類別
	 */
	List<MenuCategoryBo> queryMenuCategory();
	
	/**
	 * 查詢所有餐點子類別
	 */
	List<MenuSubCategoryBo> querySubCategory();
	
	/**
	 * 查詢分類管理
	 */
	List<MenuCategoryInfoBo> queryCateInfo(int categoryId);
	
	/**
	 * 儲存設定分類修改(修改)
	 */
	void updateCateInfo(MenuCategoryBo categoryBo, List<MenuSubCategoryBo> subCateBoList);
	
	/**
	 * 查詢最新的子分類ID
	 */
	int queryMaxSubCateId();
	
	/**
	 * 查詢最新的分類ID
	 */
	int queryMaxCategoryId();
	
	/**
	 * 儲存設定分類修改(新增子分類)
	 */
	void insertSubCategoryInfo(List<MenuSubCategoryBo> subCateBoList);
	
	/**
	 * 儲存設定分類修改(新增分類)
	 */
	void insertCategoryInfo(MenuCategoryBo menuCategoryBo);
	
	/**
	 * 刪除分類
	 */
	void deleteCategory(int categoryId);
	
	/**
	 * 刪除對應分類的子分類
	 */
	void deleteSubCateByCate(int categoryId);
	
	/**
	 * 刪除對應分類的餐點
	 */
	void deleteMealsByCategory(int categoryId);
	
	/**
	 * 刪除子分類
	 */
	void deleteSubCategory(int subCategoryId);
	
	/**
	 * 刪除對應子分類的餐點
	 */
	void deleteMealsBySubCate(int subCategoryId);
	
	/**
	 * 更新分類順序
	 */
	void updateCategorySort(List<SortEntity> entityList);
	
	/**
	 * 查詢有幾筆重複的類別slug
	 */
	int queryDuplicateSlugCount(String categoryName);
	
	/**
	 * 查詢有幾筆重複的類別中文名稱
	 */
	int queryDuplicateZhNameCount(String zhName);
}

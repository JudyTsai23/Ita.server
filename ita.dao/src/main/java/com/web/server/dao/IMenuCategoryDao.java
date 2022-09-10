package com.web.server.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.web.server.entity.MenuCategoryEntity;
import com.web.server.entity.MenuCategoryInfoEntity;
import com.web.server.entity.MenuSubCategoryEntity;
import com.web.server.entity.SortEntity;

@Mapper
public interface IMenuCategoryDao {

	/**
	 * 查詢所有餐點種類
	 */
	List<MenuCategoryEntity> queryMenuCategory();
	
	/**
	 * 查詢所有餐點子類別
	 */
	List<MenuSubCategoryEntity> querySubCategory();
	
	/**
	 * 查詢分類管理(特定分類)
	 */
	List<MenuCategoryInfoEntity> queryCateInfo(@Param(value = "categoryId") int categoryId);
	
	/**
	 * 查詢分類管理(所有分類)
	 */
	List<MenuCategoryInfoEntity> queryAllCateInfo();
	
	/**
	 * 儲存設定分類修改(修改分類)
	 */
	void updateCategoryInfo(@Param(value = "category") MenuCategoryEntity menuCategoryEntity);
	
	/**
	 * 儲存設定分類修改(修改子分類)
	 */
	void updateSubCategoryInfo(@Param(value = "subCategoryList") List<MenuSubCategoryEntity> menuSubCategoryEntity);
	
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
	void insertSubCategoryInfo(@Param(value = "subCategoryList") List<MenuSubCategoryEntity> menuSubCategoryEntity);
	
	/**
	 * 儲存設定分類修改(新增分類)
	 */
	void insertCategoryInfo(@Param(value = "category") MenuCategoryEntity menuCategoryEntity);
	
	/**
	 * 刪除分類
	 */
	void deleteCategory(@Param(value = "categoryId") int categoryId);
	
	/**
	 * 刪除對應分類的子分類
	 */
	void deleteSubCateByCate(@Param(value = "categoryId") int categoryId);
	
	/**
	 * 刪除對應分類的餐點
	 */
	void deleteMealsByCategory(@Param(value = "categoryId") int categoryId);
	
	/**
	 * 刪除子分類
	 */
	void deleteSubCategory(@Param(value = "subCategoryId") int subCategoryId);
	
	/**
	 * 刪除對應子分類的餐點
	 */
	void deleteMealsBySubCate(@Param(value = "subCategoryId") int subCategoryId);
	
	/**
	 * 更新分類順序
	 */
	void updateCategorySort(@Param(value = "categoryList") List<SortEntity> categorySort);
	
	/**
	 * 查詢有幾筆重複的類別slug
	 */
	int queryDuplicateSlugCount(@Param(value = "slug") String categoryName);
	
	/**
	 * 查詢有幾筆重複的類別中文名稱
	 */
	int queryDuplicateZhNameCount(@Param(value = "zhName") String categoryZhName);

}

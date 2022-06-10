package com.web.server.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.web.server.entity.MenuSubCategoryEntity;

@Mapper
public interface IMenuSubCategoryDao {

	/**
	 * 查詢所有餐點次分類
	 */
	List<MenuSubCategoryEntity> queryMenuSubCategory();

	/**
	 * 新增餐點次分類
	 */
	void insertMenuSubCategory(@Param(value = "menuSubCategoryEntity") MenuSubCategoryEntity menuSubCategoryEntity);

	/**
	 * 刪除特定餐點次分類
	 */
	void deleteSpecMenuSubCategory(@Param(value = "menuSubCategoryId") String id);

	/**
	 * 查詢特定餐點種類的餐點次分類
	 */
	List<MenuSubCategoryEntity> querySpecCategoryMenuSubCategory(@Param(value = "menuCategoryId") String id);

}

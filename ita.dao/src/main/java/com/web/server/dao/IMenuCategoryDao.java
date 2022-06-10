package com.web.server.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.web.server.entity.MenuCategoryEntity;

@Mapper
public interface IMenuCategoryDao {

	/**
	 * 查詢所有餐點種類
	 */
	List<MenuCategoryEntity> queryMenuCategory();

	/**
	 * 新增餐點種類
	 */
	void insertMenuCategory(@Param(value = "menuCategoryEntity") MenuCategoryEntity menuCategoryEntity);

	/**
	 * 查詢特定餐點種類
	 */
	MenuCategoryEntity querySpecMenuCategory(@Param(value = "menuCategoryId") String id);

	/**
	 * 刪除特定餐點種類
	 */
	void deleteSpecMenuCategory(@Param(value = "menuCategoryId") String id);

}

package com.web.server.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.web.server.entity.MenuEntity;

@Mapper
public interface IMenuDao {

	/**
	 * 查詢所有餐點
	 */
	List<MenuEntity> queryMenu(@Param(value = "today") int today);

	/**
	 * 新增餐點
	 */
	void insertMenu(@Param(value = "menuEntity") MenuEntity menuEntity);

	/**
	 * 查詢特定餐點
	 */
	MenuEntity querySpecMenu(@Param(value = "menuId") String id);

	/**
	 * 刪除特定餐點
	 */
	void deleteSpecMenu(@Param(value = "menuId") String id);

	/**
	 * 查詢特定種類的餐點
	 */
	List<MenuEntity> queryCategoryMenu(@Param(value = "category") String category, @Param(value = "today") int today);
}

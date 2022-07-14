package com.web.server.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.web.server.entity.MenuEntity;
import com.web.server.entity.MenuSpecCateEntity;

@Mapper
public interface IMenuDao {

	/**
	 * 查詢所有餐點
	 */
	List<MenuEntity> queryMenu(@Param(value = "today") int today);
	
	/**
	 * 查詢特定種類的餐點
	 */
	List<MenuSpecCateEntity> queryMenuSpecCate(@Param(value = "categoryId") int categoryId, @Param(value = "today") int today);

	/**
	 * 新增餐點
	 */
	void insertMenu(@Param(value = "menuEntity") MenuEntity menuEntity);

	/**
	 * 刪除特定餐點
	 */
	void deleteSpecMenu(@Param(value = "menuId") String id);

}

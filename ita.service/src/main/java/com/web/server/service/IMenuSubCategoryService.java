package com.web.server.service;

import java.util.List;

import com.web.server.bo.MenuSubCategoryListBo;
import com.web.server.bo.MenuSubCategorySpecBo;
import com.web.server.entity.MenuSubCategoryEntity;

public interface IMenuSubCategoryService {

	/**
	 * 查詢所有餐點次分類
	 */
	List<MenuSubCategoryListBo> queryMenuSubCategoryList();

	/**
	 * 新增餐點次分類
	 */
	void addMenuSubCategory(MenuSubCategoryEntity menuSubCategoryEntity);

	/**
	 * 刪除特定餐點次分類
	 */
	void deleteSpecMenuSubCategory(String id);

	/**
	 * 查詢特定餐點種類的餐點次分類
	 */
	List<MenuSubCategorySpecBo> querySpecCategoryMenuSubCategory(String id);
}

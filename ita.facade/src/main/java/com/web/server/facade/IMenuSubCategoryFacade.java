package com.web.server.facade;

import java.util.List;

import com.web.server.dto.MenuSubCategoryListDto;
import com.web.server.dto.MenuSubCategorySpecDto;
import com.web.server.vo.MenuSubCategoryVo;

public interface IMenuSubCategoryFacade {

	/**
	 * 查詢所有餐點次分類
	 */
	List<MenuSubCategoryListDto> queryMenuSubCategoryList();

	/**
	 * 新增餐點次分類
	 */
	void addMenuSubCategory(MenuSubCategoryVo menuSubCategoryVo);

	/**
	 * 刪除特定餐點次分類
	 */
	void deleteSpecMenuSubCategory(String id);
	
	/**
	 * 更新餐點次分類
	 */
	void updateMenuSubCategory(String id, MenuSubCategoryVo menuSubCategoryVo);
	
	/**
	 * 查詢特定餐點種類的餐點次分類
	 */
	List<MenuSubCategorySpecDto> querySpecCategoryMenuSubCategory(String id);
}

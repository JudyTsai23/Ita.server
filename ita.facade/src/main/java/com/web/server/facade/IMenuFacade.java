package com.web.server.facade;

import java.util.List;

import com.web.server.dto.Menu4CusListDto;
import com.web.server.dto.MenuListDto;
import com.web.server.dto.MenuSingleMealDto;
import com.web.server.vo.MenuSingleMealVo;
import com.web.server.vo.SortStrVo;

public interface IMenuFacade {

	/**
	 * 查詢所有餐點列表
	 */
	List<MenuListDto> queryMeals(int categoryId);
	
	/**
	 * 查詢單一餐點
	 */
	MenuSingleMealDto querySingleMeal(String mealId);
	
	/**
	 * 儲存餐點修改(包含新增及修改)
	 */
	void updateMealInfo(MenuSingleMealVo mealVo);
	
	/**
	 * 刪除單一餐點
	 */
	void deleteSingleMeal(String mealId);
	
	/**
	 * 查詢特定種類的餐點列表
	 */
	List<Menu4CusListDto> queryMenuSpecCate(int category);

	/**
	 * 更新餐點順序
	 */
	void updateMealsSort(List<SortStrVo> sortList);
	
}

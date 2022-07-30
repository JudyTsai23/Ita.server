package com.web.server.service;

import java.util.List;

import com.web.server.bo.MealBo;
import com.web.server.entity.MealEntity;
import com.web.server.entity.MenuSpecCateEntity;
import com.web.server.entity.SortStrEntity;

public interface IMenuService {

	/**
	 * 查詢所有餐點列表
	 */
	List<MealBo> queryMeals(int categoryId);
	
	/**
	 * 查詢單一餐點
	 */
	MealBo querySingleMeal(String mealId);
	
	/**
	 * 儲存餐點修改(修改單一餐點)
	 */
	void updateSingleMeal(MealEntity meal);
	
	/**
	 * 儲存餐點修改(新增一餐點)
	 */
	void insertSingleMeal(MealEntity meal);
	
	/**
	 * 刪除單一餐點
	 */
	void deleteSingleMeal(String mealId);
	
	/**
	 * 更新餐點順序
	 */
	void updateMealsSort(List<SortStrEntity> mealList);
	
	/**
	 * 查詢特定種類的餐點
	 */
	List<MenuSpecCateEntity> queryMenuSpecCate(int categoryId);
	
}

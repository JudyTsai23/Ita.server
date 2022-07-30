package com.web.server.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.web.server.entity.MealEntity;
import com.web.server.entity.MenuSpecCateEntity;
import com.web.server.entity.SortStrEntity;

@Mapper
public interface IMenuDao {

	/**
	 * 查詢所有餐點
	 */
	List<MealEntity> queryMeals(@Param(value = "categoryId") int categoryId);
	
	/**
	 * 查詢單一餐點
	 */
	MealEntity querySingleMeal(@Param(value = "mealId") String mealId);
	
	/**
	 * 儲存餐點修改(修改單一餐點)
	 */
	void updateSingleMeal(@Param(value = "meal") MealEntity meal);
	
	/**
	 * 儲存餐點修改(新增單一餐點)
	 */
	void insertSingleMeal(@Param(value = "meal") MealEntity meal);
	
	/**
	 * 刪除單一餐點
	 */
	void deleteSingleMeal(@Param(value = "mealId") String mealId);
	
	/**
	 * 更新餐點順序
	 */
	void updateMealsSort(@Param(value = "mealList") List<SortStrEntity> mealsSort);
	
	/**
	 * 查詢特定種類的餐點
	 */
	List<MenuSpecCateEntity> queryMenuSpecCate(@Param(value = "categoryId") int categoryId, @Param(value = "today") int today);


}

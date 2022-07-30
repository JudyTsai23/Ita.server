package com.web.server.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.server.bo.MealBo;
import com.web.server.dao.IMenuDao;
import com.web.server.entity.MealEntity;
import com.web.server.entity.MenuSpecCateEntity;
import com.web.server.entity.SortStrEntity;
import com.web.server.service.IMenuService;
import com.web.server.util.DateTimeGenerator;

@Service
public class MenuServiceImpl implements IMenuService {

	@Autowired
	private IMenuDao menuDao;

	/**
	 * 查詢所有餐點列表
	 */
	@Override
	public List<MealBo> queryMeals(int categoryId) {
		List<MealEntity> menuEntityList = menuDao.queryMeals(categoryId);
		List<MealBo> menuBoList = new ArrayList<>();
		menuEntityList.forEach((menu) -> {
			MealBo target = new MealBo();
			BeanUtils.copyProperties(menu, target);
			menuBoList.add(target);
		});
		return menuBoList;
	}
	
	/**
	 * 查詢單一餐點
	 */
	@Override
	public MealBo querySingleMeal(String mealId) {
		MealEntity entity = menuDao.querySingleMeal(mealId);
		if(entity != null) {
			MealBo bo = new MealBo();
			BeanUtils.copyProperties(entity, bo);
			
			return bo;
		}
		return null;
	}
	
	/**
	 * 儲存餐點修改(修改單一餐點)
	 */
	@Override
	public void updateSingleMeal(MealEntity mealEntity) {
		menuDao.updateSingleMeal(mealEntity);
	}
	
	/**
	 * 儲存餐點修改(新增一餐點)
	 */
	@Override
	public void insertSingleMeal(MealEntity mealEntity) {
		menuDao.insertSingleMeal(mealEntity);
	}
	
	/**
	 * 刪除單一餐點
	 */
	@Override
	public void deleteSingleMeal(String mealId) {
		menuDao.deleteSingleMeal(mealId);
	}
	
	/**
	 * 更新餐點順序
	 */
	@Override
	public void updateMealsSort(List<SortStrEntity> mealList) {
		menuDao.updateMealsSort(mealList);
	}
	
	/**
	 * 查詢特定種類的餐點
	 */
	@Override
	public List<MenuSpecCateEntity> queryMenuSpecCate(int category) {
		int today = Integer.parseInt(DateTimeGenerator.getCurrentDate_YYYYMMdd());
		return menuDao.queryMenuSpecCate(category, today);
	}
}

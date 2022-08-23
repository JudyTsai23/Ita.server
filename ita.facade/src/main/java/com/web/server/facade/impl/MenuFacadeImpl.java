package com.web.server.facade.impl;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.web.server.bo.MealBo;
import com.web.server.dto.Menu4CusListDetailDto;
import com.web.server.dto.Menu4CusListDto;
import com.web.server.dto.MenuListDetailDto;
import com.web.server.dto.MenuListDto;
import com.web.server.dto.MenuSingleMealDto;
import com.web.server.entity.MealEntity;
import com.web.server.entity.MenuSpecCateEntity;
import com.web.server.entity.SortStrEntity;
import com.web.server.facade.IMenuFacade;
import com.web.server.service.IMenuService;
import com.web.server.util.DateTimeGenerator;
import com.web.server.util.NumberGenerator;
import com.web.server.vo.MenuSingleMealVo;
import com.web.server.vo.SortStrVo;

@Component
public class MenuFacadeImpl implements IMenuFacade {

	@Autowired
	private IMenuService menuService;

	/**
	 * 查詢所有餐點列表
	 */
	@Override
	public List<MenuListDto> queryMeals(int categoryId) {
		Map<Integer, MenuListDto> mealMap = new HashMap<>();
		
		List<MealBo> mealBoList = menuService.queryMeals(categoryId);
		mealBoList.forEach((bo) -> {
			MenuListDetailDto meal = new MenuListDetailDto();
			meal.setId(bo.getId());
			meal.setName(bo.getName());
			meal.setPrice(bo.getPrice());
			meal.setImage(bo.getImage());
			meal.setLimitDate(bo.getLimitDate());
			meal.setSort(bo.getSort());
			
			int subCategoryId = bo.getSubCategory();
			if(mealMap.containsKey(subCategoryId)) {
				mealMap.get(subCategoryId).getMeals().add(meal);
			}else {
				MenuListDto subCateMeal = new MenuListDto();
				subCateMeal.setSubCateId(bo.getSubCategory());
				String subCateName = bo.getSubCategoryName() != null ? bo.getSubCategoryName() : "";
				subCateMeal.setSubCateName(subCateName);
				
				List<MenuListDetailDto> mealList = new ArrayList<>();
				mealList.add(meal);
				
				subCateMeal.setMeals(mealList);
				mealMap.put(subCategoryId, subCateMeal);
			}
		});
		
		List<MenuListDto> menuDtoList = new ArrayList<>(mealMap.values());
		Comparator<MenuListDto> comparator = Comparator.comparing(MenuListDto::getSubCateId);
		menuDtoList.sort(comparator);
		
		return menuDtoList;
	}
	
	/**
	 * 查詢單一餐點
	 */
	@Override
	public MenuSingleMealDto querySingleMeal(String mealId) {
		MealBo mealBo = menuService.querySingleMeal(mealId);
		if(mealBo != null) {
			MenuSingleMealDto mealDto = new MenuSingleMealDto();
			BeanUtils.copyProperties(mealBo, mealDto);
			mealDto.setPublic("1".equals(mealBo.getIsPublic()) ? true : false);
			
			return mealDto;
		}
		return null;
	}
	
	/**
	 * 儲存餐點修改(包含新增及修改)
	 */
	@Override
	public void updateMealInfo(MenuSingleMealVo mealVo) {
		MealEntity entity = new MealEntity();
		BeanUtils.copyProperties(mealVo, entity);
		
		if(entity.getIsPublic().length() > 1) {
			entity.setIsPublic("true".equals(entity.getIsPublic()) ? "1" : "0");
		}
		
		if("".equals(entity.getId()) || entity.getId() == null) {
			// 若沒有id則為新增
			entity.setId(NumberGenerator.getSerialNum());
			entity.setAddedTime(DateTimeGenerator.getCurrentDate_YYYY_MM_dd_HH_mm_ss());
			entity.setUpdTime(DateTimeGenerator.getCurrentDate_YYYY_MM_dd_HH_mm_ss());
			menuService.insertSingleMeal(entity);
		}else {
			// 若有id則為修改
			entity.setUpdTime(DateTimeGenerator.getCurrentDate_YYYY_MM_dd_HH_mm_ss());
			menuService.updateSingleMeal(entity);
		}
	}
	
	/**
	 * 刪除單一餐點
	 */
	@Override
	public void deleteSingleMeal(String mealId) {
		menuService.deleteSingleMeal(mealId);
	}

	/**
	 * 查詢特定種類的餐點
	 */
	@Override
	public List<Menu4CusListDto> queryMenuSpecCate(int categoryId) {
		List<MenuSpecCateEntity> entityList = menuService.queryMenuSpecCate(categoryId);
		Map<String, Menu4CusListDto> menuMap = new HashMap<>();
		entityList.forEach((entity) -> {
			String subCateName = entity.getSubCateName();
			Menu4CusListDetailDto meal = new Menu4CusListDetailDto();
			meal.setName(entity.getMealName());
			BeanUtils.copyProperties(entity, meal);
			
			if(menuMap.containsKey(subCateName)) {
				menuMap.get(subCateName).getMeals().add(meal);
			}else {
				Menu4CusListDto dto = new Menu4CusListDto();
				List<Menu4CusListDetailDto> meals = new ArrayList<>();
				meals.add(meal);
				dto.setMeals(meals);
				
				if(subCateName == null) {
					menuMap.put(null, dto);
				}else {
					menuMap.put(subCateName, dto);
				}
			}
		});
		
		List<Menu4CusListDto> menuList = new ArrayList<>();
		Set<String> set = menuMap.keySet();
		Iterator<String> it = set.iterator();
		while(it.hasNext()) {
			String subCateName = it.next();
			List<Menu4CusListDetailDto> list = menuMap.get(subCateName).getMeals();
			Comparator<Menu4CusListDetailDto> comparator = Comparator.comparing(Menu4CusListDetailDto::getSort);
			list.sort(comparator);
			
			Menu4CusListDto dto = new Menu4CusListDto();
			dto.setSubCateName(subCateName);
			dto.setMeals(list);
			menuList.add(dto);
		}
		
		return menuList;
	}

	/**
	 * 更新餐點順序
	 */
	@Override
	public void updateMealsSort(List<SortStrVo> voList) {
		List<SortStrEntity> entityList = new ArrayList<>();
		for(SortStrVo meal : voList) {
			SortStrEntity target = new SortStrEntity();
			BeanUtils.copyProperties(meal, target);
			target.setUpdTime(DateTimeGenerator.getCurrentDate_YYYY_MM_dd_HH_mm_ss());
			entityList.add(target);
		}
		menuService.updateMealsSort(entityList);
	}
}

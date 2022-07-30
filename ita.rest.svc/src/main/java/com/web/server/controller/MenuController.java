package com.web.server.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.web.server.cnst.AppCode;
import com.web.server.dto.MenuListDto;
import com.web.server.dto.MenuSingleMealDto;
import com.web.server.facade.IMenuFacade;
import com.web.server.rest.IRestBase;
import com.web.server.rest.RestResult;
import com.web.server.vo.MenuSingleMealVo;
import com.web.server.vo.SortStrVo;

/**
 * 菜單餐點相關
 */
@RestController
@RequestMapping("/menu")
public class MenuController implements IRestBase {

	@Autowired
	private IMenuFacade menuFacade;
	
	/**
	 * 查詢所有餐點 (後台-餐點管理)
	 */
	@GetMapping("/meals/{categoryId}")
	public RestResult queryMeals(@PathVariable int categoryId) {
		List<MenuListDto> resultList = menuFacade.queryMeals(categoryId);
		return buildResult(AppCode.SERVER.SUCCESS.QUERY_SUCCESS.getCode(), resultList);
	}
	
	/**
	 * 查詢單一餐點 (後台-餐點修改)
	 */
	@GetMapping("/meal/{mealId}")
	public RestResult querySingleMeal(@PathVariable String mealId) {
		MenuSingleMealDto singleMeal = menuFacade.querySingleMeal(mealId);
		if(singleMeal == null) {
			return buildResult(AppCode.SERVER.SUCCESS.QUERY_SUCCESS.getCode(), null);
		}
		return buildResult(AppCode.SERVER.SUCCESS.QUERY_SUCCESS.getCode(), singleMeal);
	}
	
	/**
	 * 儲存餐點修改(包含新增及修改)
	 */
	@PostMapping("/save")
	public RestResult updateMealInfo(@RequestBody MenuSingleMealVo mealVo) {
		menuFacade.updateMealInfo(mealVo);
		return buildResult(AppCode.SERVER.SUCCESS.UPDATE_SUCCESS.getCode(), null);
	}
	
	/**
	 * 刪除單一餐點
	 */
	@DeleteMapping("/{mealId}")
	public RestResult deleteSingleMeal(@PathVariable String mealId) {
		menuFacade.deleteSingleMeal(mealId);
		return buildResult(AppCode.SERVER.SUCCESS.DELETE_SUCCESS.getCode(), null);
	}
	
	/**
	 * 更新餐點順序
	 */
	@PutMapping
	public RestResult updateMealsSort(@RequestBody List<SortStrVo> sortList) {
		menuFacade.updateMealsSort(sortList);
		return buildResult(AppCode.SERVER.SUCCESS.UPDATE_SUCCESS.getCode(), null);
	}
	
	/**
	 * 查詢特定種類的餐點 for 前台
	 */
	@GetMapping("/{categoryId}")
	public RestResult queryMenu(@PathVariable int categoryId) {
		List<MenuListDto> menuSpecCateMap = menuFacade.queryMenuSpecCate(categoryId);
		return buildResult(AppCode.SERVER.SUCCESS.QUERY_SUCCESS.getCode(), menuSpecCateMap);
	}
	
}

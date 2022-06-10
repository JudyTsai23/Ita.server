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
import com.web.server.dto.MenuCategoryListDto;
import com.web.server.dto.MenuCategoryDetailDto;
import com.web.server.facade.IMenuCategoryFacade;
import com.web.server.rest.IRestBase;
import com.web.server.rest.RestResult;
import com.web.server.vo.MenuCategoryVo;

/**
 * 餐點種類
 */
@RestController
@RequestMapping("/menu_category")
public class MenuCategoryController implements IRestBase {

	@Autowired
	private IMenuCategoryFacade menuCategoryFacade;
	
	/**
	 * 查詢所有餐點種類(列表)
	 */
	@GetMapping
	public RestResult queryMenuCategoryList() {
		List<MenuCategoryListDto> resultList = menuCategoryFacade.queryMenuCategoryList();
		return buildResult(AppCode.SERVER.SUCCESS.QUERY_SUCCESS.getCode(), resultList);
	}
	
	/**
	 * 查詢所有餐點種類(顯示標題用)
	 */
	@GetMapping("/icon")
	public RestResult queryMenuCategoryIconList() {
		List<MenuCategoryDetailDto> resultList = menuCategoryFacade.queryMenuCategoryIconList();
		return buildResult(AppCode.SERVER.SUCCESS.QUERY_SUCCESS.getCode(), resultList);
	}
	
	/**
	 * 新增餐點種類
	 */
	@PostMapping
	public RestResult addMenuCategory(@RequestBody MenuCategoryVo menuCategoryVo) {
		menuCategoryFacade.addMenuCategory(menuCategoryVo);
		return buildResult(AppCode.SERVER.SUCCESS.INSERT_SUCCESS.getCode(), null);
	}
	
	/**
	 * 查詢特定餐點種類
	 */
	@GetMapping("/{id}")
	public RestResult querySpecMenuCategory(@PathVariable String id) {
		MenuCategoryDetailDto menuCategoryDetailDto = menuCategoryFacade.querySpecMenuCategory(id);
		return buildResult(AppCode.SERVER.SUCCESS.QUERY_SUCCESS.getCode(), menuCategoryDetailDto);
	}
	
	/**
	 * 刪除特定餐點種類
	 */
	@DeleteMapping("/{id}")
	public RestResult deleteSpecMenuCategory(@PathVariable String id) {
		menuCategoryFacade.deleteSpecMenuCategory(id);
		return buildResult(AppCode.SERVER.SUCCESS.DELETE_SUCCESS.getCode(), null);
	}
	
	/**
	 * 更新餐點種類
	 */
	@PutMapping("/{id}")
	public RestResult updateMenuCategory(@PathVariable String id, @RequestBody MenuCategoryVo menuCategoryVo) {
		menuCategoryFacade.updateMenuCategory(id, menuCategoryVo);
		return buildResult(AppCode.SERVER.SUCCESS.UPDATE_SUCCESS.getCode(), null);
	}
}

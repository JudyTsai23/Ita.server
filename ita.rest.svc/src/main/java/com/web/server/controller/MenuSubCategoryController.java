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
import com.web.server.dto.MenuSubCategoryListDto;
import com.web.server.dto.MenuSubCategorySpecDto;
import com.web.server.facade.IMenuSubCategoryFacade;
import com.web.server.rest.IRestBase;
import com.web.server.rest.RestResult;
import com.web.server.vo.MenuSubCategoryVo;

/**
 * 餐點次分類
 */
@RestController
@RequestMapping("/menu_subcategory")
public class MenuSubCategoryController implements IRestBase {

	@Autowired
	private IMenuSubCategoryFacade menuSubCategoryFacade;
	
	/**
	 * 查詢所有餐點次分類
	 */
	@GetMapping
	public RestResult queryMenuSubCategoryList() {
		List<MenuSubCategoryListDto> resultList = menuSubCategoryFacade.queryMenuSubCategoryList();
		return buildResult(AppCode.SERVER.SUCCESS.QUERY_SUCCESS.getCode(), resultList);
	}
	
	/**
	 * 新增餐點次分類
	 */
	@PostMapping
	public RestResult addMenuSubCategory(@RequestBody MenuSubCategoryVo menuSubCategoryVo) {
		menuSubCategoryFacade.addMenuSubCategory(menuSubCategoryVo);
		return buildResult(AppCode.SERVER.SUCCESS.INSERT_SUCCESS.getCode(), null);
	}
	
	/**
	 * 刪除特定餐點次分類
	 */
	@DeleteMapping("/{id}")
	public RestResult deleteSpecMenuSubCategory(@PathVariable String id) {
		menuSubCategoryFacade.deleteSpecMenuSubCategory(id);
		return buildResult(AppCode.SERVER.SUCCESS.DELETE_SUCCESS.getCode(), null);
	}
	
	/**
	 * 更新餐點次分類
	 */
	@PutMapping("/{id}")
	public RestResult updateMenuSubCategory(@PathVariable String id, @RequestBody MenuSubCategoryVo menuSubCategoryVo) {
		menuSubCategoryFacade.updateMenuSubCategory(id, menuSubCategoryVo);
		return buildResult(AppCode.SERVER.SUCCESS.UPDATE_SUCCESS.getCode(), null);
	}
	
	/**
	 * 查詢特定餐點種類的餐點次分類
	 */
	@GetMapping("/category/{id}")
	public RestResult querySpecCategoryMenuSubCategory(@PathVariable String id) {
		List<MenuSubCategorySpecDto> resultList = menuSubCategoryFacade.querySpecCategoryMenuSubCategory(id);
		return buildResult(AppCode.SERVER.SUCCESS.QUERY_SUCCESS.getCode(), resultList);
	}
}

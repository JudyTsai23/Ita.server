package com.web.server.controller;

import java.util.List;
import java.util.Map;

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
import com.web.server.dto.MenuCategoryDto;
import com.web.server.dto.MenuCategoryInfoDto;
import com.web.server.facade.IMenuCategoryFacade;
import com.web.server.rest.IRestBase;
import com.web.server.rest.RestResult;
import com.web.server.vo.MenuCategoryInfoVo;
import com.web.server.vo.SortVo;

/**
 * 餐點分類相關
 */
@RestController
@RequestMapping("/mealCate")
public class MenuCategoryController implements IRestBase {

	@Autowired
	private IMenuCategoryFacade menuCategoryFacade;
	
	/**
	 * 查詢所有餐點類別
	 */
	@GetMapping("/cate")
	public RestResult queryMenuCategory() {
		List<MenuCategoryDto> cateList = menuCategoryFacade.queryMenuCategory();
		return buildResult(AppCode.SERVER.SUCCESS.QUERY_SUCCESS.getCode(), cateList);
	}
	
	/**
	 * 查詢所有餐點子類別
	 */
	@GetMapping("/sub")
	public RestResult queryMenuSubCategory() {
		Map<Integer, List<String>> subCateMap = menuCategoryFacade.querySubCategory();
		return buildResult(AppCode.SERVER.SUCCESS.QUERY_SUCCESS.getCode(), subCateMap);
	}
	
	/**
	 * 查詢分類管理(特定分類)
	 */
	@GetMapping("/{categoryId}")
	public RestResult queryCateInfo(@PathVariable int categoryId) {
		List<MenuCategoryInfoDto> cateInfoList = menuCategoryFacade.queryCateInfo(categoryId);
		return buildResult(AppCode.SERVER.SUCCESS.QUERY_SUCCESS.getCode(), cateInfoList);
	}
	
	/**
	 * 查詢分類管理(所有)
	 */
	@GetMapping
	public RestResult queryCateInfo() {
		int categoryId = -1;
		List<MenuCategoryInfoDto> cateInfoList = menuCategoryFacade.queryCateInfo(categoryId);
		return buildResult(AppCode.SERVER.SUCCESS.QUERY_SUCCESS.getCode(), cateInfoList);
	}
	
	/**
	 * 儲存設定分類修改(包含新增及修改)
	 */
	@PostMapping("/save")
	public RestResult updateCateInfo(@RequestBody MenuCategoryInfoVo categoryInfoVo) {
		menuCategoryFacade.updateCateInfo(categoryInfoVo);
		return buildResult(AppCode.SERVER.SUCCESS.UPDATE_SUCCESS.getCode(), null);
	}
	
	/**
	 * 刪除分類
	 */
	@DeleteMapping("/{categoryId}")
	public RestResult deleteCategory(@PathVariable int categoryId) {
		menuCategoryFacade.deleteCategory(categoryId);
		return buildResult(AppCode.SERVER.SUCCESS.DELETE_SUCCESS.getCode(), null);
	}
	
	
	/**
	 * 刪除子分類
	 */
	@DeleteMapping("/sub/{subCategoryId}")
	public RestResult deleteSubCategory(@PathVariable int subCategoryId) {
		menuCategoryFacade.deleteSubCategory(subCategoryId);
		return buildResult(AppCode.SERVER.SUCCESS.DELETE_SUCCESS.getCode(), null);
	}
	
	/**
	 * 更新分類順序
	 */
	@PutMapping
	public RestResult updateCategorySort(@RequestBody List<SortVo> sortList) {
		menuCategoryFacade.updateCategorySort(sortList);
		return buildResult(AppCode.SERVER.SUCCESS.UPDATE_SUCCESS.getCode(), null);
	}
}

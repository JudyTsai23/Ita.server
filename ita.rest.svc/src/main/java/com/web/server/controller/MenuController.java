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
import com.web.server.facade.IMenuFacade;
import com.web.server.rest.IRestBase;
import com.web.server.rest.RestResult;
import com.web.server.vo.MenuVo;

/**
 * 訊息專區
 */
@RestController
@RequestMapping("/menu")
public class MenuController implements IRestBase {

	@Autowired
	private IMenuFacade menuFacade;
	
	/**
	 * 查詢所有餐點列表
	 */
	@GetMapping
	public RestResult queryMenuList() {
		List<MenuListDto> resultList = menuFacade.queryMenuList();
		return buildResult(AppCode.SERVER.SUCCESS.QUERY_SUCCESS.getCode(), resultList);
	}
	
	/**
	 * 新增餐點
	 */
	@PostMapping
	public RestResult addMenu(@RequestBody MenuVo menuVo) {
		menuFacade.addMenu(menuVo);
		return buildResult(AppCode.SERVER.SUCCESS.INSERT_SUCCESS.getCode(), null);
	}
	
	/**
	 * 查詢特定一筆餐點
	 */
//	@GetMapping("/{id}")
//	public RestResult querySpecMenu(@PathVariable String id) {
//		MenuListDto menuListDto = menuFacade.querySpecMenu(id);
//		return buildResult(AppCode.SERVER.SUCCESS.QUERY_SUCCESS.getCode(), menuListDto);
//	}
	
	/**
	 * 刪除特定餐點
	 */
	@DeleteMapping("/{id}")
	public RestResult deleteSpecMenu(@PathVariable String id) {
		menuFacade.deleteSpecMenu(id);
		return buildResult(AppCode.SERVER.SUCCESS.DELETE_SUCCESS.getCode(), null);
	}
	
	/**
	 * 更新餐點
	 */
	@PutMapping("/{id}")
	public RestResult updateMenu(@PathVariable String id, @RequestBody MenuVo menuVo) {
		menuFacade.updateMenu(id, menuVo);
		return buildResult(AppCode.SERVER.SUCCESS.UPDATE_SUCCESS.getCode(), null);
	}
	
	/**
	 * 查詢特定種類的餐點
	 */
	@GetMapping("/{category}")
	public RestResult queryCategoryMenu(@PathVariable String category) {
		List<MenuListDto> resultList = menuFacade.queryCategoryMenu(category);
		return buildResult(AppCode.SERVER.SUCCESS.QUERY_SUCCESS.getCode(), resultList);
	}
}

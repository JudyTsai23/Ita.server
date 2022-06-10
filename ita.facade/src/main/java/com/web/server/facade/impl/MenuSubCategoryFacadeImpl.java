package com.web.server.facade.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.web.server.bo.MenuSubCategoryListBo;
import com.web.server.bo.MenuSubCategorySpecBo;
import com.web.server.dto.MenuSubCategoryListDto;
import com.web.server.dto.MenuSubCategorySpecDto;
import com.web.server.entity.MenuSubCategoryEntity;
import com.web.server.facade.IMenuSubCategoryFacade;
import com.web.server.service.IMenuSubCategoryService;
import com.web.server.util.NumberGenerator;
import com.web.server.vo.MenuSubCategoryVo;

@Component
public class MenuSubCategoryFacadeImpl implements IMenuSubCategoryFacade {

	@Autowired
	private IMenuSubCategoryService menuSubCategoryService;
	
	/**
	 * 查詢所有餐點次分類
	 */
	@Override
	public List<MenuSubCategoryListDto> queryMenuSubCategoryList() {
		List<MenuSubCategoryListBo> menuSubCategoryBoList = menuSubCategoryService.queryMenuSubCategoryList();
		List<MenuSubCategoryListDto> menuSubCategoryDtoList = new ArrayList<>();
		menuSubCategoryBoList.forEach((menuSubCategory) -> {
			MenuSubCategoryListDto target = new MenuSubCategoryListDto();
			BeanUtils.copyProperties(menuSubCategory, target);
			menuSubCategoryDtoList.add(target);
		});
		return menuSubCategoryDtoList;
	}
	
	/**
	 * 新增餐點次分類
	 */
	@Override
	public void addMenuSubCategory(MenuSubCategoryVo menuSubCategoryVo) {
		String serialNum = NumberGenerator.getSerialNum();
		
		MenuSubCategoryEntity menuSubCategoryEntity = new MenuSubCategoryEntity();
		BeanUtils.copyProperties(menuSubCategoryVo, menuSubCategoryEntity);
		menuSubCategoryEntity.setId(serialNum);
		
		menuSubCategoryService.addMenuSubCategory(menuSubCategoryEntity);
	}
	
	/**
	 * 刪除特定餐點次分類
	 */
	@Override
	public void deleteSpecMenuSubCategory(String id) {
		menuSubCategoryService.deleteSpecMenuSubCategory(id);
	}
	
	/**
	 * 更新餐點次分類
	 */
	@Override
	public void updateMenuSubCategory(String id, MenuSubCategoryVo menuSubCategoryVo) {
		menuSubCategoryService.deleteSpecMenuSubCategory(id);
		
		MenuSubCategoryEntity menuSubCategoryEntity = new MenuSubCategoryEntity();
		BeanUtils.copyProperties(menuSubCategoryVo, menuSubCategoryEntity);
		menuSubCategoryEntity.setId(id);
		
		menuSubCategoryService.addMenuSubCategory(menuSubCategoryEntity);
	}
	
	/**
	 * 查詢特定餐點種類的餐點次分類
	 */
	@Override 
	public List<MenuSubCategorySpecDto> querySpecCategoryMenuSubCategory(String id) {
		List<MenuSubCategorySpecBo> menuSubCategorySpecBoList = menuSubCategoryService.querySpecCategoryMenuSubCategory(id);
		List<MenuSubCategorySpecDto> menuSubCategorySpecDtoList = new ArrayList<>();
		menuSubCategorySpecBoList.forEach((menuSubCategory) -> {
			MenuSubCategorySpecDto target = new MenuSubCategorySpecDto();
			BeanUtils.copyProperties(menuSubCategory, target);
			menuSubCategorySpecDtoList.add(target);
		});
		return menuSubCategorySpecDtoList;
	}
}

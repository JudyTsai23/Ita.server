package com.web.server.facade.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.web.server.bo.MenuCategoryListBo;
import com.web.server.bo.MenuCategoryDetailBo;
import com.web.server.dto.MenuCategoryListDto;
import com.web.server.dto.MenuCategoryDetailDto;
import com.web.server.entity.MenuCategoryEntity;
import com.web.server.facade.IMenuCategoryFacade;
import com.web.server.service.IMenuCategoryService;
import com.web.server.util.NumberGenerator;
import com.web.server.vo.MenuCategoryVo;

@Component
public class MenuCategoryFacadeImpl implements IMenuCategoryFacade {

	@Autowired
	private IMenuCategoryService menuCategoryService;
	
	/**
	 * 查詢所有餐點種類(列表)
	 */
	@Override
	public List<MenuCategoryListDto> queryMenuCategoryList() {
		List<MenuCategoryListBo> menuCategoryBoList = menuCategoryService.queryMenuCategoryList();
		List<MenuCategoryListDto> menuCategoryDtoList = new ArrayList<>();
		menuCategoryBoList.forEach((menuCategory) -> {
			MenuCategoryListDto target = new MenuCategoryListDto();
			BeanUtils.copyProperties(menuCategory, target);
			menuCategoryDtoList.add(target);
		});
		return menuCategoryDtoList;
	}
	
	/**
	 * 查詢所有餐點種類(顯示標題用)
	 */
	@Override
	public List<MenuCategoryDetailDto> queryMenuCategoryIconList() {
		List<MenuCategoryDetailBo> menuCategoryBoList = menuCategoryService.queryMenuCategoryIconList();
		List<MenuCategoryDetailDto> menuCategoryDtoList = new ArrayList<>();
		menuCategoryBoList.forEach((menuCategory) -> {
			MenuCategoryDetailDto target = new MenuCategoryDetailDto();
			BeanUtils.copyProperties(menuCategory, target);
			menuCategoryDtoList.add(target);
		});
		return menuCategoryDtoList;
	}
	
	/**
	 * 新增餐點種類
	 */
	@Override
	public void addMenuCategory(MenuCategoryVo menuCategoryVo) {
		String serialNum = NumberGenerator.getSerialNum();
		
		MenuCategoryEntity menuCategoryEntity = new MenuCategoryEntity();
		BeanUtils.copyProperties(menuCategoryVo, menuCategoryEntity);
		menuCategoryEntity.setId(serialNum);
		
		menuCategoryService.addMenuCategory(menuCategoryEntity);
	}
	
	/**
	 * 查詢特定餐點種類
	 */
	@Override 
	public MenuCategoryDetailDto querySpecMenuCategory(String id) {
		MenuCategoryDetailBo menuCategoryDetailBo = menuCategoryService.querySpecMenuCategory(id);
		MenuCategoryDetailDto menuCategoryDetailDto = new MenuCategoryDetailDto();
		BeanUtils.copyProperties(menuCategoryDetailBo, menuCategoryDetailDto);
		return menuCategoryDetailDto;
	}
	
	/**
	 * 刪除特定餐點種類
	 */
	@Override
	public void deleteSpecMenuCategory(String id) {
		menuCategoryService.deleteSpecMenuCategory(id);
	}
	
	/**
	 * 更新餐點種類
	 */
	@Override
	public void updateMenuCategory(String id, MenuCategoryVo menuCategoryVo) {
		menuCategoryService.deleteSpecMenuCategory(id);
		
		MenuCategoryEntity menuCategoryEntity = new MenuCategoryEntity();
		BeanUtils.copyProperties(menuCategoryVo, menuCategoryEntity);
		menuCategoryEntity.setId(id);
		
		menuCategoryService.addMenuCategory(menuCategoryEntity);
	}
}

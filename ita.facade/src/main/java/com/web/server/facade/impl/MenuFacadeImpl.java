package com.web.server.facade.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.web.server.bo.MenuListBo;
import com.web.server.dto.MenuListDto;
import com.web.server.entity.MenuEntity;
import com.web.server.facade.IMenuFacade;
import com.web.server.service.IMenuService;
import com.web.server.util.NumberGenerator;
import com.web.server.vo.MenuVo;

@Component
public class MenuFacadeImpl implements IMenuFacade {

	@Autowired
	private IMenuService menuService;
	
	/**
	 * 查詢所有餐點列表
	 */
	@Override
	public List<MenuListDto> queryMenuList() {
		List<MenuListBo> menuBoList = menuService.queryMenuList();
		List<MenuListDto> menuDtoList = new ArrayList<>();
		menuBoList.forEach((menu) -> {
			MenuListDto target = new MenuListDto();
			target.setCategory(menu.getCategory().getCategoryName());
			target.setSubCategory(menu.getSubCategory().getCategoryName());
			BeanUtils.copyProperties(menu, target);
			menuDtoList.add(target);
		});
		return menuDtoList;
	}
	
	/**
	 * 新增餐點
	 */
	@Override
	public void addMenu(MenuVo menuVo) {
		String serialNum = NumberGenerator.getSerialNum();
		
		MenuEntity menuEntity = new MenuEntity();
		BeanUtils.copyProperties(menuVo, menuEntity);
		menuEntity.setId(serialNum);
		menuEntity.setUpdTime(LocalDateTime.now());
		
		menuService.addMenu(menuEntity);
	}
	
	/**
	 * 查詢特定餐點
	 */
	@Override 
	public MenuListDto querySpecMenu(String id) {
		MenuListBo menuListBo = menuService.querySpecMenu(id);
		MenuListDto menuListDto = new MenuListDto();
		menuListDto.setCategory(menuListBo.getCategory().getCategoryName());
		menuListDto.setSubCategory(menuListBo.getSubCategory().getCategoryName());
		BeanUtils.copyProperties(menuListBo, menuListDto);
		return menuListDto;
	}
	
	/**
	 * 刪除特定餐點
	 */
	@Override
	public void deleteSpecMenu(String id) {
		menuService.deleteSpecMenu(id);
	}
	
	/**
	 * 更新餐點
	 */
	@Override
	public void updateMenu(String id, MenuVo menuVo) {
		menuService.deleteSpecMenu(id);
		
		MenuEntity menuEntity = new MenuEntity();
		BeanUtils.copyProperties(menuVo, menuEntity);
		menuEntity.setId(id);
		menuEntity.setUpdTime(LocalDateTime.now());
		
		menuService.addMenu(menuEntity);
	}

	/**
	 * 查詢特定種類的餐點
	 */
	@Override
	public List<MenuListDto> queryCategoryMenu(String category) {
		List<MenuListBo> menuBoList = menuService.queryCategoryMenu(category);
		List<MenuListDto> menuDtoList = new ArrayList<>();
		menuBoList.forEach((menu) -> {
			MenuListDto target = new MenuListDto();
			target.setCategory(menu.getCategory().getCategoryName());
			target.setSubCategory(menu.getSubCategory().getCategoryName());
			BeanUtils.copyProperties(menu, target);
			menuDtoList.add(target);
		});
		return menuDtoList;
	}
}

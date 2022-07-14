package com.web.server.facade.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.web.server.bo.MenuListBo;
import com.web.server.dto.MenuListDetailDto;
import com.web.server.dto.MenuListDto;
import com.web.server.entity.MenuEntity;
import com.web.server.entity.MenuSpecCateEntity;
import com.web.server.facade.IMenuFacade;
import com.web.server.service.IMenuService;
import com.web.server.util.DateTimeGenerator;
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
		int today = Integer.parseInt(DateTimeGenerator.getCurrentDate_YYYYMMdd());

		List<MenuListBo> menuBoList = menuService.queryMenuList(today);
		List<MenuListDto> menuDtoList = new ArrayList<>();
//		menuBoList.forEach((menu) -> {
//			MenuListDto target = new MenuListDto();
//			target.setCategory(menu.getCategory().getCategoryName());
//			target.setSubCategory(menu.getSubCategory().getCategoryName());
//			BeanUtils.copyProperties(menu, target);
//			menuDtoList.add(target);
//		});
		return menuDtoList;
	}

	/**
	 * 查詢特定種類的餐點
	 */
	@Override
	public List<MenuListDto> queryMenuSpecCate(int categoryId) {
		List<MenuListDto> menuList = new ArrayList<>();

		List<MenuSpecCateEntity> entityList = menuService.queryMenuSpecCate(categoryId);
		entityList.forEach((entity) -> {
			String subCateName = entity.getSubCateName();
			MenuListDetailDto meal = new MenuListDetailDto();
			meal.setName(entity.getMealName());
			BeanUtils.copyProperties(entity, meal);

			boolean hasList = false;
			for (MenuListDto dto : menuList) {
				if (subCateName.equals(dto.getSubCateName())) {
					dto.getMealList().add(meal);
					hasList = true;
				}
			}
			if (!hasList) {
				List<MenuListDetailDto> detail = new ArrayList<>();
				detail.add(meal);
				MenuListDto menu = new MenuListDto(subCateName, detail);
				menuList.add(menu);
			}
		});
		return menuList;
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
		menuEntity.setAddedTime(LocalDateTime.now());
		menuEntity.setUpdTime(LocalDateTime.now());

		menuService.addMenu(menuEntity);
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
		menuEntity.setAddedTime(LocalDateTime.now());
		menuEntity.setUpdTime(LocalDateTime.now());

		menuService.addMenu(menuEntity);
	}
}

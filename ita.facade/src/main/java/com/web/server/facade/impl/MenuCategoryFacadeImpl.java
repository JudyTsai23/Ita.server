package com.web.server.facade.impl;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.web.server.bo.MenuCategoryBo;
import com.web.server.bo.MenuCategoryInfoBo;
import com.web.server.bo.MenuSubCategoryBo;
import com.web.server.dto.MenuCategoryDto;
import com.web.server.dto.MenuCategoryInfoDto;
import com.web.server.dto.MenuSubCategoryInfoDto;
import com.web.server.entity.SortEntity;
import com.web.server.facade.IMenuCategoryFacade;
import com.web.server.service.IMenuCategoryService;
import com.web.server.vo.MenuCategoryInfoVo;
import com.web.server.vo.MenuSubCategoryInfoVo;
import com.web.server.vo.SortVo;

@Component
public class MenuCategoryFacadeImpl implements IMenuCategoryFacade {

	@Autowired
	private IMenuCategoryService menuCategoryService;

	/**
	 * 查詢所有餐點類別
	 */
	@Override
	public List<MenuCategoryDto> queryMenuCategory() {
		List<MenuCategoryBo> menuCategoryBoList = menuCategoryService.queryMenuCategory();
		List<MenuCategoryDto> menuCategoryDtoList = new ArrayList<>();
		menuCategoryBoList.forEach((menuCategory) -> {
			MenuCategoryDto target = new MenuCategoryDto();
			BeanUtils.copyProperties(menuCategory, target);
			menuCategoryDtoList.add(target);
		});
		return menuCategoryDtoList;
	}

	/**
	 * 查詢所有餐點子類別
	 */
	@Override
	public Map<Integer, List<String>> querySubCategory() {
		return menuCategoryService.querySubCategory();
	}
	
	/**
	 * 查詢分類管理
	 */
	@Override
	public List<MenuCategoryInfoDto> queryCateInfo(int categoryId) {
		Map<Integer, MenuCategoryInfoDto> dtoMap = new HashMap<>();
		
		List<MenuCategoryInfoBo> cateInfoBoList = menuCategoryService.queryCateInfo(categoryId);
		cateInfoBoList.forEach((bo) -> {
			int id = bo.getCategoryId();
			
			MenuSubCategoryInfoDto subCate = new MenuSubCategoryInfoDto();
			subCate.setId(bo.getSubCateId());
			subCate.setName(bo.getSubCateName());
			subCate.setSort(bo.getSubCateSort());
			
			if(dtoMap.containsKey(id)) {
				if(subCate.getId() > 0) {
					dtoMap.get(id).getSubCateList().add(subCate);
				}
			}else {
				MenuCategoryInfoDto category = new MenuCategoryInfoDto();
				category.setId(id);
				category.setName(bo.getCategoryName());
				category.setZhName(bo.getCateZhName());
				category.setIcon(bo.getCategoryIcon());
				category.setSort(bo.getCategorySort());
				
				List<MenuSubCategoryInfoDto> subCateList = new ArrayList<>();
				if(subCate.getId() > 0) {
					subCateList.add(subCate);
				}
				category.setSubCateList(subCateList);
				dtoMap.put(id, category);
			}
		});
		
		List<MenuCategoryInfoDto> categoryDtoList = new ArrayList<>(dtoMap.values());
		Comparator<MenuCategoryInfoDto> comparator = Comparator.comparing(MenuCategoryInfoDto::getSort);
		categoryDtoList.sort(comparator);
		
		return categoryDtoList;
	}
	
	/**
	 * 儲存設定分類修改(包含新增及修改)
	 */
	@Override
	public void updateCateInfo(MenuCategoryInfoVo categoryInfoVo) {
		// 取得分類ID
		int categoryId = categoryInfoVo.getId();
		// 查詢最新的子分類ID
		int lastestSubCateId = menuCategoryService.queryMaxSubCateId() + 1;
		
		// 組出分類
		MenuCategoryBo updCateBo = new MenuCategoryBo();
		updCateBo.setName(categoryInfoVo.getName());
		updCateBo.setZhName(categoryInfoVo.getZhName());
		updCateBo.setIcon(categoryInfoVo.getIcon());
		
		if(categoryId > 0) {
			// 若分類ID不為0，則為修改
			// 設定分類ID
			updCateBo.setId(categoryId);
			// 組出子分類List
			List<MenuSubCategoryBo> insertSubCateBoList = new ArrayList<>();
			List<MenuSubCategoryBo> updateSubCateBoList = new ArrayList<>();
			for(MenuSubCategoryInfoVo item : categoryInfoVo.getSubCateList()) {
				MenuSubCategoryBo updSubCateBo = new MenuSubCategoryBo();
				updSubCateBo.setName(item.getName());
				updSubCateBo.setSort(item.getSort());
				
				int id = item.getId();
				if(id == 0) {
					updSubCateBo.setId(lastestSubCateId);
					updSubCateBo.setCategoryId(categoryId);
					lastestSubCateId++;
					insertSubCateBoList.add(updSubCateBo);
				}else {
					updSubCateBo.setId(id);
					updateSubCateBoList.add(updSubCateBo);
				}
			}
			// update
 			menuCategoryService.updateCateInfo(updCateBo, updateSubCateBoList);
 			// insert
 			menuCategoryService.insertSubCategoryInfo(insertSubCateBoList);
 			
		}else {
			// 若分類ID為0，則新增
			// 查詢最新的分類ID
			int lastestCategoryId = menuCategoryService.queryMaxCategoryId() + 1;
			// 設定分類ID
			updCateBo.setId(lastestCategoryId);
			// 設定分類順序，一律設定為0
			updCateBo.setSort(0);
			// 組出子分類List
			List<MenuSubCategoryBo> insertSubCateBoList = new ArrayList<>();
			for(MenuSubCategoryInfoVo item : categoryInfoVo.getSubCateList()) {
				MenuSubCategoryBo updSubCateBo = new MenuSubCategoryBo();
				updSubCateBo.setId(item.getId());
				updSubCateBo.setName(item.getName());
				updSubCateBo.setCategoryId(lastestCategoryId);
				updSubCateBo.setSort(item.getSort());
				
				lastestSubCateId++;
				insertSubCateBoList.add(updSubCateBo);
			}
			// insert
			menuCategoryService.insertCategoryInfo(updCateBo);
			menuCategoryService.insertSubCategoryInfo(insertSubCateBoList);
		} 
	}
	
	/**
	 * 刪除分類
	 */
	@Override
	public void deleteCategory(int categoryId) {
		// 刪除該分類
		menuCategoryService.deleteCategory(categoryId);
		// 一併刪除對應該分類的子分類
		menuCategoryService.deleteSubCateByCate(categoryId);
		// 及餐點
		menuCategoryService.deleteMealsByCategory(categoryId);
	}
	
	/**
	 * 刪除子分類
	 */
	@Override
	public void deleteSubCategory(int subCategoryId) {
		// 刪除該子分類
		menuCategoryService.deleteSubCategory(subCategoryId);
		// 一併刪除對應該子分類的餐點
		menuCategoryService.deleteMealsBySubCate(subCategoryId);
	}
	
	/**
	 * 更新分類順序
	 */
	@Override
	public void updateCategorySort(List<SortVo> voList) {
		List<SortEntity> entityList = new ArrayList<>();
		for(SortVo category : voList) {
			SortEntity target = new SortEntity();
			BeanUtils.copyProperties(category, target);
			entityList.add(target);
		}
		menuCategoryService.updateCategorySort(entityList);
	}
}

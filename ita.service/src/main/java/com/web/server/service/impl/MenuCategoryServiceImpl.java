package com.web.server.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.server.bo.MenuCategoryBo;
import com.web.server.bo.MenuCategoryInfoBo;
import com.web.server.bo.MenuSubCategoryBo;
import com.web.server.dao.IMenuCategoryDao;
import com.web.server.entity.MenuCategoryEntity;
import com.web.server.entity.MenuCategoryInfoEntity;
import com.web.server.entity.MenuSubCategoryEntity;
import com.web.server.entity.SortEntity;
import com.web.server.service.IMenuCategoryService;

@Service
public class MenuCategoryServiceImpl implements IMenuCategoryService {

	@Autowired
	private IMenuCategoryDao menuCategoryDao;

	/**
	 * 查詢所有餐點類別
	 */
	@Override
	public List<MenuCategoryBo> queryMenuCategory() {
		List<MenuCategoryEntity> menuCategoryEntityList = menuCategoryDao.queryMenuCategory();
		List<MenuCategoryBo> menuCategoryBoList = new ArrayList<>();
		menuCategoryEntityList.forEach((menuCategory) -> {
			MenuCategoryBo target = new MenuCategoryBo();
			BeanUtils.copyProperties(menuCategory, target);
			menuCategoryBoList.add(target);
		});
		return menuCategoryBoList;
	}

	/**
	 * 查詢所有餐點子類別
	 */
	@Override
	public List<MenuSubCategoryBo> querySubCategory() {
		List<MenuSubCategoryEntity> entityist = menuCategoryDao.querySubCategory();
		List<MenuSubCategoryBo> boList = new ArrayList<>();
		entityist.forEach((entity) -> {
			MenuSubCategoryBo target = new MenuSubCategoryBo();
			BeanUtils.copyProperties(entity, target);
			boList.add(target);
		});
		return boList;
	}
	
	/**
	 * 查詢分類管理
	 */
	@Override
	public List<MenuCategoryInfoBo> queryCateInfo(int categoryId) {
		List<MenuCategoryInfoEntity> entityList = new ArrayList<>();
		
		if(categoryId == -1) {
			// 查詢所有分類
			entityList = menuCategoryDao.queryAllCateInfo();
		}else {
			// 查詢特定分類
			entityList = menuCategoryDao.queryCateInfo(categoryId);
		}
		
		List<MenuCategoryInfoBo> boList = new ArrayList<>();
		entityList.forEach((entity) -> {
			MenuCategoryInfoBo target = new MenuCategoryInfoBo();
			BeanUtils.copyProperties(entity, target);
			boList.add(target);
		});
		return boList;
	}
	
	/**
	 * 儲存設定分類修改(修改)
	 */
	@Override
	public void updateCateInfo(MenuCategoryBo categoryBo, List<MenuSubCategoryBo> subCateBoList) {
		MenuCategoryEntity categoryEntity = new MenuCategoryEntity();
		BeanUtils.copyProperties(categoryBo, categoryEntity);
		// 修改分類
		menuCategoryDao.updateCategoryInfo(categoryEntity);
		// 修改子分類
		if(subCateBoList.size() > 0) {
			// 若有子分類就修改
			List<MenuSubCategoryEntity> entityList = new ArrayList<>();
			subCateBoList.forEach((bo) -> {
				MenuSubCategoryEntity subCateEntity = new MenuSubCategoryEntity();
				BeanUtils.copyProperties(bo, subCateEntity);
				entityList.add(subCateEntity);
			});
			menuCategoryDao.updateSubCategoryInfo(entityList);
		}else {
			// 若沒有子分類則把現有的都刪除
			deleteSubCateByCate(categoryBo.getId());
		}
	}
	
	/**
	 * 查詢最新的子分類ID
	 */
	@Override
	public int queryMaxSubCateId() {
		return menuCategoryDao.queryMaxSubCateId();
	}
	
	/**
	 * 查詢最新的分類ID
	 */
	@Override
	public int queryMaxCategoryId() {
		return menuCategoryDao.queryMaxCategoryId();
	}
	
	/**
	 * 儲存設定分類修改(新增子分類)
	 */
	@Override
	public void insertSubCategoryInfo(List<MenuSubCategoryBo> subCateBoList) {
		List<MenuSubCategoryEntity> entityList = new ArrayList<>();
		subCateBoList.forEach((bo) -> {
			MenuSubCategoryEntity subCateEntity = new MenuSubCategoryEntity();
			BeanUtils.copyProperties(bo, subCateEntity);
			entityList.add(subCateEntity);
		});
		menuCategoryDao.insertSubCategoryInfo(entityList);
	}
	
	/**
	 * 儲存設定分類修改(新增分類)
	 */
	@Override
	public void insertCategoryInfo(MenuCategoryBo menuCategoryBo) {
		MenuCategoryEntity categoryEntity = new MenuCategoryEntity();
		BeanUtils.copyProperties(menuCategoryBo, categoryEntity);
		menuCategoryDao.insertCategoryInfo(categoryEntity);
	}
	
	/**
	 * 刪除分類
	 */
	@Override
	public void deleteCategory(int categoryId) {
		menuCategoryDao.deleteCategory(categoryId);
	}
	
	/**
	 * 刪除對應分類的子分類
	 */
	@Override
	public void deleteSubCateByCate(int categoryId) {
		menuCategoryDao.deleteSubCateByCate(categoryId);
	}
	
	/**
	 * 刪除對應分類的餐點
	 */
	@Override
	public void deleteMealsByCategory(int categoryId) {
		menuCategoryDao.deleteMealsByCategory(categoryId);
	}
	
	/**
	 * 刪除子分類
	 */
	@Override
	public void deleteSubCategory(int subCategoryId) {
		menuCategoryDao.deleteSubCategory(subCategoryId);
	}
	
	/**
	 * 刪除對應子分類的餐點
	 */
	@Override
	public void deleteMealsBySubCate(int subCategoryId) {
		menuCategoryDao.deleteMealsBySubCate(subCategoryId);
	}
	
	/**
	 * 更新分類順序
	 */
	@Override
	public void updateCategorySort(List<SortEntity> entityList) {
		menuCategoryDao.updateCategorySort(entityList);
	}
	
	/**
	 * 查詢有幾筆重複的類別slug
	 */
	@Override
	public int queryDuplicateSlugCount(String categoryName) {
		return menuCategoryDao.queryDuplicateSlugCount(categoryName);
	}
	
	/**
	 * 查詢有幾筆重複的類別中文名稱
	 */
	@Override
	public int queryDuplicateZhNameCount(String categoryZhName) {
		return menuCategoryDao.queryDuplicateZhNameCount(categoryZhName);
	}
}

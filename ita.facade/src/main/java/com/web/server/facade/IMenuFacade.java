package com.web.server.facade;

import java.util.List;

import com.web.server.dto.MenuListDto;
import com.web.server.vo.MenuVo;

public interface IMenuFacade {

	/**
	 * 查詢所有餐點列表
	 */
	List<MenuListDto> queryMenuList();
	
	/**
	 * 查詢特定種類的餐點列表
	 */
	List<MenuListDto> queryMenuSpecCate(int category);

	/**
	 * 新增餐點
	 */
	void addMenu(MenuVo menuVo);
	
	/**
	 * 刪除特定餐點
	 */
	void deleteSpecMenu(String id);
	
	/**
	 * 更新餐點
	 */
	void updateMenu(String id, MenuVo menuVo);
	
}

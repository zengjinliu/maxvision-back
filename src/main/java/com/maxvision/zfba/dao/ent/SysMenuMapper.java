package com.maxvision.zfba.dao.ent;

import java.util.List;

import com.maxvision.core.mybatis.QueryExample;
import com.maxvision.zfba.module.ent.SysMenu;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface SysMenuMapper {
	/**
	 * count by example
	 *
	 * @param example
	 * @return
	 */
	int countByExample(QueryExample example);

	/**
	 * delete by primary key
	 * @return
	 */
	int deleteByPrimaryKey(@Param("menuId")String menuId);
	
	/**
	 * delete by example
	 *
	 * @param example
	 * @return
	 */
	int deleteByExample(QueryExample example);

	/**
	 * insert record
	 *
	 * @param record
	 * @return
	 */
	int insert(SysMenu record);

	/**
	 * select by primary key
	 *
	 * @return
	 */
	SysMenu getByPrimaryKey(@Param("menuId")String menuId);
	
	/**
	 * select by example
	 *
	 * @param example
	 * @param rowBounds
	 * @return
	 */
	List<SysMenu> selectByExample(QueryExample example, RowBounds rowBounds);

	/**
	 * select by example
	 *
	 * @param example
	 * @return
	 */
	List<SysMenu> selectByExample(QueryExample example);
	
	/**
	 * update by primary key
	 *
	 * @return
	 */
	int updateByPrimaryKey(@Param("record") SysMenu record);
	
	/**
	 * update by primary key selective
	 *
	 * @return
	 */
	int updateByPrimaryKeySelective(@Param("record") SysMenu record);
}
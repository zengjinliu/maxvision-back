package com.maxvision.zfba.dao.ent;

import java.util.List;

import com.maxvision.core.mybatis.QueryExample;
import com.maxvision.zfba.module.ent.SysRoleMenu;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface SysRoleMenuMapper {
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
	int deleteByPrimaryKey(@Param("id")String id);
	
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
	int insert(SysRoleMenu record);

	/**
	 * select by primary key
	 *
	 * @return
	 */
	SysRoleMenu getByPrimaryKey(@Param("id")String id);
	
	/**
	 * select by example
	 *
	 * @param example
	 * @param rowBounds
	 * @return
	 */
	List<SysRoleMenu> selectByExample(QueryExample example, RowBounds rowBounds);

	/**
	 * select by example
	 *
	 * @param example
	 * @return
	 */
	List<SysRoleMenu> selectByExample(QueryExample example);
	
	/**
	 * update by primary key
	 *
	 * @return
	 */
	int updateByPrimaryKey(@Param("record") SysRoleMenu record);
	
	/**
	 * update by primary key selective
	 *
	 * @return
	 */
	int updateByPrimaryKeySelective(@Param("record") SysRoleMenu record);
}
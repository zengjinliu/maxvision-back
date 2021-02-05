package com.maxvision.zfba.dao.ent;

import java.util.List;

import com.maxvision.core.mybatis.QueryExample;
import com.maxvision.zfba.module.ent.SysLoginInfo;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface SysLoginInfoMapper {
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
	int deleteByPrimaryKey(@Param("infoId")String infoId);
	
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
	int insert(SysLoginInfo record);

	/**
	 * select by primary key
	 *
	 * @return
	 */
	SysLoginInfo getByPrimaryKey(@Param("infoId")String infoId);
	
	/**
	 * select by example
	 *
	 * @param example
	 * @param rowBounds
	 * @return
	 */
	List<SysLoginInfo> selectByExample(QueryExample example, RowBounds rowBounds);

	/**
	 * select by example
	 *
	 * @param example
	 * @return
	 */
	List<SysLoginInfo> selectByExample(QueryExample example);
	
	/**
	 * update by primary key
	 *
	 * @return
	 */
	int updateByPrimaryKey(@Param("record") SysLoginInfo record);
	
	/**
	 * update by primary key selective
	 *
	 * @return
	 */
	int updateByPrimaryKeySelective(@Param("record") SysLoginInfo record);
}
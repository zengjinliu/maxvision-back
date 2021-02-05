package com.maxvision.zfba.dao.ent;

import java.util.List;

import com.maxvision.core.mybatis.QueryExample;
import com.maxvision.zfba.module.ent.SysOperLog;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface SysOperLogMapper {
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
	int deleteByPrimaryKey(@Param("operId")String operId);
	
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
	int insert(SysOperLog record);

	/**
	 * select by primary key
	 *
	 * @return
	 */
	SysOperLog getByPrimaryKey(@Param("operId")String operId);
	
	/**
	 * select by example
	 *
	 * @param example
	 * @param rowBounds
	 * @return
	 */
	List<SysOperLog> selectByExample(QueryExample example, RowBounds rowBounds);

	/**
	 * select by example
	 *
	 * @param example
	 * @return
	 */
	List<SysOperLog> selectByExample(QueryExample example);
	
	/**
	 * update by primary key
	 *
	 * @return
	 */
	int updateByPrimaryKey(@Param("record") SysOperLog record);
	
	/**
	 * update by primary key selective
	 *
	 * @return
	 */
	int updateByPrimaryKeySelective(@Param("record") SysOperLog record);
}
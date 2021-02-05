package com.maxvision.zfba.dao.ent;

import java.util.List;

import com.maxvision.core.mybatis.QueryExample;
import com.maxvision.zfba.module.ent.SysDictData;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface SysDictDataMapper {
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
	int deleteByPrimaryKey(@Param("dictCode")String dictCode);
	
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
	int insert(SysDictData record);

	/**
	 * select by primary key
	 *
	 * @return
	 */
	SysDictData getByPrimaryKey(@Param("dictCode")String dictCode);
	
	/**
	 * select by example
	 *
	 * @param example
	 * @param rowBounds
	 * @return
	 */
	List<SysDictData> selectByExample(QueryExample example, RowBounds rowBounds);

	/**
	 * select by example
	 *
	 * @param example
	 * @return
	 */
	List<SysDictData> selectByExample(QueryExample example);
	
	/**
	 * update by primary key
	 *
	 * @return
	 */
	int updateByPrimaryKey(@Param("record") SysDictData record);
	
	/**
	 * update by primary key selective
	 *
	 * @return
	 */
	int updateByPrimaryKeySelective(@Param("record") SysDictData record);

	/**
	 * 根据字典类型、字典值查询具体值
	 * @param dictType 字典类型
	 * @param dictValue 字典值
	 * @return SysDictData
	 */
	SysDictData queryByTypeAndValue(@Param("dictType")String dictType,@Param("dictValue") String dictValue);

	/**
	 * 更具类型何止查询字典标签
	 * @param dictType 字典类型
	 * @param dictValue 字典值
	 * @return
	 */
	String queryLabel(@Param("dictType")String dictType,@Param("dictValue") String dictValue);
}
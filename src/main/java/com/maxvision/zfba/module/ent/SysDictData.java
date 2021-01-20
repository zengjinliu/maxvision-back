package com.maxvision.zfba.module.ent;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators.IntSequenceGenerator;

import com.maxvision.core.client.utils.ObjectUtils;

import java.io.Serializable;

/**
 * sys_dict_data
 * 由工具生成，请不要手工编辑
 */
@JsonIdentityInfo(generator = IntSequenceGenerator.class)
public class SysDictData implements Serializable {
	private static final long serialVersionUID = 1L;
	
	// 字典类型
	private String dictType;
	// 更新时间
	private java.util.Date updateTime;
	// 创建时间
	private java.util.Date createTime;
	// 字典键值
	private String dictValue;
	// 备注
	private String remark;
	// 字典编码
	private String dictCode;
	// 字典标签
	private String dictLabel;

	/**
	  * 获取 字典类型
	  *
	  * @return
	  */
	public String getDictType() {
		return this.dictType;
	}

	/**
	  * 设置 字典类型
	  *
	  * @param value
	  */
	public void setDictType(String value) {
		this.dictType = value;
	}

	/**
	  * 获取 更新时间
	  *
	  * @return
	  */
	public java.util.Date getUpdateTime() {
		return this.updateTime;
	}

	/**
	  * 设置 更新时间
	  *
	  * @param value
	  */
	public void setUpdateTime(java.util.Date value) {
		this.updateTime = value;
	}

	/**
	  * 获取 创建时间
	  *
	  * @return
	  */
	public java.util.Date getCreateTime() {
		return this.createTime;
	}

	/**
	  * 设置 创建时间
	  *
	  * @param value
	  */
	public void setCreateTime(java.util.Date value) {
		this.createTime = value;
	}

	/**
	  * 获取 字典键值
	  *
	  * @return
	  */
	public String getDictValue() {
		return this.dictValue;
	}

	/**
	  * 设置 字典键值
	  *
	  * @param value
	  */
	public void setDictValue(String value) {
		this.dictValue = value;
	}

	/**
	  * 获取 备注
	  *
	  * @return
	  */
	public String getRemark() {
		return this.remark;
	}

	/**
	  * 设置 备注
	  *
	  * @param value
	  */
	public void setRemark(String value) {
		this.remark = value;
	}

	/**
	  * 获取 字典编码
	  *
	  * @return
	  */
	public String getDictCode() {
		return this.dictCode;
	}

	/**
	  * 设置 字典编码
	  *
	  * @param value
	  */
	public void setDictCode(String value) {
		this.dictCode = value;
	}

	/**
	  * 获取 字典标签
	  *
	  * @return
	  */
	public String getDictLabel() {
		return this.dictLabel;
	}

	/**
	  * 设置 字典标签
	  *
	  * @param value
	  */
	public void setDictLabel(String value) {
		this.dictLabel = value;
	}


	public SysDictData copy() {
		SysDictData obj = new SysDictData();
		obj.copy(this);
		return obj;
	}
	
	public void copy(SysDictData src) {
		this.dictType = src.dictType;
		this.updateTime = src.updateTime;
		this.createTime = src.createTime;
		this.dictValue = src.dictValue;
		this.remark = src.remark;
		this.dictCode = src.dictCode;
		this.dictLabel = src.dictLabel;
	}
	
	@Override
	public boolean equals(Object o) {
		if (o == null) {
			return false;
		}

		if (!(o instanceof SysDictData)) {
			return false;
		}
        
		SysDictData other = (SysDictData)o;
		return ObjectUtils.isEqual(this.dictType, other.dictType)
			&& ObjectUtils.isEqual(this.updateTime, other.updateTime)
			&& ObjectUtils.isEqual(this.createTime, other.createTime)
			&& ObjectUtils.isEqual(this.dictValue, other.dictValue)
			&& ObjectUtils.isEqual(this.remark, other.remark)
			&& ObjectUtils.isEqual(this.dictCode, other.dictCode)
			&& ObjectUtils.isEqual(this.dictLabel, other.dictLabel);
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((this.dictCode == null) ? 0 : this.dictCode.hashCode());
		return result;
	}
}
package com.maxvision.zfba.module.ent;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators.IntSequenceGenerator;

import com.maxvision.core.client.utils.ObjectUtils;

import java.io.Serializable;

/**
 * sys_dict_type
 * 由工具生成，请不要手工编辑
 */
@JsonIdentityInfo(generator = IntSequenceGenerator.class)
public class SysDictType implements Serializable {
	private static final long serialVersionUID = 1L;
	
	// 字典类型
	private String dictType;
	// 字典主键
	private String dictId;
	// 更新时间
	private java.util.Date updateTime;
	// 字典名称
	private String dictName;
	// 创建时间
	private java.util.Date createTime;
	// 备注
	private String remark;

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
	  * 获取 字典主键
	  *
	  * @return
	  */
	public String getDictId() {
		return this.dictId;
	}

	/**
	  * 设置 字典主键
	  *
	  * @param value
	  */
	public void setDictId(String value) {
		this.dictId = value;
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
	  * 获取 字典名称
	  *
	  * @return
	  */
	public String getDictName() {
		return this.dictName;
	}

	/**
	  * 设置 字典名称
	  *
	  * @param value
	  */
	public void setDictName(String value) {
		this.dictName = value;
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


	public SysDictType copy() {
		SysDictType obj = new SysDictType();
		obj.copy(this);
		return obj;
	}
	
	public void copy(SysDictType src) {
		this.dictType = src.dictType;
		this.dictId = src.dictId;
		this.updateTime = src.updateTime;
		this.dictName = src.dictName;
		this.createTime = src.createTime;
		this.remark = src.remark;
	}
	
	@Override
	public boolean equals(Object o) {
		if (o == null) {
			return false;
		}

		if (!(o instanceof SysDictType)) {
			return false;
		}
        
		SysDictType other = (SysDictType)o;
		return ObjectUtils.isEqual(this.dictType, other.dictType)
			&& ObjectUtils.isEqual(this.dictId, other.dictId)
			&& ObjectUtils.isEqual(this.updateTime, other.updateTime)
			&& ObjectUtils.isEqual(this.dictName, other.dictName)
			&& ObjectUtils.isEqual(this.createTime, other.createTime)
			&& ObjectUtils.isEqual(this.remark, other.remark);
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((this.dictId == null) ? 0 : this.dictId.hashCode());
		return result;
	}
}
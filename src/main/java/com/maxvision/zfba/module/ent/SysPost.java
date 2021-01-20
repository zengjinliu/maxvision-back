package com.maxvision.zfba.module.ent;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators.IntSequenceGenerator;

import com.maxvision.core.client.utils.ObjectUtils;

import java.io.Serializable;

/**
 * sys_post
 * 由工具生成，请不要手工编辑
 */
@JsonIdentityInfo(generator = IntSequenceGenerator.class)
public class SysPost implements Serializable {
	private static final long serialVersionUID = 1L;
	
	// 更新时间
	private java.util.Date updateTime;
	// 岗位ID
	private String postId;
	// 创建时间
	private java.util.Date createTime;
	// 岗位名称
	private String postName;
	// 岗位编码
	private String postCode;
	// 备注
	private String remark;

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
	  * 获取 岗位ID
	  *
	  * @return
	  */
	public String getPostId() {
		return this.postId;
	}

	/**
	  * 设置 岗位ID
	  *
	  * @param value
	  */
	public void setPostId(String value) {
		this.postId = value;
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
	  * 获取 岗位名称
	  *
	  * @return
	  */
	public String getPostName() {
		return this.postName;
	}

	/**
	  * 设置 岗位名称
	  *
	  * @param value
	  */
	public void setPostName(String value) {
		this.postName = value;
	}

	/**
	  * 获取 岗位编码
	  *
	  * @return
	  */
	public String getPostCode() {
		return this.postCode;
	}

	/**
	  * 设置 岗位编码
	  *
	  * @param value
	  */
	public void setPostCode(String value) {
		this.postCode = value;
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


	public SysPost copy() {
		SysPost obj = new SysPost();
		obj.copy(this);
		return obj;
	}
	
	public void copy(SysPost src) {
		this.updateTime = src.updateTime;
		this.postId = src.postId;
		this.createTime = src.createTime;
		this.postName = src.postName;
		this.postCode = src.postCode;
		this.remark = src.remark;
	}
	
	@Override
	public boolean equals(Object o) {
		if (o == null) {
			return false;
		}

		if (!(o instanceof SysPost)) {
			return false;
		}
        
		SysPost other = (SysPost)o;
		return ObjectUtils.isEqual(this.updateTime, other.updateTime)
			&& ObjectUtils.isEqual(this.postId, other.postId)
			&& ObjectUtils.isEqual(this.createTime, other.createTime)
			&& ObjectUtils.isEqual(this.postName, other.postName)
			&& ObjectUtils.isEqual(this.postCode, other.postCode)
			&& ObjectUtils.isEqual(this.remark, other.remark);
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((this.postId == null) ? 0 : this.postId.hashCode());
		return result;
	}
}
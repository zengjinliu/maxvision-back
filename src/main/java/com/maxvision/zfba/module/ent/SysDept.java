package com.maxvision.zfba.module.ent;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators.IntSequenceGenerator;

import com.maxvision.core.client.utils.ObjectUtils;

import java.io.Serializable;

/**
 * sys_dept
 * 由工具生成，请不要手工编辑
 */
@JsonIdentityInfo(generator = IntSequenceGenerator.class)
public class SysDept implements Serializable {
	private static final long serialVersionUID = 1L;
	
	// 负责人
	private String leader;
	// 更新时间
	private java.util.Date updateTime;
	// 创建时间
	private java.util.Date createTime;
	// 联系电话
	private String phone;
	// 父部门id
	private String parentId;
	// 部门名称
	private String deptName;
	// 显示顺序
	private Integer orderNum;
	// 部门id
	private String deptId;
	// 邮箱
	private String email;

	/**
	  * 获取 负责人
	  *
	  * @return
	  */
	public String getLeader() {
		return this.leader;
	}

	/**
	  * 设置 负责人
	  *
	  * @param value
	  */
	public void setLeader(String value) {
		this.leader = value;
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
	  * 获取 联系电话
	  *
	  * @return
	  */
	public String getPhone() {
		return this.phone;
	}

	/**
	  * 设置 联系电话
	  *
	  * @param value
	  */
	public void setPhone(String value) {
		this.phone = value;
	}

	/**
	  * 获取 父部门id
	  *
	  * @return
	  */
	public String getParentId() {
		return this.parentId;
	}

	/**
	  * 设置 父部门id
	  *
	  * @param value
	  */
	public void setParentId(String value) {
		this.parentId = value;
	}

	/**
	  * 获取 部门名称
	  *
	  * @return
	  */
	public String getDeptName() {
		return this.deptName;
	}

	/**
	  * 设置 部门名称
	  *
	  * @param value
	  */
	public void setDeptName(String value) {
		this.deptName = value;
	}

	/**
	  * 获取 显示顺序
	  *
	  * @return
	  */
	public Integer getOrderNum() {
		return this.orderNum;
	}

	/**
	  * 设置 显示顺序
	  *
	  * @param value
	  */
	public void setOrderNum(Integer value) {
		this.orderNum = value;
	}

	/**
	  * 获取 部门id
	  *
	  * @return
	  */
	public String getDeptId() {
		return this.deptId;
	}

	/**
	  * 设置 部门id
	  *
	  * @param value
	  */
	public void setDeptId(String value) {
		this.deptId = value;
	}

	/**
	  * 获取 邮箱
	  *
	  * @return
	  */
	public String getEmail() {
		return this.email;
	}

	/**
	  * 设置 邮箱
	  *
	  * @param value
	  */
	public void setEmail(String value) {
		this.email = value;
	}


	public SysDept copy() {
		SysDept obj = new SysDept();
		obj.copy(this);
		return obj;
	}
	
	public void copy(SysDept src) {
		this.leader = src.leader;
		this.updateTime = src.updateTime;
		this.createTime = src.createTime;
		this.phone = src.phone;
		this.parentId = src.parentId;
		this.deptName = src.deptName;
		this.orderNum = src.orderNum;
		this.deptId = src.deptId;
		this.email = src.email;
	}
	
	@Override
	public boolean equals(Object o) {
		if (o == null) {
			return false;
		}

		if (!(o instanceof SysDept)) {
			return false;
		}
        
		SysDept other = (SysDept)o;
		return ObjectUtils.isEqual(this.leader, other.leader)
			&& ObjectUtils.isEqual(this.updateTime, other.updateTime)
			&& ObjectUtils.isEqual(this.createTime, other.createTime)
			&& ObjectUtils.isEqual(this.phone, other.phone)
			&& ObjectUtils.isEqual(this.parentId, other.parentId)
			&& ObjectUtils.isEqual(this.deptName, other.deptName)
			&& ObjectUtils.isEqual(this.orderNum, other.orderNum)
			&& ObjectUtils.isEqual(this.deptId, other.deptId)
			&& ObjectUtils.isEqual(this.email, other.email);
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((this.deptId == null) ? 0 : this.deptId.hashCode());
		return result;
	}
}
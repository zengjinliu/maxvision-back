package com.maxvision.zfba.module.ent;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators.IntSequenceGenerator;

import com.maxvision.core.client.utils.ObjectUtils;

import java.io.Serializable;

/**
 * sys_role
 * 由工具生成，请不要手工编辑
 */
@JsonIdentityInfo(generator = IntSequenceGenerator.class)
public class SysRole implements Serializable {
	private static final long serialVersionUID = 1L;
	
	// 角色名称
	private String roleName;
	// 更新时间
	private java.util.Date updateTime;
	// 创建时间
	private java.util.Date createTime;
	// 角色ID
	private String roleId;
	// 备注
	private String remark;
	// 部门ID
	private String deptId;
	// 菜单ID
	private String menuId;

	/**
	  * 获取 角色名称
	  *
	  * @return
	  */
	public String getRoleName() {
		return this.roleName;
	}

	/**
	  * 设置 角色名称
	  *
	  * @param value
	  */
	public void setRoleName(String value) {
		this.roleName = value;
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
	  * 获取 角色ID
	  *
	  * @return
	  */
	public String getRoleId() {
		return this.roleId;
	}

	/**
	  * 设置 角色ID
	  *
	  * @param value
	  */
	public void setRoleId(String value) {
		this.roleId = value;
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
	  * 获取 部门ID
	  *
	  * @return
	  */
	public String getDeptId() {
		return this.deptId;
	}

	/**
	  * 设置 部门ID
	  *
	  * @param value
	  */
	public void setDeptId(String value) {
		this.deptId = value;
	}

	/**
	  * 获取 菜单ID
	  *
	  * @return
	  */
	public String getMenuId() {
		return this.menuId;
	}

	/**
	  * 设置 菜单ID
	  *
	  * @param value
	  */
	public void setMenuId(String value) {
		this.menuId = value;
	}


	public SysRole copy() {
		SysRole obj = new SysRole();
		obj.copy(this);
		return obj;
	}
	
	public void copy(SysRole src) {
		this.roleName = src.roleName;
		this.updateTime = src.updateTime;
		this.createTime = src.createTime;
		this.roleId = src.roleId;
		this.remark = src.remark;
		this.deptId = src.deptId;
		this.menuId = src.menuId;
	}
	
	@Override
	public boolean equals(Object o) {
		if (o == null) {
			return false;
		}

		if (!(o instanceof SysRole)) {
			return false;
		}
        
		SysRole other = (SysRole)o;
		return ObjectUtils.isEqual(this.roleName, other.roleName)
			&& ObjectUtils.isEqual(this.updateTime, other.updateTime)
			&& ObjectUtils.isEqual(this.createTime, other.createTime)
			&& ObjectUtils.isEqual(this.roleId, other.roleId)
			&& ObjectUtils.isEqual(this.remark, other.remark)
			&& ObjectUtils.isEqual(this.deptId, other.deptId)
			&& ObjectUtils.isEqual(this.menuId, other.menuId);
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((this.roleId == null) ? 0 : this.roleId.hashCode());
		return result;
	}
}
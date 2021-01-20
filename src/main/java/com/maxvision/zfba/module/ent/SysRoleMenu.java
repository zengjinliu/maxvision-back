package com.maxvision.zfba.module.ent;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators.IntSequenceGenerator;

import com.maxvision.core.client.utils.ObjectUtils;

import java.io.Serializable;

/**
 * sys_role_menu
 * 由工具生成，请不要手工编辑
 */
@JsonIdentityInfo(generator = IntSequenceGenerator.class)
public class SysRoleMenu implements Serializable {
	private static final long serialVersionUID = 1L;
	
	// 角色ID
	private String roleId;
	private String id;
	// 菜单ID
	private String menuId;

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

	public String getId() {
		return this.id;
	}

	public void setId(String value) {
		this.id = value;
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


	public SysRoleMenu copy() {
		SysRoleMenu obj = new SysRoleMenu();
		obj.copy(this);
		return obj;
	}
	
	public void copy(SysRoleMenu src) {
		this.roleId = src.roleId;
		this.id = src.id;
		this.menuId = src.menuId;
	}
	
	@Override
	public boolean equals(Object o) {
		if (o == null) {
			return false;
		}

		if (!(o instanceof SysRoleMenu)) {
			return false;
		}
        
		SysRoleMenu other = (SysRoleMenu)o;
		return ObjectUtils.isEqual(this.roleId, other.roleId)
			&& ObjectUtils.isEqual(this.id, other.id)
			&& ObjectUtils.isEqual(this.menuId, other.menuId);
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((this.id == null) ? 0 : this.id.hashCode());
		return result;
	}
}
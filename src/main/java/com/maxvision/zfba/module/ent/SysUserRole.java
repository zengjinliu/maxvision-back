package com.maxvision.zfba.module.ent;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators.IntSequenceGenerator;

import com.maxvision.core.client.utils.ObjectUtils;

import java.io.Serializable;

/**
 * sys_user_role
 * 由工具生成，请不要手工编辑
 */
@JsonIdentityInfo(generator = IntSequenceGenerator.class)
public class SysUserRole implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String userId;
	private String roleId;
	private String id;

	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String value) {
		this.userId = value;
	}

	public String getRoleId() {
		return this.roleId;
	}

	public void setRoleId(String value) {
		this.roleId = value;
	}

	public String getId() {
		return this.id;
	}

	public void setId(String value) {
		this.id = value;
	}


	public SysUserRole copy() {
		SysUserRole obj = new SysUserRole();
		obj.copy(this);
		return obj;
	}
	
	public void copy(SysUserRole src) {
		this.userId = src.userId;
		this.roleId = src.roleId;
		this.id = src.id;
	}
	
	@Override
	public boolean equals(Object o) {
		if (o == null) {
			return false;
		}

		if (!(o instanceof SysUserRole)) {
			return false;
		}
        
		SysUserRole other = (SysUserRole)o;
		return ObjectUtils.isEqual(this.userId, other.userId)
			&& ObjectUtils.isEqual(this.roleId, other.roleId)
			&& ObjectUtils.isEqual(this.id, other.id);
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((this.id == null) ? 0 : this.id.hashCode());
		return result;
	}
}
package com.maxvision.zfba.module.ent;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators.IntSequenceGenerator;

import com.maxvision.core.client.utils.ObjectUtils;

import java.io.Serializable;

/**
 * sys_user_token
 * 由工具生成，请不要手工编辑
 */
@JsonIdentityInfo(generator = IntSequenceGenerator.class)
public class SysUserToken implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private java.util.Date updateTime;
	// 主键
	private String userId;
	private java.util.Date expireTime;
	private String token;

	public java.util.Date getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateTime(java.util.Date value) {
		this.updateTime = value;
	}

	/**
	  * 获取 主键
	  *
	  * @return
	  */
	public String getUserId() {
		return this.userId;
	}

	/**
	  * 设置 主键
	  *
	  * @param value
	  */
	public void setUserId(String value) {
		this.userId = value;
	}

	public java.util.Date getExpireTime() {
		return this.expireTime;
	}

	public void setExpireTime(java.util.Date value) {
		this.expireTime = value;
	}

	public String getToken() {
		return this.token;
	}

	public void setToken(String value) {
		this.token = value;
	}


	public SysUserToken copy() {
		SysUserToken obj = new SysUserToken();
		obj.copy(this);
		return obj;
	}
	
	public void copy(SysUserToken src) {
		this.updateTime = src.updateTime;
		this.userId = src.userId;
		this.expireTime = src.expireTime;
		this.token = src.token;
	}
	
	@Override
	public boolean equals(Object o) {
		if (o == null) {
			return false;
		}

		if (!(o instanceof SysUserToken)) {
			return false;
		}
        
		SysUserToken other = (SysUserToken)o;
		return ObjectUtils.isEqual(this.updateTime, other.updateTime)
			&& ObjectUtils.isEqual(this.userId, other.userId)
			&& ObjectUtils.isEqual(this.expireTime, other.expireTime)
			&& ObjectUtils.isEqual(this.token, other.token);
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((this.userId == null) ? 0 : this.userId.hashCode());
		return result;
	}
}
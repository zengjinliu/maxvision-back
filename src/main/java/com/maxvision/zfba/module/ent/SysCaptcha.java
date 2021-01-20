package com.maxvision.zfba.module.ent;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators.IntSequenceGenerator;

import com.maxvision.core.client.utils.ObjectUtils;

import java.io.Serializable;

/**
 * sys_captcha
 * 由工具生成，请不要手工编辑
 */
@JsonIdentityInfo(generator = IntSequenceGenerator.class)
public class SysCaptcha implements Serializable {
	private static final long serialVersionUID = 1L;
	
	// 验证码
	private String code;
	// 过期时间
	private java.util.Date expireTime;
	// uuid
	private String uuid;

	/**
	  * 获取 验证码
	  *
	  * @return
	  */
	public String getCode() {
		return this.code;
	}

	/**
	  * 设置 验证码
	  *
	  * @param value
	  */
	public void setCode(String value) {
		this.code = value;
	}

	/**
	  * 获取 过期时间
	  *
	  * @return
	  */
	public java.util.Date getExpireTime() {
		return this.expireTime;
	}

	/**
	  * 设置 过期时间
	  *
	  * @param value
	  */
	public void setExpireTime(java.util.Date value) {
		this.expireTime = value;
	}

	/**
	  * 获取 uuid
	  *
	  * @return
	  */
	public String getUuid() {
		return this.uuid;
	}

	/**
	  * 设置 uuid
	  *
	  * @param value
	  */
	public void setUuid(String value) {
		this.uuid = value;
	}


	public SysCaptcha copy() {
		SysCaptcha obj = new SysCaptcha();
		obj.copy(this);
		return obj;
	}
	
	public void copy(SysCaptcha src) {
		this.code = src.code;
		this.expireTime = src.expireTime;
		this.uuid = src.uuid;
	}
	
	@Override
	public boolean equals(Object o) {
		if (o == null) {
			return false;
		}

		if (!(o instanceof SysCaptcha)) {
			return false;
		}
        
		SysCaptcha other = (SysCaptcha)o;
		return ObjectUtils.isEqual(this.code, other.code)
			&& ObjectUtils.isEqual(this.expireTime, other.expireTime)
			&& ObjectUtils.isEqual(this.uuid, other.uuid);
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((this.uuid == null) ? 0 : this.uuid.hashCode());
		return result;
	}
}
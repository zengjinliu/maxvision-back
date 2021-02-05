package com.maxvision.zfba.module.ent;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators.IntSequenceGenerator;

import com.maxvision.core.client.utils.ObjectUtils;

import java.io.Serializable;

/**
 * sys_login_info
 * 由工具生成，请不要手工编辑
 */
@JsonIdentityInfo(generator = IntSequenceGenerator.class)
public class SysLoginInfo implements Serializable {
	private static final long serialVersionUID = 1L;
	
	// 提示消息
	private String msg;
	private String loginId;
	// 登录账号
	private String loginName;
	// 操作系统
	private String os;
	// 访问时间
	private java.util.Date loginTime;
	// 浏览器类型
	private String browser;
	// 访问ID
	private String infoId;
	// 登录IP地址
	private String ipaddr;
	// 登录状态（0成功 1失败）
	private String status;

	/**
	  * 获取 提示消息
	  *
	  * @return
	  */
	public String getMsg() {
		return this.msg;
	}

	/**
	  * 设置 提示消息
	  *
	  * @param value
	  */
	public void setMsg(String value) {
		this.msg = value;
	}

	public String getLoginId() {
		return this.loginId;
	}

	public void setLoginId(String value) {
		this.loginId = value;
	}

	/**
	  * 获取 登录账号
	  *
	  * @return
	  */
	public String getLoginName() {
		return this.loginName;
	}

	/**
	  * 设置 登录账号
	  *
	  * @param value
	  */
	public void setLoginName(String value) {
		this.loginName = value;
	}

	/**
	  * 获取 操作系统
	  *
	  * @return
	  */
	public String getOs() {
		return this.os;
	}

	/**
	  * 设置 操作系统
	  *
	  * @param value
	  */
	public void setOs(String value) {
		this.os = value;
	}

	/**
	  * 获取 访问时间
	  *
	  * @return
	  */
	public java.util.Date getLoginTime() {
		return this.loginTime;
	}

	/**
	  * 设置 访问时间
	  *
	  * @param value
	  */
	public void setLoginTime(java.util.Date value) {
		this.loginTime = value;
	}

	/**
	  * 获取 浏览器类型
	  *
	  * @return
	  */
	public String getBrowser() {
		return this.browser;
	}

	/**
	  * 设置 浏览器类型
	  *
	  * @param value
	  */
	public void setBrowser(String value) {
		this.browser = value;
	}

	/**
	  * 获取 访问ID
	  *
	  * @return
	  */
	public String getInfoId() {
		return this.infoId;
	}

	/**
	  * 设置 访问ID
	  *
	  * @param value
	  */
	public void setInfoId(String value) {
		this.infoId = value;
	}

	/**
	  * 获取 登录IP地址
	  *
	  * @return
	  */
	public String getIpaddr() {
		return this.ipaddr;
	}

	/**
	  * 设置 登录IP地址
	  *
	  * @param value
	  */
	public void setIpaddr(String value) {
		this.ipaddr = value;
	}

	/**
	  * 获取 登录状态（0成功 1失败）
	  *
	  * @return
	  */
	public String getStatus() {
		return this.status;
	}

	/**
	  * 设置 登录状态（0成功 1失败）
	  *
	  * @param value
	  */
	public void setStatus(String value) {
		this.status = value;
	}


	public SysLoginInfo copy() {
		SysLoginInfo obj = new SysLoginInfo();
		obj.copy(this);
		return obj;
	}
	
	public void copy(SysLoginInfo src) {
		this.msg = src.msg;
		this.loginId = src.loginId;
		this.loginName = src.loginName;
		this.os = src.os;
		this.loginTime = src.loginTime;
		this.browser = src.browser;
		this.infoId = src.infoId;
		this.ipaddr = src.ipaddr;
		this.status = src.status;
	}
	
	@Override
	public boolean equals(Object o) {
		if (o == null) {
			return false;
		}

		if (!(o instanceof SysLoginInfo)) {
			return false;
		}
        
		SysLoginInfo other = (SysLoginInfo)o;
		return ObjectUtils.isEqual(this.msg, other.msg)
			&& ObjectUtils.isEqual(this.loginId, other.loginId)
			&& ObjectUtils.isEqual(this.loginName, other.loginName)
			&& ObjectUtils.isEqual(this.os, other.os)
			&& ObjectUtils.isEqual(this.loginTime, other.loginTime)
			&& ObjectUtils.isEqual(this.browser, other.browser)
			&& ObjectUtils.isEqual(this.infoId, other.infoId)
			&& ObjectUtils.isEqual(this.ipaddr, other.ipaddr)
			&& ObjectUtils.isEqual(this.status, other.status);
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((this.infoId == null) ? 0 : this.infoId.hashCode());
		return result;
	}
}
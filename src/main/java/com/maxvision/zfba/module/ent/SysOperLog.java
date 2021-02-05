package com.maxvision.zfba.module.ent;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators.IntSequenceGenerator;

import com.maxvision.core.client.utils.ObjectUtils;

import java.io.Serializable;

/**
 * sys_oper_log
 * 由工具生成，请不要手工编辑
 */
@JsonIdentityInfo(generator = IntSequenceGenerator.class)
public class SysOperLog implements Serializable {
	private static final long serialVersionUID = 1L;
	
	// 操作时间
	private java.util.Date operTime;
	// 登陆日志标识
	private String loginId;
	// 请求参数
	private String operParam;
	// 操作人员
	private String operName;
	// 请求URL
	private String operUrl;
	// 操作
	private String operAction;
	// 日志主键
	private String operId;
	// 请求方式
	private String requestMethod;

	/**
	  * 获取 操作时间
	  *
	  * @return
	  */
	public java.util.Date getOperTime() {
		return this.operTime;
	}

	/**
	  * 设置 操作时间
	  *
	  * @param value
	  */
	public void setOperTime(java.util.Date value) {
		this.operTime = value;
	}

	/**
	  * 获取 登陆日志标识
	  *
	  * @return
	  */
	public String getLoginId() {
		return this.loginId;
	}

	/**
	  * 设置 登陆日志标识
	  *
	  * @param value
	  */
	public void setLoginId(String value) {
		this.loginId = value;
	}

	/**
	  * 获取 请求参数
	  *
	  * @return
	  */
	public String getOperParam() {
		return this.operParam;
	}

	/**
	  * 设置 请求参数
	  *
	  * @param value
	  */
	public void setOperParam(String value) {
		this.operParam = value;
	}

	/**
	  * 获取 操作人员
	  *
	  * @return
	  */
	public String getOperName() {
		return this.operName;
	}

	/**
	  * 设置 操作人员
	  *
	  * @param value
	  */
	public void setOperName(String value) {
		this.operName = value;
	}

	/**
	  * 获取 请求URL
	  *
	  * @return
	  */
	public String getOperUrl() {
		return this.operUrl;
	}

	/**
	  * 设置 请求URL
	  *
	  * @param value
	  */
	public void setOperUrl(String value) {
		this.operUrl = value;
	}

	/**
	  * 获取 操作
	  *
	  * @return
	  */
	public String getOperAction() {
		return this.operAction;
	}

	/**
	  * 设置 操作
	  *
	  * @param value
	  */
	public void setOperAction(String value) {
		this.operAction = value;
	}

	/**
	  * 获取 日志主键
	  *
	  * @return
	  */
	public String getOperId() {
		return this.operId;
	}

	/**
	  * 设置 日志主键
	  *
	  * @param value
	  */
	public void setOperId(String value) {
		this.operId = value;
	}

	/**
	  * 获取 请求方式
	  *
	  * @return
	  */
	public String getRequestMethod() {
		return this.requestMethod;
	}

	/**
	  * 设置 请求方式
	  *
	  * @param value
	  */
	public void setRequestMethod(String value) {
		this.requestMethod = value;
	}


	public SysOperLog copy() {
		SysOperLog obj = new SysOperLog();
		obj.copy(this);
		return obj;
	}
	
	public void copy(SysOperLog src) {
		this.operTime = src.operTime;
		this.loginId = src.loginId;
		this.operParam = src.operParam;
		this.operName = src.operName;
		this.operUrl = src.operUrl;
		this.operAction = src.operAction;
		this.operId = src.operId;
		this.requestMethod = src.requestMethod;
	}
	
	@Override
	public boolean equals(Object o) {
		if (o == null) {
			return false;
		}

		if (!(o instanceof SysOperLog)) {
			return false;
		}
        
		SysOperLog other = (SysOperLog)o;
		return ObjectUtils.isEqual(this.operTime, other.operTime)
			&& ObjectUtils.isEqual(this.loginId, other.loginId)
			&& ObjectUtils.isEqual(this.operParam, other.operParam)
			&& ObjectUtils.isEqual(this.operName, other.operName)
			&& ObjectUtils.isEqual(this.operUrl, other.operUrl)
			&& ObjectUtils.isEqual(this.operAction, other.operAction)
			&& ObjectUtils.isEqual(this.operId, other.operId)
			&& ObjectUtils.isEqual(this.requestMethod, other.requestMethod);
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((this.operId == null) ? 0 : this.operId.hashCode());
		return result;
	}
}
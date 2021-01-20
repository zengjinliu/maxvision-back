package com.maxvision.zfba.module.ent;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators.IntSequenceGenerator;

import com.maxvision.core.client.utils.ObjectUtils;

import java.io.Serializable;

/**
 * sys_user
 * 由工具生成，请不要手工编辑
 */
@JsonIdentityInfo(generator = IntSequenceGenerator.class)
public class SysUser implements Serializable {
	private static final long serialVersionUID = 1L;
	
	// 创建时间
	private java.util.Date createTime;
	// 用户昵称
	private String userName;
	// 用户性别（0男 1女 2未知）
	private String sex;
	// 手机号码
	private String phonenumber;
	// 备注
	private String remark;
	// 最后登陆IP
	private String loginIp;
	// 密码
	private String password;
	// 更新时间
	private java.util.Date updateTime;
	// 登录账号
	private String loginName;
	// 岗位ID
	private String postId;
	// 用户ID
	private String userId;
	// 角色ID
	private String roleId;
	// 部门ID
	private String deptId;
	// 用户邮箱
	private String email;

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
	  * 获取 用户昵称
	  *
	  * @return
	  */
	public String getUserName() {
		return this.userName;
	}

	/**
	  * 设置 用户昵称
	  *
	  * @param value
	  */
	public void setUserName(String value) {
		this.userName = value;
	}

	/**
	  * 获取 用户性别（0男 1女 2未知）
	  *
	  * @return
	  */
	public String getSex() {
		return this.sex;
	}

	/**
	  * 设置 用户性别（0男 1女 2未知）
	  *
	  * @param value
	  */
	public void setSex(String value) {
		this.sex = value;
	}

	/**
	  * 获取 手机号码
	  *
	  * @return
	  */
	public String getPhonenumber() {
		return this.phonenumber;
	}

	/**
	  * 设置 手机号码
	  *
	  * @param value
	  */
	public void setPhonenumber(String value) {
		this.phonenumber = value;
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
	  * 获取 最后登陆IP
	  *
	  * @return
	  */
	public String getLoginIp() {
		return this.loginIp;
	}

	/**
	  * 设置 最后登陆IP
	  *
	  * @param value
	  */
	public void setLoginIp(String value) {
		this.loginIp = value;
	}

	/**
	  * 获取 密码
	  *
	  * @return
	  */
	public String getPassword() {
		return this.password;
	}

	/**
	  * 设置 密码
	  *
	  * @param value
	  */
	public void setPassword(String value) {
		this.password = value;
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
	  * 获取 用户ID
	  *
	  * @return
	  */
	public String getUserId() {
		return this.userId;
	}

	/**
	  * 设置 用户ID
	  *
	  * @param value
	  */
	public void setUserId(String value) {
		this.userId = value;
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
	  * 获取 用户邮箱
	  *
	  * @return
	  */
	public String getEmail() {
		return this.email;
	}

	/**
	  * 设置 用户邮箱
	  *
	  * @param value
	  */
	public void setEmail(String value) {
		this.email = value;
	}


	public SysUser copy() {
		SysUser obj = new SysUser();
		obj.copy(this);
		return obj;
	}
	
	public void copy(SysUser src) {
		this.createTime = src.createTime;
		this.userName = src.userName;
		this.sex = src.sex;
		this.phonenumber = src.phonenumber;
		this.remark = src.remark;
		this.loginIp = src.loginIp;
		this.password = src.password;
		this.updateTime = src.updateTime;
		this.loginName = src.loginName;
		this.postId = src.postId;
		this.userId = src.userId;
		this.roleId = src.roleId;
		this.deptId = src.deptId;
		this.email = src.email;
	}
	
	@Override
	public boolean equals(Object o) {
		if (o == null) {
			return false;
		}

		if (!(o instanceof SysUser)) {
			return false;
		}
        
		SysUser other = (SysUser)o;
		return ObjectUtils.isEqual(this.createTime, other.createTime)
			&& ObjectUtils.isEqual(this.userName, other.userName)
			&& ObjectUtils.isEqual(this.sex, other.sex)
			&& ObjectUtils.isEqual(this.phonenumber, other.phonenumber)
			&& ObjectUtils.isEqual(this.remark, other.remark)
			&& ObjectUtils.isEqual(this.loginIp, other.loginIp)
			&& ObjectUtils.isEqual(this.password, other.password)
			&& ObjectUtils.isEqual(this.updateTime, other.updateTime)
			&& ObjectUtils.isEqual(this.loginName, other.loginName)
			&& ObjectUtils.isEqual(this.postId, other.postId)
			&& ObjectUtils.isEqual(this.userId, other.userId)
			&& ObjectUtils.isEqual(this.roleId, other.roleId)
			&& ObjectUtils.isEqual(this.deptId, other.deptId)
			&& ObjectUtils.isEqual(this.email, other.email);
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((this.userId == null) ? 0 : this.userId.hashCode());
		return result;
	}
}
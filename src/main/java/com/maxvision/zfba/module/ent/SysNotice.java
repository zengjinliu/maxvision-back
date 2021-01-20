package com.maxvision.zfba.module.ent;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators.IntSequenceGenerator;

import com.maxvision.core.client.utils.ObjectUtils;

import java.io.Serializable;

/**
 * sys_notice
 * 由工具生成，请不要手工编辑
 */
@JsonIdentityInfo(generator = IntSequenceGenerator.class)
public class SysNotice implements Serializable {
	private static final long serialVersionUID = 1L;
	
	// 公告标题
	private String noticeTitle;
	// 发布者
	private String createBy;
	// 更新时间
	private java.util.Date updateTime;
	// 公告内容
	private String noticeContent;
	// 创建时间
	private java.util.Date createTime;
	// 备注
	private String remark;
	// 公告ID
	private String noticeId;
	// 公告类型（1通知 2公告）
	private String noticeType;

	/**
	  * 获取 公告标题
	  *
	  * @return
	  */
	public String getNoticeTitle() {
		return this.noticeTitle;
	}

	/**
	  * 设置 公告标题
	  *
	  * @param value
	  */
	public void setNoticeTitle(String value) {
		this.noticeTitle = value;
	}

	/**
	  * 获取 发布者
	  *
	  * @return
	  */
	public String getCreateBy() {
		return this.createBy;
	}

	/**
	  * 设置 发布者
	  *
	  * @param value
	  */
	public void setCreateBy(String value) {
		this.createBy = value;
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
	  * 获取 公告内容
	  *
	  * @return
	  */
	public String getNoticeContent() {
		return this.noticeContent;
	}

	/**
	  * 设置 公告内容
	  *
	  * @param value
	  */
	public void setNoticeContent(String value) {
		this.noticeContent = value;
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
	  * 获取 公告ID
	  *
	  * @return
	  */
	public String getNoticeId() {
		return this.noticeId;
	}

	/**
	  * 设置 公告ID
	  *
	  * @param value
	  */
	public void setNoticeId(String value) {
		this.noticeId = value;
	}

	/**
	  * 获取 公告类型（1通知 2公告）
	  *
	  * @return
	  */
	public String getNoticeType() {
		return this.noticeType;
	}

	/**
	  * 设置 公告类型（1通知 2公告）
	  *
	  * @param value
	  */
	public void setNoticeType(String value) {
		this.noticeType = value;
	}


	public SysNotice copy() {
		SysNotice obj = new SysNotice();
		obj.copy(this);
		return obj;
	}
	
	public void copy(SysNotice src) {
		this.noticeTitle = src.noticeTitle;
		this.createBy = src.createBy;
		this.updateTime = src.updateTime;
		this.noticeContent = src.noticeContent;
		this.createTime = src.createTime;
		this.remark = src.remark;
		this.noticeId = src.noticeId;
		this.noticeType = src.noticeType;
	}
	
	@Override
	public boolean equals(Object o) {
		if (o == null) {
			return false;
		}

		if (!(o instanceof SysNotice)) {
			return false;
		}
        
		SysNotice other = (SysNotice)o;
		return ObjectUtils.isEqual(this.noticeTitle, other.noticeTitle)
			&& ObjectUtils.isEqual(this.createBy, other.createBy)
			&& ObjectUtils.isEqual(this.updateTime, other.updateTime)
			&& ObjectUtils.isEqual(this.noticeContent, other.noticeContent)
			&& ObjectUtils.isEqual(this.createTime, other.createTime)
			&& ObjectUtils.isEqual(this.remark, other.remark)
			&& ObjectUtils.isEqual(this.noticeId, other.noticeId)
			&& ObjectUtils.isEqual(this.noticeType, other.noticeType);
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((this.noticeId == null) ? 0 : this.noticeId.hashCode());
		return result;
	}
}
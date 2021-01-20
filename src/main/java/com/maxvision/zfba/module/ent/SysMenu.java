package com.maxvision.zfba.module.ent;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators.IntSequenceGenerator;

import com.maxvision.core.client.utils.ObjectUtils;

import java.io.Serializable;

/**
 * sys_menu
 * 由工具生成，请不要手工编辑
 */
@JsonIdentityInfo(generator = IntSequenceGenerator.class)
public class SysMenu implements Serializable {
    private static final long serialVersionUID = 1L;

    // 更新时间
    private java.util.Date updateTime;
    // 创建时间
    private java.util.Date createTime;
    // 父菜单ID
    private String parentId;
    // 菜单名称
    private String menuName;
    // 菜单图标
    private String icon;
    // 权限标识(a;b;c)用分号隔开sys_user_add;sys_user_del
    private String perms;
    // 备注
    private String remark;
    // 显示顺序
    private Integer orderNum;
    // 菜单类型(0菜单，1表示操作)
    private String type;
    // 菜单ID
    private String menuId;
    // 请求地址
    private String url;

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
     * 获取 父菜单ID
     *
     * @return
     */
    public String getParentId() {
        return this.parentId;
    }

    /**
     * 设置 父菜单ID
     *
     * @param value
     */
    public void setParentId(String value) {
        this.parentId = value;
    }

    /**
     * 获取 菜单名称
     *
     * @return
     */
    public String getMenuName() {
        return this.menuName;
    }

    /**
     * 设置 菜单名称
     *
     * @param value
     */
    public void setMenuName(String value) {
        this.menuName = value;
    }

    /**
     * 获取 菜单图标
     *
     * @return
     */
    public String getIcon() {
        return this.icon;
    }

    /**
     * 设置 菜单图标
     *
     * @param value
     */
    public void setIcon(String value) {
        this.icon = value;
    }

    /**
     * 获取 权限标识(a;b;c)用分号隔开sys_user_add;sys_user_del
     *
     * @return
     */
    public String getPerms() {
        return this.perms;
    }

    /**
     * 设置 权限标识(a;b;c)用分号隔开sys_user_add;sys_user_del
     *
     * @param value
     */
    public void setPerms(String value) {
        this.perms = value;
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
     * 获取 菜单类型(0菜单，1表示操作)
     *
     * @return
     */
    public String getType() {
        return this.type;
    }

    /**
     * 设置 菜单类型(0菜单，1表示操作)
     *
     * @param value
     */
    public void setType(String value) {
        this.type = value;
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

    /**
     * 获取 请求地址
     *
     * @return
     */
    public String getUrl() {
        return this.url;
    }

    /**
     * 设置 请求地址
     *
     * @param value
     */
    public void setUrl(String value) {
        this.url = value;
    }


    public SysMenu copy() {
        SysMenu obj = new SysMenu();
        obj.copy(this);
        return obj;
    }

    public void copy(SysMenu src) {
        this.updateTime = src.updateTime;
        this.createTime = src.createTime;
        this.parentId = src.parentId;
        this.menuName = src.menuName;
        this.icon = src.icon;
        this.perms = src.perms;
        this.remark = src.remark;
        this.orderNum = src.orderNum;
        this.type = src.type;
        this.menuId = src.menuId;
        this.url = src.url;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }

        if (!(o instanceof SysMenu)) {
            return false;
        }

        SysMenu other = (SysMenu)o;
        return ObjectUtils.isEqual(this.updateTime, other.updateTime)
                && ObjectUtils.isEqual(this.createTime, other.createTime)
                && ObjectUtils.isEqual(this.parentId, other.parentId)
                && ObjectUtils.isEqual(this.menuName, other.menuName)
                && ObjectUtils.isEqual(this.icon, other.icon)
                && ObjectUtils.isEqual(this.perms, other.perms)
                && ObjectUtils.isEqual(this.remark, other.remark)
                && ObjectUtils.isEqual(this.orderNum, other.orderNum)
                && ObjectUtils.isEqual(this.type, other.type)
                && ObjectUtils.isEqual(this.menuId, other.menuId)
                && ObjectUtils.isEqual(this.url, other.url);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((this.menuId == null) ? 0 : this.menuId.hashCode());
        return result;
    }
}
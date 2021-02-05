package com.maxvision.zfba.module.vo;

import com.maxvision.zfba.module.ent.SysMenu;
import com.maxvision.zfba.module.ent.SysUser;

import java.io.Serializable;
import java.util.List;

/**
 * 保存当前用户登陆信息
 *
 * @author minte
 * @date 2020/12/14 14:47
 */
public class CurrentUser implements Serializable {
    private static final long serialVersionUID = -3005911905465237233L;

    /**
     * 拥有角色组
     */
    private List<String> roles;

    /**
     * 菜单树
     */
    private List<TreeNode<SysMenu>> menuTree;

    /**
     * 拥有权限
     */
    private List<String> perms;

    /**
     * 当前登陆用户
     */
    private SysUser user;

    /**
     * 登陆成功标识
     */
    private String loginId;

    private CurrentUser(Builder builder) {
        this.roles = builder.roles;
        this.perms = builder.perms;
        this.user = builder.user;
        this.loginId = builder.loginId;
        this.menuTree = builder.menuTree;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private List<String> roles;
        private List<String> perms;
        private List<TreeNode<SysMenu>> menuTree;
        private SysUser user;
        private String loginId;

        public Builder roles(List<String> roles) {
            this.roles = roles;
            return this;
        }

        public Builder perms(List<String> perms) {
            this.perms = perms;
            return this;
        }

        public Builder menuTree(List<TreeNode<SysMenu>> menuTree) {
            this.menuTree = menuTree;
            return this;
        }

        public Builder user(SysUser user) {
            this.user = user;
            return this;
        }

        public Builder loginId(String loginId) {
            this.loginId = loginId;
            return this;
        }


        public CurrentUser build() {
            return new CurrentUser(this);
        }
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    public List<String> getPerms() {
        return perms;
    }

    public void setPerms(List<String> perms) {
        this.perms = perms;
    }

    public SysUser getUser() {
        return user;
    }

    public void setUser(SysUser user) {
        this.user = user;
    }

    public String getLoginId() {
        return loginId;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    public List<TreeNode<SysMenu>> getMenuTree() {
        return menuTree;
    }

    public void setMenuTree(List<TreeNode<SysMenu>> menuTree) {
        this.menuTree = menuTree;
    }


}

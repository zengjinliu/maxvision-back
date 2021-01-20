package com.maxvision.zfba.module.vo;

import com.maxvision.zfba.module.ent.SysUser;


/**
 * @author minte
 * @date 2021/1/15 21:29
 */
public class SysUserVo extends SysUser {

    /**当前页数*/
    private Integer page = 1;

    /**每页记录条数*/
    private Integer rows = 10;

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getRows() {
        return rows;
    }

    public void setRows(Integer rows) {
        this.rows = rows;
    }
}

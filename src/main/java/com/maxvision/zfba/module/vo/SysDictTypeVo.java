package com.maxvision.zfba.module.vo;

import com.maxvision.zfba.module.ent.SysDictType;

/**
 * @author minte
 */
public class SysDictTypeVo extends SysDictType {

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

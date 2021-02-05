package com.maxvision.zfba.module.vo;

import com.maxvision.zfba.module.ent.SysOperLog;

import java.util.Date;

/**
 * @author minte
 */
public class SysOperLogVo extends SysOperLog {
    /**操作日志开始时间*/
    private Date starTime;

    /**操作日志结束时间*/
    private Date endTime;

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

    public Date getStarTime() {
        return starTime;
    }

    public void setStarTime(Date starTime) {
        this.starTime = starTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }
}

package com.maxvision.zfba.controller.sys;

import com.maxvision.core.client.net.RequestMethod;
import com.maxvision.core.ioc.annotation.Inject;
import com.maxvision.core.server.pub.MapperContext;
import com.maxvision.core.web.View;
import com.maxvision.core.web.ui.annotation.*;
import com.maxvision.zfba.module.ent.SysDept;
import com.maxvision.zfba.module.vo.TreeNode;
import com.maxvision.zfba.pub.DBS;
import com.maxvision.zfba.service.sys.SysDeptService;
import com.maxvision.zfba.view.AjaxResultView;

import java.util.List;

/**
 * 系统部门控制器
 * @author minte
 */
@Controller
@RequestMapping("/sys/dept")
public class SysDeptController {

    @Inject
    private SysDeptService sysDeptService;

    /**
     * 获取树形部门结构信息
     * @return
     */
    @RequestMapping(value = "/queryTreeDept",method = RequestMethod.GET)
    public View queryTreeDept(@MapperParam(DBS.datasource) MapperContext mc){
        List<TreeNode<SysDept>> dept = sysDeptService.queryTreeDept(mc);
        return AjaxResultView.success(dept);
    }

    @RequestMapping(value = "/add",method = RequestMethod.POST,action = "新增部门")
    public View add(@MapperParam(DBS.datasource)MapperContext mc,
                    @RequestBody SysDept sysDept){
        int save = sysDeptService.save(mc,sysDept);
        return AjaxResultView.response(save);
    }

    @RequestMapping(value = "/del",method = RequestMethod.GET,action = "删除部门")
    public View del(@MapperParam(DBS.datasource)MapperContext mc,
                    @RequestParam("deptId")String deptId){
        int del = sysDeptService.deleteByDeptId(mc,deptId);
        return AjaxResultView.response(del);
    }

    @RequestMapping(value = "/id",method = RequestMethod.GET,action = "查询部门")
    public View queryByDeptId(@MapperParam(DBS.datasource)MapperContext mc,
                              @RequestParam("deptId")String deptId){
        SysDept sysDept = sysDeptService.queryByDeptId(mc,deptId);
        return AjaxResultView.success(sysDept);
    }

    @RequestMapping(value = "/update",method = RequestMethod.POST,action = "更新部门")
    public View update(@MapperParam(DBS.datasource)MapperContext mc,
                       @RequestBody SysDept sysDept){
        int update = sysDeptService.update(mc,sysDept);
        return AjaxResultView.response(update);
    }
}
package com.maxvision.zfba.controller.sys;

import com.maxvision.core.client.net.RequestMethod;
import com.maxvision.core.ioc.annotation.Inject;
import com.maxvision.core.server.pub.MapperContext;
import com.maxvision.core.web.View;
import com.maxvision.core.web.ui.annotation.*;

import com.maxvision.zfba.module.ent.SysMenu;
import com.maxvision.zfba.module.vo.TreeNode;
import com.maxvision.zfba.pub.DBS;
import com.maxvision.zfba.service.sys.SysMenuService;
import com.maxvision.zfba.view.AjaxResultView;

import java.util.List;

/**
 * 系统菜单控制器
 * @author minte
 */
@Controller
@RequestMapping("/sys/menu")
public class SysMenuController {

    @Inject
    private SysMenuService sysMenuService;

    /**
     * 获取左侧菜单栏数据
     * @return
     */
    @RequestMapping(value = "/queryTreeMenu",method = RequestMethod.GET)
    public View getSideMenu(@MapperParam(DBS.datasource)MapperContext mc,
                            @RequestParam("userId")String userId){
        List<TreeNode<SysMenu>> menu = sysMenuService.getSideMenu(mc, userId);
        return AjaxResultView.success(menu);
    }

    @RequestMapping(value = "/add",method = RequestMethod.POST,action = "新增菜单")
    public View add(@MapperParam(DBS.datasource)MapperContext mc,
                    @RequestBody SysMenu sysMenu){
        int save = sysMenuService.save(mc,sysMenu);
        return AjaxResultView.response(save);
    }

    @RequestMapping(value = "/del",method = RequestMethod.GET,action = "删除菜单")
    public View del(@MapperParam(DBS.datasource)MapperContext mc,
                    @RequestParam("menuId")String menuId){
        int del = sysMenuService.deleteByMenuId(mc,menuId);
        return AjaxResultView.response(del);
    }

    @RequestMapping(value = "/id",method = RequestMethod.GET,action = "查询菜单")
    public View queryByMenuId(@MapperParam(DBS.datasource)MapperContext mc,
                    @RequestParam("menuId")String menuId){
        SysMenu sysMenu = sysMenuService.queryByMenuId(mc,menuId);
        return AjaxResultView.success(sysMenu);
    }

    @RequestMapping(value = "/update",method = RequestMethod.POST,action = "更新菜单")
    public View update(@MapperParam(DBS.datasource)MapperContext mc,
                              @RequestBody SysMenu sysMenu){
        int update = sysMenuService.update(mc,sysMenu);
        return AjaxResultView.response(update);
    }

}

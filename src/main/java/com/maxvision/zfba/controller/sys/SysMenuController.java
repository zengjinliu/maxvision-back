package com.maxvision.zfba.controller.sys;

import com.maxvision.core.client.net.RequestMethod;
import com.maxvision.core.ioc.annotation.Inject;
import com.maxvision.core.server.pub.MapperContext;
import com.maxvision.core.web.View;
import com.maxvision.core.web.ui.annotation.Controller;
import com.maxvision.core.web.ui.annotation.MapperParam;
import com.maxvision.core.web.ui.annotation.RequestMapping;
import com.maxvision.core.web.ui.annotation.RequestParam;

import com.maxvision.zfba.module.ent.SysMenu;
import com.maxvision.zfba.module.vo.TreeNode;
import com.maxvision.zfba.pub.DBS;
import com.maxvision.zfba.service.sys.SysMenuService;
import com.maxvision.zfba.view.AjaxResultView;

import java.util.List;

/**
 * @author minte
 * @date 2021/1/15 22:46
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
    @RequestMapping(value = "/getNavList",method = RequestMethod.GET)
    public View getSideMenu(@MapperParam(DBS.datasource)MapperContext mc,
                            @RequestParam("userId")String userId){
        List<TreeNode<SysMenu>> menu = sysMenuService.getSideMenu(mc, userId);
        return AjaxResultView.success(menu);
    }


}

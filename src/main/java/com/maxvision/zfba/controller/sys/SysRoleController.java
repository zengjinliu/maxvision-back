package com.maxvision.zfba.controller.sys;

import com.maxvision.core.client.net.RequestMethod;
import com.maxvision.core.ioc.annotation.Inject;
import com.maxvision.core.server.pub.MapperContext;
import com.maxvision.core.web.View;
import com.maxvision.core.web.ui.annotation.*;
import com.maxvision.core.web.view.JsonView;
import com.maxvision.zfba.annotation.PermissionCode;
import com.maxvision.zfba.module.ent.SysRole;
import com.maxvision.zfba.module.vo.ResultPage;
import com.maxvision.zfba.module.vo.SysRoleVo;
import com.maxvision.zfba.pub.DBS;
import com.maxvision.zfba.service.sys.SysRoleService;
import com.maxvision.zfba.view.AjaxResultView;

import java.util.List;

/**
 * 系统角色控制器
 * @author minte
 */
@Controller
@RequestMapping("/sys/role")
public class SysRoleController {
    
    @Inject
    private SysRoleService sysRoleService;


    @RequestMapping(value = "/page", method = RequestMethod.POST)
    public View getPageData(@RequestBody SysRoleVo roleVo,
                            @MapperParam(DBS.datasource) MapperContext mc) {
        ResultPage<List<SysRole>> page = sysRoleService.page(mc, roleVo);
        return new JsonView(page);
    }

    @PermissionCode("sys_role_add")
    @RequestMapping(value = "/add", method = RequestMethod.POST, action = "更新用户项")
    public View add(@MapperParam(DBS.datasource) MapperContext mc,
                    @RequestBody SysRole role) {
        int save = sysRoleService.save(mc, role);
        return AjaxResultView.response(save);
    }

    @PermissionCode("sys_role_del")
    @RequestMapping(value = "/del",method = RequestMethod.POST,action = "刪除用户项")
    public View delete(@MapperParam(DBS.datasource) MapperContext mc, @RequestBody List<String> roleIds) {
        int delete = sysRoleService.delete(mc, roleIds);
        return AjaxResultView.response(delete);
    }

    @PermissionCode("sys_role_update")
    @RequestMapping(value = "/update", method = RequestMethod.POST, action = "更新用户项")
    public View update(@MapperParam(DBS.datasource) MapperContext mc,
                       @RequestBody SysRole role) {
        int update = sysRoleService.update(mc, role);
        return AjaxResultView.response(update);
    }


    @RequestMapping(value = "/id")
    public View id(@MapperParam(DBS.datasource) MapperContext mc, @RequestParam("roleId") String roleId) {
        SysRole role = sysRoleService.queryByPrimaryKey(mc, roleId);
        return AjaxResultView.success(role);
    }

    @RequestMapping(value = "/queryAllRole")
    public View queryAllRole(@MapperParam(DBS.datasource) MapperContext mc) {
        List<SysRole> roles = sysRoleService.queryAllRole(mc);
        return AjaxResultView.success(roles);
    }

}

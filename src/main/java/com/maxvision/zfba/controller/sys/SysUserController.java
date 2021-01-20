package com.maxvision.zfba.controller.sys;


import com.maxvision.core.client.net.RequestMethod;
import com.maxvision.core.ioc.annotation.Inject;
import com.maxvision.core.server.pub.MapperContext;
import com.maxvision.core.web.View;
import com.maxvision.core.web.ui.annotation.*;
import com.maxvision.core.web.view.JsonView;
import com.maxvision.zfba.annotation.PermissionCode;
import com.maxvision.zfba.module.ent.SysUser;
import com.maxvision.zfba.module.vo.ResultPage;
import com.maxvision.zfba.module.vo.SysUserVo;
import com.maxvision.zfba.pub.DBS;
import com.maxvision.zfba.service.sys.SysUserService;
import com.maxvision.zfba.util.HttpAjaxUtils;
import com.maxvision.zfba.view.AjaxResultView;

import java.util.List;


/**
 * @author minte
 * @date 2021/1/15 8:43
 */
@Controller
@RequestMapping("/sys/user")
public class SysUserController {

    @Inject
    private SysUserService sysUserService;

    @RequestMapping(value = "/page", method = RequestMethod.POST)
    public View getPageData(@RequestBody SysUserVo userVo,
                            @MapperParam(DBS.datasource) MapperContext mc) {
        ResultPage<List<SysUser>> page = sysUserService.page(mc, userVo);
        return new JsonView(page);
    }

    @PermissionCode("sys_user_del")
    @RequestMapping(value = "/del",method = RequestMethod.POST,action = "刪除用户项")
    public View delete(@MapperParam(DBS.datasource) MapperContext mc, @RequestBody List<String> userIds) {
        int delete = sysUserService.delete(mc, userIds);
        return AjaxResultView.response(delete);
    }

    @PermissionCode("sys_user_add")
    @RequestMapping(value = "/add", method = RequestMethod.POST, action = "更新用户项")
    public View add(@MapperParam(DBS.datasource) MapperContext mc,
                    @RequestBody SysUser user) {
        int save = sysUserService.save(mc, user);
        return AjaxResultView.response(save);
    }

    @RequestMapping(value = "/id")
    public View id(@MapperParam(DBS.datasource) MapperContext mc, @RequestParam("id") String id) {
        SysUser user = sysUserService.queryByPrimaryKey(mc, id);
        return AjaxResultView.success(user);
    }

    @PermissionCode("sys_user_edit")
    @RequestMapping(value = "/update", method = RequestMethod.POST, action = "更新用户项")
    public View update(@MapperParam(DBS.datasource) MapperContext mc,
                       @RequestBody SysUser user) {
        int update = sysUserService.update(mc, user);
        return AjaxResultView.response(update);
    }

}

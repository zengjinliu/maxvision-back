package com.maxvision.zfba.controller.sys;

import com.maxvision.core.ioc.annotation.Inject;
import com.maxvision.core.web.ui.annotation.*;
import com.maxvision.zfba.annotation.NoLoginSupport;
import com.maxvision.zfba.module.dto.LoginFormDto;
import com.maxvision.zfba.module.ent.SysUser;
import com.maxvision.zfba.pub.DBS;
import com.maxvision.core.client.net.RequestMethod;
import com.maxvision.core.server.pub.MapperContext;
import com.maxvision.core.web.View;
import com.maxvision.zfba.service.sys.SysLoginService;
import com.maxvision.zfba.view.AjaxResultView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * 参考代码规范(阿里编码规约)
 * 1.采用面向接口变成的模式，主要业务封装在serviceImpl中(单个方法代码过长，请进行封装处理，尽量做到一个方法处理一件事情)，
 *   控制层尽量展示数据和视图</br>
 * 2.接口定义务必要描述接口用途以及对入参约束进行详细描述，例如入参为Map<String,Object>请务必描述键值<br/>
 * 3.在if-else重要逻辑切换处请进行注释描述</br>
 * 4.全局请尽量使用javadoc注释（代码自动生成属性除外）</br>
 * 5.全局尽量不要使用魔法值，例如，if("1".equals(obj)),尽量使用常量描述</br>
 * 6.对于代码重复使用的地方尽量抽象出来，做到代码复用</br>
 * 6.所有请求都是返回View的实例,如果返回json数据格式，统一使用AjaxResultView实例</br>
 *   如果返回的是视图，统一使用FreeMarkerView实例
 * 登陆控制器
 * @author minte
 */
@Controller
@RequestMapping("/sys")
public class LoginController {

    @Inject
    private SysLoginService sysLoginService;

    @NoLoginSupport
    @RequestMapping(value = {"/login"}, method = RequestMethod.POST,action = "")
    public View doLogin(@MapperParam(DBS.datasource) MapperContext mc,
                        @RequestBody LoginFormDto formDto,
                        HttpServletRequest request,
                        HttpServletResponse response) {
        View view = sysLoginService.doLogin(mc, formDto,request,response);
        return view;
    }


    @RequestMapping(value = "/logout",method = RequestMethod.GET)
    public View doLogin(@MapperParam(DBS.datasource) MapperContext mc,
                        HttpServletRequest request) {
        sysLoginService.logout(request);
        return AjaxResultView.success();
    }


    @RequestMapping(value = {"/checkPwd"}, method = RequestMethod.POST,action = "修改密码")
    public View checkPwd(@MapperParam(DBS.datasource) MapperContext mc,
                        @RequestBody SysUser sysUser) {
        View view = sysLoginService.checkPwd(mc, sysUser);
        return view;
    }



}

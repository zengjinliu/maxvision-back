package com.maxvision.zfba.controller.sys;

import com.maxvision.core.client.module.vo.PagenateInfo;
import com.maxvision.core.client.net.RequestMethod;
import com.maxvision.core.client.utils.StringUtils;
import com.maxvision.core.ioc.annotation.Inject;
import com.maxvision.core.server.pub.MapperContext;
import com.maxvision.core.web.View;
import com.maxvision.core.web.ui.Model;
import com.maxvision.core.web.ui.annotation.*;
import com.maxvision.core.web.view.FreemarkerView;
import com.maxvision.core.web.view.JsonView;
import com.maxvision.zfba.module.ent.SysLoginInfo;
import com.maxvision.zfba.module.ent.SysOperLog;
import com.maxvision.zfba.module.vo.ResultPage;
import com.maxvision.zfba.module.vo.SysLoginInfoVo;
import com.maxvision.zfba.module.vo.SysOperLogVo;
import com.maxvision.zfba.pub.DBS;
import com.maxvision.zfba.service.sys.SysLoginInfoService;
import com.maxvision.zfba.service.sys.SysOperatorLogService;

import java.util.List;

/**
 * @author minte
 */
@Controller
@RequestMapping("/sys/login/info")
public class SysLoginInfoController {


    @Inject
    private SysLoginInfoService loginLogService;
    @Inject
    private SysOperatorLogService operatorLogService;

    @RequestMapping(value = "/page",method = RequestMethod.POST)
    public View page(@RequestBody SysLoginInfoVo loginLog,
                     @MapperParam(DBS.datasource) MapperContext mc){
        ResultPage<List<SysLoginInfo>> page = loginLogService.page(mc, loginLog);
        return new JsonView(page);
    }

    @RequestMapping(value = "/operate/page",method = RequestMethod.POST)
    public View getPageData(@RequestBody SysOperLogVo handlerLog,
                            @MapperParam(DBS.datasource) MapperContext mc){
        ResultPage<List<SysOperLog>> page = operatorLogService.page(mc, handlerLog);
        return new JsonView(page);
    }
}

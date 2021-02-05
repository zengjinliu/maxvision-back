package com.maxvision.zfba.controller.sys;

import com.maxvision.core.client.net.RequestMethod;
import com.maxvision.core.ioc.annotation.Inject;
import com.maxvision.core.server.pub.MapperContext;
import com.maxvision.core.web.View;
import com.maxvision.core.web.ui.annotation.*;
import com.maxvision.core.web.view.JsonView;
import com.maxvision.zfba.annotation.PermissionCode;
import com.maxvision.zfba.module.ent.SysDictType;
import com.maxvision.zfba.module.ent.SysDictType;
import com.maxvision.zfba.module.vo.ResultPage;
import com.maxvision.zfba.module.vo.SysDictTypeVo;
import com.maxvision.zfba.pub.DBS;
import com.maxvision.zfba.service.sys.SysDictTypeService;
import com.maxvision.zfba.view.AjaxResultView;

import java.util.List;

/**
 * @author minte
 */

@Controller
@RequestMapping("/sys/dict/type")
public class SysDictTypeController {


    @Inject
    private SysDictTypeService sysDictTypeService;


    @RequestMapping(value = "/page", method = RequestMethod.POST)
    public View getPageData(@RequestBody SysDictTypeVo sysDictTypeVo,
                            @MapperParam(DBS.datasource) MapperContext mc) {
        ResultPage<List<SysDictType>> page = sysDictTypeService.page(mc, sysDictTypeVo);
        return new JsonView(page);
    }


    @PermissionCode("sys_dict_type_add")
    @RequestMapping(value = "/add", method = RequestMethod.POST, action = "更新字典类型项")
    public View add(@MapperParam(DBS.datasource) MapperContext mc,
                    @RequestBody SysDictType dict) {
        int save = sysDictTypeService.add(mc, dict);
        return AjaxResultView.response(save);
    }

    @PermissionCode("sys_dict_type_del")
    @RequestMapping(value = "/del", method = RequestMethod.POST, action = "刪除字典类型项")
    public View delete(@MapperParam(DBS.datasource) MapperContext mc, @RequestBody List<String> dictIds) {
        int delete = sysDictTypeService.delete(mc, dictIds);
        return AjaxResultView.response(delete);
    }

    @PermissionCode("sys_dict_type_update")
    @RequestMapping(value = "/update", method = RequestMethod.POST, action = "更新字典类型项")
    public View update(@MapperParam(DBS.datasource) MapperContext mc,
                       @RequestBody SysDictType dict) {
        int update = sysDictTypeService.update(mc, dict);
        return AjaxResultView.response(update);
    }

    @RequestMapping(value = "/id",method = RequestMethod.GET)
    public View id(@MapperParam(DBS.datasource) MapperContext mc, @RequestParam("dictId") String dictId) {
        SysDictType dict = sysDictTypeService.queryById(mc, dictId);
        return AjaxResultView.success(dict);
    }


    @RequestMapping(value = "/queryAll", method = RequestMethod.GET)
    public View queryAll(@MapperParam(DBS.datasource) MapperContext mc) {
        List<SysDictType> list = sysDictTypeService.query(mc, new SysDictType());
        return AjaxResultView.success(list);
    }
}

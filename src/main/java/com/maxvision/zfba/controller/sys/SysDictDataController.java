package com.maxvision.zfba.controller.sys;

import com.maxvision.core.client.net.RequestMethod;
import com.maxvision.core.ioc.annotation.Inject;
import com.maxvision.core.server.pub.MapperContext;
import com.maxvision.core.web.View;
import com.maxvision.core.web.ui.annotation.*;
import com.maxvision.core.web.view.JsonView;
import com.maxvision.zfba.annotation.PermissionCode;
import com.maxvision.zfba.module.ent.SysDictData;
import com.maxvision.zfba.module.ent.SysDictData;
import com.maxvision.zfba.module.vo.ResultPage;
import com.maxvision.zfba.module.vo.SysDictDataVo;
import com.maxvision.zfba.module.vo.SysDictDataVo;
import com.maxvision.zfba.pub.DBS;
import com.maxvision.zfba.service.sys.SysDictDataService;
import com.maxvision.zfba.service.sys.SysDictDataService;
import com.maxvision.zfba.view.AjaxResultView;

import java.util.List;

/**
 * @author minte
 */
@Controller
@RequestMapping("/sys/dict/data")
public class SysDictDataController {


    @Inject
    private SysDictDataService sysDictDataService;


    @RequestMapping(value = "/page", method = RequestMethod.POST)
    public View getPageData(@RequestBody SysDictDataVo sysDictDataVo,
                            @MapperParam(DBS.datasource) MapperContext mc) {
        ResultPage<List<SysDictData>> page = sysDictDataService.page(mc, sysDictDataVo);
        return new JsonView(page);
    }

    @PermissionCode("sys_dict_data_add")
    @RequestMapping(value = "/add", method = RequestMethod.POST, action = "添加字典值")
    public View add(@MapperParam(DBS.datasource) MapperContext mc,
                    @RequestBody SysDictData dict) {
        int save = sysDictDataService.add(mc, dict);
        return AjaxResultView.response(save);
    }

    @PermissionCode("sys_dict_data_del")
    @RequestMapping(value = "/del", method = RequestMethod.POST, action = "刪除字典值")
    public View delete(@MapperParam(DBS.datasource) MapperContext mc, @RequestBody List<String> dictCodes) {
        int delete = sysDictDataService.delete(mc, dictCodes);
        return AjaxResultView.response(delete);
    }

    @PermissionCode("sys_dict_data_update")
    @RequestMapping(value = "/update", method = RequestMethod.POST, action = "更新字典值")
    public View update(@MapperParam(DBS.datasource) MapperContext mc,
                       @RequestBody SysDictData dict) {
        int update = sysDictDataService.update(mc, dict);
        return AjaxResultView.response(update);
    }

    @RequestMapping(value = "/id",method = RequestMethod.GET)
    public View id(@MapperParam(DBS.datasource) MapperContext mc, @RequestParam("dictCode") String dictCode) {
        SysDictData dict = sysDictDataService.queryById(mc, dictCode);
        return AjaxResultView.success(dict);
    }


}

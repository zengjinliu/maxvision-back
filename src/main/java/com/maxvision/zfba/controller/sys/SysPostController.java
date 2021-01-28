package com.maxvision.zfba.controller.sys;

import com.maxvision.core.client.net.RequestMethod;
import com.maxvision.core.ioc.annotation.Inject;
import com.maxvision.core.server.pub.MapperContext;
import com.maxvision.core.web.View;
import com.maxvision.core.web.ui.annotation.*;
import com.maxvision.core.web.view.JsonView;
import com.maxvision.zfba.annotation.PermissionCode;
import com.maxvision.zfba.module.ent.SysPost;
import com.maxvision.zfba.module.vo.ResultPage;
import com.maxvision.zfba.module.vo.SysPostVo;
import com.maxvision.zfba.pub.DBS;
import com.maxvision.zfba.service.sys.SysPostService;
import com.maxvision.zfba.view.AjaxResultView;

import java.util.List;

/**
 * 系统岗位控制器
 * @author minte
 */
@Controller
@RequestMapping("/sys/post")
public class SysPostController {

    @Inject
    private SysPostService sysPostService;

    @RequestMapping(value = "/page", method = RequestMethod.POST)
    public View getPageData(@RequestBody SysPostVo postVo,
                            @MapperParam(DBS.datasource) MapperContext mc) {
        ResultPage<List<SysPost>> page = sysPostService.page(mc, postVo);
        return new JsonView(page);
    }

    @PermissionCode("sys_post_del")
    @RequestMapping(value = "/del",method = RequestMethod.POST,action = "刪除部门项")
    public View delete(@MapperParam(DBS.datasource) MapperContext mc, @RequestBody List<String> postIds) {
        int delete = sysPostService.delete(mc, postIds);
        return AjaxResultView.response(delete);
    }

    @PermissionCode("sys_post_add")
    @RequestMapping(value = "/add", method = RequestMethod.POST, action = "更新部门项")
    public View add(@MapperParam(DBS.datasource) MapperContext mc,
                    @RequestBody SysPost post) {
        int save = sysPostService.save(mc, post);
        return AjaxResultView.response(save);
    }

    @RequestMapping(value = "/id")
    public View id(@MapperParam(DBS.datasource) MapperContext mc, @RequestParam("postId") String postId) {
        SysPost post = sysPostService.queryByPrimaryKey(mc, postId);
        return AjaxResultView.success(post);
    }

    @PermissionCode("sys_post_edit")
    @RequestMapping(value = "/update", method = RequestMethod.POST, action = "更新部门项")
    public View update(@MapperParam(DBS.datasource) MapperContext mc,
                       @RequestBody SysPost post) {
        int update = sysPostService.update(mc, post);
        return AjaxResultView.response(update);
    }

    @RequestMapping(value = "/queryAllPost")
    public View queryAllPost(@MapperParam(DBS.datasource) MapperContext mc) {
        List<SysPost> posts = sysPostService.query(mc, new SysPost());
        return AjaxResultView.success(posts);
    }
}

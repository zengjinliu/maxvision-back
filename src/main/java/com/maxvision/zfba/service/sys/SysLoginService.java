package com.maxvision.zfba.service.sys;

import com.maxvision.core.client.utils.CollectionUtils;
import com.maxvision.core.client.utils.StringUtils;
import com.maxvision.core.ioc.annotation.Component;
import com.maxvision.core.mybatis.QueryExample;
import com.maxvision.core.server.pub.MapperContext;
import com.maxvision.core.web.View;
import com.maxvision.zfba.dao.ent.SysUserMapper;
import com.maxvision.zfba.module.dto.LoginFormDto;
import com.maxvision.zfba.module.ent.SysUser;
import com.maxvision.zfba.view.AjaxResultView;

import java.util.List;


/**
 * @author minte
 */
@Component
public class SysLoginService {


    public View doLogin(MapperContext mc, LoginFormDto dto) {
        String username = dto.getUsername();
        String password = dto.getPassword();
        if (StringUtils.isNullOrEmpty(username) || StringUtils.isNullOrEmpty(password)) {
            AjaxResultView.response(400, "账号/密码不能为空");
        }
        //校验密码的正确性
        SysUserMapper mapper = mc.getMapper(SysUserMapper.class);
        QueryExample qe = new QueryExample();
        qe.or().addCriterion("s.login_name = ", username);
        List<SysUser> sysUsers = mapper.selectByExample(qe);
        if (!CollectionUtils.isEmpty(sysUsers)) {
            SysUser sysUser = sysUsers.get(0);
            if (StringUtils.isEqual(sysUser.getPassword(), password)) {
                //TODO 登陆进来用户的菜单，权限都存放再用户里面
                return AjaxResultView.success(sysUser);
            } else {
                return AjaxResultView.response(400, "密码错误");
            }
        }
        return AjaxResultView.response(400, "登陆账号错误");
    }

}

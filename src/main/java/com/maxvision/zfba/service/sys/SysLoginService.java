package com.maxvision.zfba.service.sys;

import com.maxvision.core.client.utils.StringUtils;
import com.maxvision.core.ioc.annotation.Component;
import com.maxvision.core.ioc.annotation.Inject;
import com.maxvision.core.mybatis.QueryExample;
import com.maxvision.core.server.pub.MapperContext;
import com.maxvision.core.web.View;
import com.maxvision.zfba.constants.ZyConstant;
import com.maxvision.zfba.dao.ent.SysUserMapper;
import com.maxvision.zfba.jobs.TokenGenerator;
import com.maxvision.zfba.module.dto.LoginFormDto;
import com.maxvision.zfba.module.ent.SysMenu;
import com.maxvision.zfba.module.ent.SysUser;
import com.maxvision.zfba.module.ent.SysUserToken;
import com.maxvision.zfba.module.vo.CurrentUser;
import com.maxvision.zfba.module.vo.TreeNode;
import com.maxvision.zfba.util.CommonUtils;
import com.maxvision.zfba.view.AjaxResultView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.List;


/**
 * @author minte
 */
@Component
public class SysLoginService {

    @Inject
    private SysUserService sysUserService;
    @Inject
    private SysMenuService sysMenuService;



    public View doLogin(MapperContext mc, LoginFormDto dto, HttpServletRequest req, HttpServletResponse res) {
        String username = dto.getUsername();
        String password = dto.getPassword();
        if (StringUtils.isNullOrEmpty(username) || StringUtils.isNullOrEmpty(password)) {
            AjaxResultView.response(400, "账号/密码不能为空");
        }
        //校验密码的正确性
        SysUserMapper mapper = mc.getMapper(SysUserMapper.class);
        QueryExample qe = new QueryExample();
        qe.or().addCriterion("s.login_name = ", username);
        try {
            List<SysUser> sysUsers = mapper.selectByExample(qe);
            SysUser user = sysUsers.get(0);
            //密码校验
            if (user != null && StringUtils.isEqual(user.getPassword(), password)) {
                //将登陆用户信息保存到session中
//                logininfor.setStatus(ZyEnum.LOGIN_SUCCESS.getCode());
//                logininfor.setMsg(ZyEnum.LOGIN_SUCCESS.getMsg());
                CurrentUser currentUser = this.saveUserToSession(mc, user, "id", req, res);
//                this.rememberMe(formDto.getRememberMe(), user, res, req);
                return AjaxResultView.success(currentUser);
            } else {
//                logininfor.setMsg(ZyEnum.LOGIN_FAILURE.getMsg());
//                logininfor.setStatus(ZyEnum.LOGIN_FAILURE.getCode());
                return AjaxResultView.response(500, "账户/密码错误！");
            }
        } catch (Exception e) {
//            logininfor.setMsg(e.getMessage());
            e.printStackTrace();
            return AjaxResultView.response(500, "用户不存在");
        } finally {
//       this.saveLoginLog(mc,req,logininfor);
        }

    }

    /**
     * 封装登陆返回参数
     *
     * @param mc
     * @param user
     * @param loginId
     * @param req
     * @param res
     * @return
     */
    private CurrentUser saveUserToSession(MapperContext mc, SysUser user, String loginId, HttpServletRequest req, HttpServletResponse res) {
        String userId = user.getUserId();
        //角色组
        List<String> roles = Arrays.asList(CommonUtils.PATTERN.split(user.getRoleId()));
        //菜单树
        List<TreeNode<SysMenu>> menuTree = sysMenuService.getSideMenu(mc, userId);
        //权限列表
        List<String> perms = sysMenuService.queryAllPerms(mc, userId);
        //封装分装currentUser
        CurrentUser currentUser = CurrentUser.builder()
                .menuTree(menuTree)
                .user(user).loginId(loginId)
                .perms(perms).roles(roles).build();
        //5.保存到session中
        req.getSession().setAttribute(ZyConstant.CURRENT_USER, currentUser);
        return currentUser;
    }

    /**
     * 退出登陆
     */
    public void logout(HttpServletRequest req) {
        //清除session信息
        HttpSession session = req.getSession(false);
        if (session != null) {
            //清除session信息
            req.getSession().setAttribute(ZyConstant.CURRENT_USER, null);
        }
    }


    public View checkPwd(MapperContext mc, SysUser sysUser) {
        SysUser user = sysUserService.queryByPrimaryKey(mc, sysUser.getUserId());
        if(user==null || !StringUtils.isEqual(sysUser.getPassword(),user.getPassword())){
            return AjaxResultView.response(400,"原密码输入错误");
        }
        return AjaxResultView.success();
    }
}

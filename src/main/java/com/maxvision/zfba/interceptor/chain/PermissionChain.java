package com.maxvision.zfba.interceptor.chain;


import com.maxvision.core.client.utils.CollectionUtils;
import com.maxvision.core.web.View;
import com.maxvision.core.web.WebHandler;
import com.maxvision.zfba.annotation.PermissionCode;
import com.maxvision.zfba.constants.ZyConstant;
import com.maxvision.zfba.module.vo.CurrentUser;
import com.maxvision.zfba.view.AjaxResultView;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.lang.reflect.Method;
import java.util.List;

/**
 * 权限过滤,拦截标注权限的请求服务
 *
 * @author minte
 */
public class PermissionChain extends Chain {
    private static final Logger logger = LogManager.getLogger(PermissionChain.class);
    private WebHandler webHandler;
    private HttpServletRequest request;

    public PermissionChain(WebHandler webHandler, HttpServletRequest request) {
        super();
        this.webHandler = webHandler;
        this.request = request;
    }

    /**
     * 拦截标注权限的请求服务
     */
    @Override
    protected View support() {
        // 未标识PermissionCode注解的方法可以直接放行
        Method method = webHandler.getHandlerMetaInfo().getMethod();
        boolean isPermissionCode = method.isAnnotationPresent(PermissionCode.class);
        if (!isPermissionCode) {
            return AjaxResultView.success();
        }
        String permissionCode = method.getAnnotation(PermissionCode.class).value();
        // 1.校验session
        HttpSession session = request.getSession(false);
        if (session == null) {
            logger.info("用户session已失效,无法获取当前用户权限!");
            return AjaxResultView.response(401,"用户session已失效,无法获取当前用户权限");
        }
        // 2. 获取user信息
        CurrentUser user = (CurrentUser) session.getAttribute(ZyConstant.CURRENT_USER);
        if(user == null){
            logger.info("用户认证已失效,无法获取当前用户权限!");
            return AjaxResultView.response(403,"用户认证已失效,无法获取当前用户权限");
        }
        // 3. 用户权限是否为空
        List<String> permission = user.getPerms();
        if (CollectionUtils.isEmpty(permission)) {
            logger.info("用户[{}]无任何权限，拒绝访问!",user.getUser().getLoginName());
            return AjaxResultView.response(403,"用户无操作权限");
        }
        // 4. 用户权限是否匹配
        if (permission.contains(permissionCode)) {
            return AjaxResultView.success();
        }
        logger.info("用户[{}]权限不足，拒绝访问!",user.getUser().getLoginName());
        return AjaxResultView.response(403,"用户无操作权限");
    }
}

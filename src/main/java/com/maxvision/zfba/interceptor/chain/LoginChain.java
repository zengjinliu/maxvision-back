package com.maxvision.zfba.interceptor.chain;

import com.maxvision.core.web.View;
import com.maxvision.core.web.WebHandler;
import com.maxvision.zfba.annotation.NoLoginSupport;
import com.maxvision.zfba.view.AjaxResultView;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.lang.reflect.Method;

/**
 * 登录过滤,拦截未登录的用户请求
 *
 * @author minte
 */
public class LoginChain extends Chain {
    private static final Logger logger = LogManager.getLogger(LoginChain.class);
    private WebHandler webHandler;
    private HttpServletRequest request;

    public LoginChain(WebHandler webHandler, HttpServletRequest request) {
        super();
        this.webHandler = webHandler;
        this.request = request;
    }

    /**
     * 拦截未登录的用户请求
     */
    @Override
    protected View support() {
        //NoLoginSupport注解直接放行：判断方法或class上的NoLoginSupport注解
        Method method = webHandler.getHandlerMetaInfo().getMethod();
        boolean isNoLoginSupport = method.getDeclaringClass().isAnnotationPresent(NoLoginSupport.class)
                || method.isAnnotationPresent(NoLoginSupport.class);
        if (isNoLoginSupport) {
            return AjaxResultView.success();
        }
        //1.校验用户session,如果session存在就更新token的时间,如果session失效，返回401
        HttpSession session = request.getSession(false);
        if (session == null || !request.isRequestedSessionIdValid()) {
            logger.info("用户session已失效,请重新登陆");
            return AjaxResultView.response(401, "session已失效,请重新登陆");
        }
        return AjaxResultView.success();
    }


}

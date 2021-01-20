package com.maxvision.zfba.interceptor;

import java.io.IOException;
import java.util.Date;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.maxvision.core.client.utils.FileUtils;
import com.maxvision.core.client.utils.SimpleJsonProcessor;
import com.maxvision.core.client.utils.StringUtils;
import com.maxvision.core.utils.ServletUtils;
import com.maxvision.core.web.support.HandlerMetaInfo;
import com.maxvision.zfba.constants.ZyConstant;
import com.maxvision.zfba.interceptor.chain.Chain;
import com.maxvision.zfba.interceptor.chain.ContextChain;
import com.maxvision.zfba.interceptor.chain.LoginChain;
import com.maxvision.zfba.interceptor.chain.PermissionChain;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.maxvision.core.web.WebHandler;
import com.maxvision.core.web.WebHandlerInterceptor;

/**
 * 切面类
 * 
 * @author minte
 *
 */
public class SecurityInterceptor implements WebHandlerInterceptor {

	private static Logger logger = LogManager.getLogger(SecurityInterceptor.class);

	private String loginURL;

	private String errorURL;


	@Override
	public boolean preHandle(WebHandler webHandler, HttpServletRequest request, HttpServletResponse httpServletResponse)
			throws IOException {
		// 使用责任链模式：返回true表示拦截该请求
//		Chain chain = new ContextChain(webHandler);
//		chain.setNext(new LoginChain(webHandler, request))
//				.setNext(new PermissionChain(webHandler,request));
//		if (chain.action()) {
//			boolean isAjaxRequest = "XMLHttpRequest".equals(request.getHeader("X-Requested-With"));
//			if (isAjaxRequest) {
//				// ajax请求设置状态码为401
//				httpServletResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
//			} else {
//				// 跳转登录页
//				httpServletResponse.sendRedirect(FileUtils.combinePath(request.getContextPath(), this.loginURL));
//			}
//			return false;
//		}
		return true;
	}

	/**
	 * 统一日志记录 根据@RequestMapping注解action字段记录对应的操作日志
	 */
	@Override
	public void postHandle(WebHandler webHandler, HttpServletRequest request, HttpServletResponse response) {
	}

	/**
	 * 错误日志记录
	 */
	@Override
	public void complete(WebHandler handler, HttpServletRequest request, HttpServletResponse response) {

	}



}

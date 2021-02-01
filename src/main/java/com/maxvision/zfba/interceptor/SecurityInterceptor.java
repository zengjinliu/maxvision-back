package com.maxvision.zfba.interceptor;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.maxvision.core.web.View;
import com.maxvision.zfba.interceptor.chain.Chain;
import com.maxvision.zfba.interceptor.chain.ContextChain;
import com.maxvision.zfba.interceptor.chain.LoginChain;
import com.maxvision.zfba.interceptor.chain.PermissionChain;
import com.maxvision.zfba.view.AjaxResult;
import com.maxvision.zfba.view.AjaxResultView;
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



	@Override
	public boolean preHandle(WebHandler webHandler, HttpServletRequest request, HttpServletResponse httpServletResponse)
			throws IOException {
		// 使用责任链模式：返回true表示拦截该请求
		Chain chain = new ContextChain(webHandler);
		chain.setNext(new LoginChain(webHandler, request))
				.setNext(new PermissionChain(webHandler,request));

		View action = chain.action();
		if(action.getClass().isAssignableFrom(AjaxResultView.class)){
			AjaxResultView v = (AjaxResultView) action;
			AjaxResult obj = (AjaxResult) v.getObj();
			if(obj.getCode()!=200){
				httpServletResponse.setHeader("code",String.valueOf(obj.getCode()));
				return false;
			}
		}
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

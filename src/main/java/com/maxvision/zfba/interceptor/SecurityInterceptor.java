package com.maxvision.zfba.interceptor;

import java.io.IOException;
import java.util.Date;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.maxvision.core.client.utils.SimpleJsonProcessor;
import com.maxvision.core.client.utils.StringUtils;
import com.maxvision.core.utils.ServletUtils;
import com.maxvision.core.web.View;
import com.maxvision.core.web.support.HandlerMetaInfo;
import com.maxvision.zfba.constants.ZyConstant;
import com.maxvision.zfba.interceptor.chain.Chain;
import com.maxvision.zfba.interceptor.chain.ContextChain;
import com.maxvision.zfba.interceptor.chain.LoginChain;
import com.maxvision.zfba.interceptor.chain.PermissionChain;
import com.maxvision.zfba.module.ent.SysOperLog;
import com.maxvision.zfba.module.vo.CurrentUser;
import com.maxvision.zfba.service.sys.SysOperatorLogService;
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

	private SysOperatorLogService operatorLogService;

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
		try {
			HandlerMetaInfo metaInfo = webHandler.getHandlerMetaInfo();
			if (!StringUtils.isNullOrEmpty(metaInfo.getAction())) {
				// 获取用户login id
				CurrentUser user = (CurrentUser) request.getSession().getAttribute(ZyConstant.CURRENT_USER);
				Map<String, String[]> parameterMap = request.getParameterMap();
				SimpleJsonProcessor processor = new SimpleJsonProcessor();
				SysOperLog handlerLog = new SysOperLog();
				String param = processor.render(parameterMap).replace("\r\n", "").replace(" ", "");
				handlerLog.setRequestMethod(request.getMethod());
				handlerLog.setOperTime(new Date());
				handlerLog.setOperParam(param);
				handlerLog.setLoginId(user.getLoginId());
				handlerLog.setOperName(user.getUser().getLoginName());
				handlerLog.setOperAction(metaInfo.getAction());
				handlerLog.setOperUrl(ServletUtils.getServletPath(request));
				operatorLogService.save(handlerLog);
			}
		} catch (Exception e) {
			logger.error(e);
		}
	}

	/**
	 * 错误日志记录
	 */
	@Override
	public void complete(WebHandler handler, HttpServletRequest request, HttpServletResponse response) {
		try {
			HandlerMetaInfo metaInfo = handler.getHandlerMetaInfo();
			if (response.getStatus() == HttpServletResponse.SC_INTERNAL_SERVER_ERROR) {
				CurrentUser user = (CurrentUser) request.getSession().getAttribute(ZyConstant.CURRENT_USER);
				// 获取用户login id 并记录日志
				Map<String, String[]> parameterMap = request.getParameterMap();
				SimpleJsonProcessor processor = new SimpleJsonProcessor();
				SysOperLog handlerLog = new SysOperLog();
				String param = processor.render(parameterMap).replace("\r\n", "").replace(" ", "");
				handlerLog.setRequestMethod(request.getMethod());
				handlerLog.setOperTime(new Date());
				handlerLog.setOperParam(param);
				handlerLog.setLoginId(user.getLoginId());
				handlerLog.setOperName(user.getUser().getLoginName());
				handlerLog.setOperAction(metaInfo.getAction());
				handlerLog.setOperUrl(ServletUtils.getServletPath(request));
				operatorLogService.save(handlerLog);
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
	}


	public SysOperatorLogService getOperatorLogService() {
		return operatorLogService;
	}

	public void setOperatorLogService(SysOperatorLogService operatorLogService) {
		this.operatorLogService = operatorLogService;
	}
}

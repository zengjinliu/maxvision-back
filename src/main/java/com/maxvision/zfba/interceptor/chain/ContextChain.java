package com.maxvision.zfba.interceptor.chain;

import com.maxvision.core.web.WebHandler;
import com.maxvision.core.web.support.HandlerMetaInfo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.reflect.Method;

/**
 * 环境过滤,访问无效url返回登录页
 * 
 * @author minte
 *
 */
public class ContextChain extends Chain {

	private static final Logger logger=LogManager.getLogger(ContextChain.class);

	private WebHandler webHandler;

	public ContextChain(WebHandler webHandler) {
		super();
		this.webHandler = webHandler;
	}

	@Override
	protected boolean support() {
		HandlerMetaInfo metaInfo = webHandler.getHandlerMetaInfo();
		// 找不到处理器直接拦截
		if (metaInfo == null) {
			logger.info("访问无效地址");
			return true;
		}
		// 找不到方法直接拦截
		Method method = metaInfo.getMethod();
		if(method==null){
			logger.info("访问无效方法");
			return true;
		}
		return false;
	}
}

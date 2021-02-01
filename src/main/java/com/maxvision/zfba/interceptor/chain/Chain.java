package com.maxvision.zfba.interceptor.chain;

import com.maxvision.core.web.View;
import com.maxvision.zfba.view.AjaxResult;
import com.maxvision.zfba.view.AjaxResultView;



/**
 * 拦截器 -责任链
 * @author minte
 *
 */
public abstract class Chain {
	
	private Chain next;

	public Chain setNext(Chain next) {
		this.next = next;
		return next;
	}

	//执行器
	public View action() {
		//true表示拦截，直接返回true
		View support = support();
		if(support.getClass().isAssignableFrom(AjaxResultView.class)){
			AjaxResultView view = (AjaxResultView)support;
			AjaxResult obj = (AjaxResult) view.getObj();
			if(obj.getCode()!=200){
				return view;
			}
		}
		//责任链
		if(next!=null) {
			return next.action();
		}
		return AjaxResultView.success();
	}
	
	//具体实现,  true放行，false拦截
	abstract protected View support();
}

package com.maxvision.zfba.interceptor.chain;

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
	public boolean action() {
		//true表示拦截，直接返回true
		if(support()){
			return true;
		}
		//责任链
		if(next!=null) {
			return next.action();
		}
		return false;
	}
	
	//具体实现,  true放行，false拦截
	abstract protected boolean support();
}

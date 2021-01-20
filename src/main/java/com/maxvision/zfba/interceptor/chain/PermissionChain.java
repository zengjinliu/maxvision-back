package com.maxvision.zfba.interceptor.chain;



/**
 * 权限过滤,拦截标注权限的请求服务
 *
 * @author minte
 */
public class PermissionChain extends Chain {


    /**
     * 拦截标注权限的请求服务
     */
    @Override
    protected boolean support() {

        return false;
    }
}

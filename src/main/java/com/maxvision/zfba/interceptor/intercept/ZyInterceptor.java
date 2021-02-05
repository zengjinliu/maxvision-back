package com.maxvision.zfba.interceptor.intercept;

import com.maxvision.core.web.View;

/**
 * @author minte
 */
public interface ZyInterceptor<T extends View> {

    int priority();


    T doIntercept();

}

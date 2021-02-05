package com.maxvision.zfba.interceptor.intercept;

import com.maxvision.zfba.view.AjaxResultView;

/**
 * @author minte
 */
public class ZyContextHandler implements ZySystemIntercept {

    @Override
    public int priority() {
        return 0;
    }

    @Override
    public AjaxResultView doIntercept() {
        return null;
    }
}

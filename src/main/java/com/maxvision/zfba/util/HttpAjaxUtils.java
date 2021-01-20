package com.maxvision.zfba.util;

import com.maxvision.zfba.view.AjaxResult;
import com.maxvision.zfba.view.AjaxResultView;

/**
 * 返回页面数据
 */
public class HttpAjaxUtils {




    /**
     * 返回失败信息
     * @param msg
     * @return
     */
    public static AjaxResult errAjax(String msg){
        AjaxResult ajaxResult=new AjaxResult();
        ajaxResult.setMsg(msg);
        return ajaxResult;
    }
}

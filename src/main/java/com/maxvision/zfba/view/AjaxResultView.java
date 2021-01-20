package com.maxvision.zfba.view;

import com.maxvision.core.web.view.JsonView;


public class AjaxResultView<T> extends JsonView {


    public AjaxResultView(T data) {
        super(data);
        super.setUseAnnotations(true);
        // 取消日期格式，使用timestamp，防止精度丢失
        super.setDataFormat("");
        super.setUseAnnotations(false);
    }

    public static AjaxResultView success() {
        return new AjaxResultView(AjaxResult.success());
    }

    public static <T> AjaxResultView<T> success(T data) {
        return new AjaxResultView(AjaxResult.success(data));
    }

    public static <T> AjaxResultView<T> success(int code,String msg,T data) {
        return new AjaxResultView(AjaxResult.success(code,msg,data));
    }


    public static <T> AjaxResultView response(int code, String msg) {
        return new AjaxResultView(AjaxResult.response(code, msg));
    }

    public static AjaxResultView response(int count){
        if(count>0){
            return AjaxResultView.response(200,"操作成功");
        }else{
            return AjaxResultView.response(500,"操作失败");
        }
    }
}

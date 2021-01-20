package com.maxvision.zfba.view;



/**
 * 系统统一返回json数据结构
 * @date 2020/10/23 16:52
 */
public class AjaxResult<T> {

    private int code;

    private String msg;

    private T data;

    public static <T> AjaxResult<T> response(Integer code, String msg) {
        return result(code,msg,null);
    }

    public static <T> AjaxResult<T> success(T data) {
        return result(200, "success", data);
    }


    public static <T> AjaxResult<T> success(T data, String msg) {
        return result(200, msg, data);
    }

    public static <T> AjaxResult<T> success(int code, String msg,T data) {
        return result(code, msg, data);
    }

    public static <T> AjaxResult<T> success() {
        return result(200, "success", null);
    }

    private static <T> AjaxResult<T> result(Integer code, String msg, T data) {
        //没有数据，只返回状态码和消息
        AjaxResult<T> resultJson = new AjaxResult<T>();
        resultJson.setCode(code);
        resultJson.setMsg(msg);
        resultJson.setData(data);
        return resultJson;
    }


    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}

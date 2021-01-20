package com.maxvision.zfba.constants;

/**
 * 系统常量
 * @author minte
 * @date 2020/12/14 16:04
 */
public class ZyConstant {

    /**系统当前登陆用户*/
    public static final String CURRENT_USER = "user";

    /**系统管理员角色*/
    public static final String SYS_ADMIN_ROLE = "1";

    /**remember me key*/
    public static final String REMEMBER_ME = "loginInfo";

    /**记住我的时长(7天)*/
    public static final int REMEMBER_TTL = 7 * 24 * 60 * 60;

    /**系统配置sessionkey*/
    public static final String SESSION_VALID_KEY = "session_valid_time";

    /**登陆的的用户token*/
    public static final String USER_TOKEN = "login_user_token";

    /**系统缓存字典表key*/
    public static final String CACHE_SYS_DICT_KEY = "cache:sys:dict";

}

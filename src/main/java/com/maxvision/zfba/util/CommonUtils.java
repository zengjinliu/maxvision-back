package com.maxvision.zfba.util;


import com.maxvision.core.client.utils.RandomUtils;

import java.util.regex.Pattern;

/**
 * 字典数据 专用
 * redis里面字符串和集合的互相转换 工具类
 */
public class CommonUtils {

    public static final Pattern PATTERN = Pattern.compile(",");


    /***
     * 生成uuid32为小写
     * @return
     */
    public static String id(){
        return RandomUtils.randomUUID().toLowerCase();
    }

}

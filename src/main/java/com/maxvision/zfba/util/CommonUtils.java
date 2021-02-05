package com.maxvision.zfba.util;


import com.maxvision.core.client.utils.CollectionUtils;
import com.maxvision.core.client.utils.RandomUtils;

import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 字典数据 专用
 * redis里面字符串和集合的互相转换 工具类
 */
public class CommonUtils {

    public static final Pattern PATTERN = Pattern.compile(",");

    /**
     * 拆分list集合
     *
     * @param origin 原始集合
     * @param size 拆分大小
     * @param <T> 类型
     * @return
     */
    public static <T> List<List<T>> split(final List<T> origin, final int size) {
        if (CollectionUtils.isEmpty(origin)) {
            return Collections.emptyList();
        }
        int block = (origin.size() + size - 1) / size;
        return IntStream.range(0, block).
                boxed().map(i -> {
            int start = i * size;
            int end = Math.min(start + size, origin.size());
            return origin.subList(start, end);
        }).collect(Collectors.toList());
    }
}

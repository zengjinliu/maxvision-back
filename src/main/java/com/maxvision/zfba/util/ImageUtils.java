package com.maxvision.zfba.util;

import com.maxvision.core.client.utils.FileUtils;
import com.maxvision.core.client.utils.RandomUtils;
import com.maxvision.zfba.conf.SysConfig;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Objects;

/**
 * @author minte
 * @date 2020/12/23 16:24
 */
public class ImageUtils {

    private final  static Logger logger = LogManager.getLogger(ImageUtils.class);

    /**
     * 保存图片到本地并返回path
     *
     * @param bytes 字节数组
     * @param mouduleName  模块名
     * @return
     */
    public static String saveImgageToLocal(byte[] bytes,String mouduleName) {
        StringBuilder sb = new StringBuilder();
        sb.append(SysConfig.config.getImagePath()).append(mouduleName);
        //根据配置和时间生成前缀目录
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("/yyyy/MM/dd", Locale.CHINA);
        String s = now.format(formatter);
        sb.append(s);
        String dir = FileUtils.combinePath(sb.toString());
        //生成随机文件名
        String file = RandomUtils.randomUUID().toLowerCase() + ".jpg";
        String path = FileUtils.combinePath(dir, file);
        boolean f = generateImage(bytes, path);
        return f ? path : null;
    }

    /**
     * byte数组转存图片
     *
     * @param b
     * @param path
     * @return
     */
    public static final boolean generateImage(byte[] b, String path) {
        if (b == null || path == null) {
            logger.error("image and path must not be null");
            return false;
        }
        OutputStream out = null;
        try {
            File w2 = new File(path);
            if (!w2.getParentFile().exists()) {
                w2.getParentFile().mkdirs();
            }
            out = new FileOutputStream(w2);
            out.write(b);
            out.flush();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            return false;
        } finally {
            if (Objects.nonNull(out)) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}

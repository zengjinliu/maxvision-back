package com.maxvision.zfba.conf;

import com.maxvision.core.client.utils.FileUtils;
import com.maxvision.core.client.utils.SimpleJsonProcessor;
import com.maxvision.core.client.utils.StringUtils;
import com.maxvision.core.utils.IocBeanUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;

/**
 * 对应sys.json文件中的配置,key值必须要求一样
 *
 * @date 2020/12/11 13:34
 */
public final class SysConfig {

    private static final Logger logger = LogManager.getLogger(SysConfig.class);

    public static final SysConfig config = new SysConfig();

    private boolean isAddressEnable;

    /**本地图片存储路径*/
    private String imagePath;
    /**人脸服务路径*/
    private String faceServerUrl;
    /**人脸照片质量最低得分*/
    private double faceScore;
    /**socket服务地址*/
    private String socketUrl;



    private SysConfig() {
    }

    /**
     * 加载配置文件
     *
     * @param confFile
     */
    public SysConfig load(File confFile) {
        if (!confFile.exists()) {
            return this;
        }
        logger.info("begin to load sys config");

        SimpleJsonProcessor processor = new SimpleJsonProcessor();
        String json;
        try {
            json = FileUtils.readAllText(confFile);
        } catch (IOException e) {
            logger.error(e);
            json = "";
        }
        if (StringUtils.isNullOrEmpty(json)) {
            return this;
        }
        SysConfig conf = processor.fromJson(json, SysConfig.class);
        if (conf == null) {
            logger.error("failed to load sys config.");
            return this;
        }
        IocBeanUtils.copyProperties(conf, config);
        return this;
    }


    public boolean isAddressEnable() {
        return isAddressEnable;
    }

    public void setAddressEnable(boolean addressEnable) {
        isAddressEnable = addressEnable;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getFaceServerUrl() {
        return faceServerUrl;
    }

    public void setFaceServerUrl(String faceServerUrl) {
        this.faceServerUrl = faceServerUrl;
    }

    public double getFaceScore() {
        return faceScore;
    }

    public void setFaceScore(double faceScore) {
        this.faceScore = faceScore;
    }

    public String getSocketUrl() {
        return socketUrl;
    }

    public void setSocketUrl(String socketUrl) {
        this.socketUrl = socketUrl;
    }
}

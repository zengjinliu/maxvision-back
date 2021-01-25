package com.maxvision.zfba.controller.sys;

import com.maxvision.core.client.net.RequestMethod;
import com.maxvision.core.client.utils.StringUtils;
import com.maxvision.core.server.pub.AppEnvironment;
import com.maxvision.core.web.View;
import com.maxvision.core.web.multipart.UploadedFilePart;
import com.maxvision.core.web.ui.annotation.Controller;
import com.maxvision.core.web.ui.annotation.RequestMapping;
import com.maxvision.core.web.ui.annotation.RequestParam;
import com.maxvision.core.web.view.ImageView;
import com.maxvision.zfba.util.AesEncryptUtils;
import com.maxvision.zfba.util.ImageUtils;
import com.maxvision.zfba.view.AjaxResultView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * 由于系统将图片存储到本地磁盘，为了便于前端展示</br>
 * 都将本地文件路径进行加密存放到数据库中</br>
 * 前端统一请求由此控制器进行解密并返回imageView展示图片,后端采用
 * aes+base64加密模式
 *
 * @author minte
 */
@Controller
@RequestMapping("/sys/image")
public class ImageViewController {


    /**
     * 图片路径展示
     * @param encryptPath
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/show",method = RequestMethod.GET)
    public View dealImage(@RequestParam("path") String encryptPath) throws Exception{
        if(StringUtils.isNullOrEmpty(encryptPath)){
            return new ImageView(null);
        }
        String path = AesEncryptUtils.decryptReplae(encryptPath);
        return new ImageView(path);
    }

    @RequestMapping(value = "/upload",method = RequestMethod.POST)
    public View upload(HttpServletRequest request, @RequestParam("file")UploadedFilePart file) throws Exception{
        StringBuilder sb = new StringBuilder();
        sb.append(request.getScheme()).append("://")
                .append(request.getServerName())
                .append(":").append(request.getServerPort());
        String path = ImageUtils.saveImgageToLocal(file.get(), "upload");
        Map<String,String> src = new HashMap<>(3);
        src.put("src", sb.toString() + "/sys/image/show?path=" + AesEncryptUtils.encryptReplace(path));
        return AjaxResultView.success(0,"success",src);
    }



}

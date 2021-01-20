package com.maxvision.zfba.util;

import org.apache.commons.codec.binary.Base64;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.SecretKeySpec;


/**
 * @author yuli
 * @create 2020-03-31 14:00
 */
public class AesEncryptUtils {
    private static final String KEY = "abcdef0123456789";

    //参数分别代表 算法名称/加密模式/数据填充方式
    private static final String ALGORITHMSTR = "AES/ECB/PKCS5Padding";

    /**
     * 加密
     * @param content 加密的字符串
     * @param encryptKey key值
     * @return
     * @throws Exception
     */
    public static String encrypt(String content, String encryptKey) throws Exception {
        KeyGenerator kgen = KeyGenerator.getInstance("AES");
        kgen.init(128);
        Cipher cipher = Cipher.getInstance(ALGORITHMSTR);
        cipher.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(encryptKey.getBytes(), "AES"));
        byte[] b = cipher.doFinal(content.getBytes("utf-8"));
        return Base64.encodeBase64String(b);
    }

    /**
     * 解密
     * @param encryptStr 解密的字符串
     * @param decryptKey 解密的key值
     * @return
     * @throws Exception
     */
    public static String decrypt(String encryptStr, String decryptKey) throws Exception {
        KeyGenerator kgen = KeyGenerator.getInstance("AES");
        kgen.init(128);
        Cipher cipher = Cipher.getInstance(ALGORITHMSTR);
        cipher.init(Cipher.DECRYPT_MODE, new SecretKeySpec(decryptKey.getBytes(), "AES"));
        byte[] encryptBytes = Base64.decodeBase64(encryptStr);
        byte[] decryptBytes = cipher.doFinal(encryptBytes);
        return new String(decryptBytes);
    }

    public static String encrypt(String content) throws Exception {
        return encrypt(content, KEY);
    }

    public static String encryptReplace(String encrypt) throws Exception{
        String encrypt1 = encrypt(encrypt, KEY);
        byte[] bytes = Base64.encodeBase64(encrypt1.getBytes());
        return new String(bytes);
    }
    public static String decrypt(String encryptStr) throws Exception {
        return decrypt(encryptStr, KEY);
    }
    public static String decryptReplae(String encryptStr) throws Exception {
        byte[] bytes = Base64.decodeBase64(encryptStr.getBytes());
        String s = new String(bytes);
        return decrypt(s, KEY);
    }

    public static String encryptReplace1(String encrypt) {
        if (encrypt != null){
            try {
                String  encrypt1 = encrypt(encrypt, KEY);
                byte[] bytes = Base64.encodeBase64(encrypt1.getBytes());
                return new String(bytes);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}

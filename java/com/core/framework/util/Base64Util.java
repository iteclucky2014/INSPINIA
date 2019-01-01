package com.core.framework.util;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.IOException;

/**
 * Base64工具类
 * 
 * @author lucky
 * 
 */
public class Base64Util {
    
    /**
     * 加密算法
     */
    public static String encode(String str) {
        BASE64Encoder base64Encoder = new BASE64Encoder();
        return base64Encoder.encode(str.getBytes());
    }
    
    /**
     * 解密算法
     */
    public static String decode(String str) {
        try {
            BASE64Decoder base64Decoder = new BASE64Decoder();
            return new String(base64Decoder.decodeBuffer(str));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }
    
}

package cn.huas.xueshe.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import cn.huas.xueshe.util.L;

/**
 * Created by 74071 on 2017/3/26.
 */

public class configXML {

    private static Properties properties = new Properties();
    static final String filePath = "config.properties";
    static final String sToken = "token";
    static final String sUserId = "userId";
    private static InputStream is;
//    static Properties properties;

    public static void setToken(String token, String userId) {
        try {
            is = configXML.class.getResourceAsStream(filePath);
            properties.load(is);
            //获取配置文件中的静态属性
            properties.setProperty(sToken, token);
            properties.setProperty(sUserId, userId);
        } catch (IOException e) {
            L.e(e.getMessage());
        }
    }

    public static String getToken() {
//        return SharedPrefsUtils.getValue(packageContext, filePath, sToken, "");
        try {
            is = configXML.class.getResourceAsStream(filePath);
            properties.load(is);
            //获取配置文件中的静态属性
            return (String) properties.get(sToken);
        } catch (IOException e) {
            L.e(e.getMessage());
        }
        return "";
    }


    public static String getUserId() {
        try {
            is = configXML.class.getResourceAsStream(filePath);
            properties.load(is);
            //获取配置文件中的静态属性
            return (String) properties.get(sUserId);
        } catch (IOException e) {
            L.e(e.getMessage());
        }
        return "";
    }

    public static void clean() {
        try {
            is = configXML.class.getResourceAsStream(filePath);
            properties.load(is);
            //获取配置文件中的静态属性
            properties.clear();
        } catch (IOException e) {
            L.e(e.getMessage());
        }
    }
}
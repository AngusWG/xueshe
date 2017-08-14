package cn.huas.xueshe.service;

import android.content.Context;

import org.json.JSONObject;

import java.io.IOException;
import java.util.Map;

import cn.huas.xueshe.service.impl.HttpUtilsImpl;
import okhttp3.RequestBody;

/**
 * Created by 74071 on 2017/2/11.
 */


public class Http {


    static public JSONObject doPostJsom(String URL, JSONObject jsonObject, Context context) throws Exception {
        HttpUtilsImpl http = new HttpUtilsImpl();
        return http.doPostJsom(URL, jsonObject, context);
    }

    static public String doPostForm(String URL, RequestBody Body) throws Exception {
        HttpUtilsImpl http = new HttpUtilsImpl();
        return http.doPostForm(URL, Body);
    }

    static public String getInfo(String URL, Context context) throws IOException {
        HttpUtilsImpl http = new HttpUtilsImpl();
        return http.getInfo(URL, context);

    }

    static public String getInfoByParameter(String URL, Map<String, Integer> m, Context context) throws Exception {
        HttpUtilsImpl http = new HttpUtilsImpl();
        return http.getInfoByParameter(URL, m, context);
    }
}

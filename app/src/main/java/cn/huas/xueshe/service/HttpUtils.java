package cn.huas.xueshe.service;

import android.content.Context;

import org.json.JSONObject;

import java.util.Map;

import okhttp3.RequestBody;

/**
 * Created by 74071 on 2017/2/11.
 */

public interface HttpUtils {

    String doPostForm(String URL, RequestBody Body) throws Exception;

    JSONObject doPostJsom(String URL, JSONObject jsonObject, Context context) throws Exception;

    String getInfo(String URL, Context context) throws Exception;

    String getInfoByParameter(String URL, Map<String, Integer> m, Context context) throws Exception;
}

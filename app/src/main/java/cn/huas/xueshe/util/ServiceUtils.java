package cn.huas.xueshe.util;

import android.content.Context;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

/**
 * Created by 74071 on 2017/4/9.
 */

public class ServiceUtils {
    private static final String code = "code";
    private static final String data = "data";
    private static final String message = "message";
    private static final String emptyString = "";

    private static final String errorService = "服务器出错";
    private static final String errorFormat = "所发文档格式错误";

    public static String analysis(Context context, String jsonString) {
        String result;
//        L.e("analysis " + jsonString);
        JSONObject jsonObject = JSON.parseObject(jsonString);
        if (!"200".equals(jsonObject.get(code))) {
            Toast.makeText(context, errorService, Toast.LENGTH_SHORT);
            L.w(errorService);
            return "false";
        }
        if (!"success".equals(jsonObject.get(message))) {
            Toast.makeText(context, errorFormat, Toast.LENGTH_SHORT);
            L.w(errorFormat);
            return "false";
        }
        if (emptyString.equals(jsonObject.get(data))) result = emptyString;
        else result = jsonObject.get(data).toString();
        return result;
    }
}

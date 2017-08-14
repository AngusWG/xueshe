package cn.huas.xueshe.service.impl;

import android.content.Context;

import org.json.JSONObject;

import java.io.IOException;
import java.util.Map;

import cn.huas.xueshe.config.configXML;
import cn.huas.xueshe.service.HttpUtils;
import cn.huas.xueshe.util.L;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by 74071 on 2017/2/11.
 */

public class HttpUtilsImpl implements HttpUtils {


    public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");
    private final OkHttpClient client = new OkHttpClient();

    public String getInfo(String URL, Context context) throws IOException {
        Request request = new Request.Builder().
                addHeader("Authorization", configXML.getToken()).
                url(URL).get().build();
        Response response = client.newCall(request).execute();
        if (response.isSuccessful()) {
            return response.body().string();
        } else {
            throw new IOException("Unexpected code " + response);
        }
    }

    @Override
    public String getInfoByParameter(String URL, Map<String, Integer> m, Context context) throws Exception {
        String realURL = URL + "?";
        for (Map.Entry<String, Integer> entry : m.entrySet()) {
            realURL += entry.getKey() + "=" + entry.getValue() + "&";
        }
        realURL = realURL.substring(0, realURL.length() - 1);

        L.e(realURL);
        System.out.println(realURL);
        Request request = new Request.Builder().
                addHeader("Authorization", configXML.getToken()).
                url(realURL).get().build();
        Response response = client.newCall(request).execute();
        if (response.isSuccessful()) {
            return response.body().string();
        } else {
            throw new IOException("Unexpected code " + response);
        }
    }

    public String doPostForm(String URL, RequestBody Body) throws Exception {
        Request request = new Request.Builder()
                .url(URL)
                .post(Body)
                .build();

        Response response = client.newCall(request).execute();
        if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);
        return response.body().string();
    }

    public JSONObject doPostJsom(String URL, JSONObject jsonObject, Context context) throws Exception {
        RequestBody body = RequestBody.create(JSON, jsonObject.toString());
        Request request = new Request.Builder()
                .addHeader("Authorization", configXML.getToken())
                .url(URL)
                .post(body)
                .build();
        Response response = client.newCall(request).execute();
        if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);
        return new JSONObject(response.body().string());

    }
}

package cn.huas.xueshe.activity;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import org.junit.Before;
import org.junit.Test;

import cn.huas.xueshe.util.L;
import okhttp3.FormBody;
import okhttp3.RequestBody;

import static cn.huas.xueshe.service.Http.doPostForm;

/**
 * Created by 74071 on 2017/3/27.
 */

public class activitySend {
    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void creatActivity() throws Exception {
        String activityCreatDate;
        String activityTitle = "33";
        String activityDescription = "";
        String activityExpectJoiner;
        String activityJoiner = "";
        String activityQq = "";
        String activityAddress = "";

        String url = "http://ip:8080/activity/addActivity";

        RequestBody body = new FormBody.Builder().
                add("activityTitle", activityTitle).
                add("activityDescription", activityDescription).
                add("activityJoiner", activityJoiner).
                add("activityQq", activityQq).
                add("activityAddress", activityAddress).
                build();
        ;
        JSONObject jsonObject = null;
        try {
            jsonObject = JSON.parseObject(doPostForm(url, body));
        } catch (Exception e) {
            L.e(e.toString());
            System.out.println("connection fall");
            e.printStackTrace();
        }

        if ("success".equals(jsonObject.get("message"))) {

            System.out.println("success");
        } else {
            System.out.println("LoginFales");
        }


    }

}

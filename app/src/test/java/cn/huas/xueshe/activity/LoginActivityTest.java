package cn.huas.xueshe.activity;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import org.junit.Before;

import cn.huas.xueshe.util.L;
import okhttp3.FormBody;
import okhttp3.RequestBody;

import static cn.huas.xueshe.config.APIAddress.LOGIN_URL;
import static cn.huas.xueshe.service.Http.doPostForm;

/**
 * Created by 74071 on 2017/3/26.
 */
public class LoginActivityTest {
    @Before
    public void setUp() throws Exception {

    }

    @org.junit.Test
    public void loginSuccess() throws Exception {
        String username = "breeze66xm";
        String password = "12345678";

        RequestBody body = new FormBody.Builder().
                add("userName", username.toString()).
                add("userPassword", password.toString()).
                build();
        ;
        JSONObject jsonObject = null;
        try {
            jsonObject = JSON.parseObject(doPostForm(LOGIN_URL, body));
        } catch (Exception e) {
            L.e(e.toString());
            System.out.println("connection fall");
            e.printStackTrace();
        }

        if ("success".equals(jsonObject.get("message"))) {

            System.out.println(jsonObject.toString());
            JSONObject jsonData = (JSONObject) jsonObject.get("data");
//            String jsonData = JsonUtils.jsonToJsonObject(jsonObject.toString(),data");
            System.out.println(jsonData);
            System.out.println(jsonData.get("access_token"));
            System.out.println("success");
        } else {
            System.out.println("fales");
        }

    }

    @org.junit.Test
    public void loginFales() throws Exception {
        String username = "breeze66xm";
        String password = "123456789";

        RequestBody body = new FormBody.Builder().
                add("userName", username.toString()).
                add("userPassword", password.toString()).
                build();
        ;
        JSONObject jsonObject = null;
        try {
            jsonObject = JSON.parseObject(doPostForm(LOGIN_URL, body));
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
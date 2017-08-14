package cn.huas.xueshe.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import org.junit.Test;

import okhttp3.FormBody;
import okhttp3.RequestBody;

import static cn.huas.xueshe.config.APIAddress.LOGIN_URL;
import static cn.huas.xueshe.config.APIAddress.REGISTER_URL;
import static cn.huas.xueshe.service.Http.doPostForm;

/**
 * Created by 74071 on 2017/3/14.
 */
public class HttpUtilsImplTest {
    //psvm
//    public static void main(String[] args) {
////        RequestBody body = new FormBody.Builder().add("")
//
//
//    }
    @Test
    public void login() throws Exception {
        RequestBody body = new FormBody.Builder().add("userName", "admin123").add("userPassword", "admin123").build();
        ;
        JSONObject jsonObject = JSON.parseObject(doPostForm(LOGIN_URL, body));
        System.out.println("Log:  " + jsonObject.get("result"));

    }

    @Test
    public void reg() throws Exception {
        RequestBody body = new FormBody.Builder().add("userName", "admin123456").add("userPassword", "admin123").build();
        JSONObject jsonObject = JSON.parseObject(doPostForm(REGISTER_URL, body));
        System.out.println("Reg:  " + jsonObject.get("result"));
    }
}
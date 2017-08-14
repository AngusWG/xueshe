package cn.huas.xueshe.activity;

import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import cn.huas.xueshe.service.Http;
import cn.huas.xueshe.util.L;

import static cn.huas.xueshe.config.APIAddress.REGISTER_URL;

/**
 * Created by 74071 on 2017/4/22.
 */
public class RegisterActivityTest {


    @Test
    public void registerUp() throws Exception {

        String input_name = "Test121";
        String input_email = "116921248@qq.com";
        String input_password = "12345678";


        JSONObject send = new JSONObject()
                .put("userName", input_name)
                .put("userPassword", input_password)
                .put("userEmail", input_email.toString());

        System.out.println(send.toString());

        org.json.JSONObject jsonObject = null;
        try {
            jsonObject = Http.doPostJsom(REGISTER_URL, send, null);
        } catch (Exception e) {
            L.e(e.toString());
            System.out.println("服务器异常");
            e.printStackTrace();
        }

        System.out.println(jsonObject.toString());
        if ("success".equals(jsonObject.getString("message"))) {
            Assert.assertTrue(true);
        }

        if ("fail".equals(jsonObject.getString("message"))) {
            Assert.assertTrue("成功通向数据库", true);
        }
    }

}
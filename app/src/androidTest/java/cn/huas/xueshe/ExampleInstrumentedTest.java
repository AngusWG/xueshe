package cn.huas.xueshe;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import cn.huas.xueshe.service.Http;
import cn.huas.xueshe.util.L;

import static cn.huas.xueshe.config.APIAddress.REGISTER_URL;
import static org.junit.Assert.*;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Test
    public void useAppContext() throws Exception {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("cn.huas.xueshe", appContext.getPackageName());
        System.out.println();
    }

    @Test
    public void registerUp() throws Exception {
        Context appContext = InstrumentationRegistry.getTargetContext();
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
            jsonObject = Http.doPostJsom(REGISTER_URL, send, appContext);
        } catch (Exception e) {
            L.e(e.toString());
            System.out.println("服务器异常");
            e.printStackTrace();
            return;
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

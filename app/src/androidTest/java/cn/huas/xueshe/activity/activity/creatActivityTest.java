package cn.huas.xueshe.activity.activity;

import android.content.Context;
import android.support.test.InstrumentationRegistry;

import com.alibaba.fastjson.JSONObject;

import org.junit.Test;

import java.sql.Date;
import java.text.SimpleDateFormat;

import cn.huas.xueshe.config.APIAddress;
import cn.huas.xueshe.service.Http;
import cn.huas.xueshe.util.L;
import cn.huas.xueshe.util.ServiceUtils;
import okhttp3.FormBody;
import okhttp3.RequestBody;

/**
 * Created by 74071 on 2017/4/23.
 */
public class creatActivityTest {
    @Test
    public void submit() {
        System.out.println("3333333333333333333333333333333");
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy年MM月dd日    HH:mm:ss     ");
        Date curDate = new Date(System.currentTimeMillis());//获取当前时间
        String date = formatter.format(curDate);

        Context appContext = InstrumentationRegistry.getTargetContext();
        String m标题edtTxt = "标题" + date;
        String m内容edtTxt = "内容" + date;
        String m期望人数edtTxt = "2";
        String m已有人数edtTxt = "1";
        String m联系QQedtTxt = "15151";
        String m地点edtTxt = "地点" + date;
        RequestBody body = new FormBody.Builder().
                add("activityTitle", m标题edtTxt).
                add("activityDescribtion", m内容edtTxt).
                add("activityExpectJoiner", m期望人数edtTxt).
                add("activityJoiner", m已有人数edtTxt).
                add("activityQq", m联系QQedtTxt).
                add("activityAddress", m地点edtTxt).
                build();

        JSONObject jsonObject = null;
        String str = "666666666666666666666";
        L.e(str);
        try {
            str = ServiceUtils.analysis(appContext, Http.doPostForm(APIAddress.ADD_ACITIVITY_URL, body));
        } catch (Exception e) {
            L.e(e.toString());
            e.printStackTrace();
            return;
        }
        System.out.println(str);
        L.e(str.toString());
    }

}
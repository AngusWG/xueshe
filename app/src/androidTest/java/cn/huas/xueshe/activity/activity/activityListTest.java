package cn.huas.xueshe.activity.activity;

import android.content.Context;
import android.support.test.InstrumentationRegistry;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import cn.huas.xueshe.bean.Activity;
import cn.huas.xueshe.config.APIAddress;
import cn.huas.xueshe.service.Http;
import cn.huas.xueshe.util.JsonUtils;
import cn.huas.xueshe.util.L;
import cn.huas.xueshe.util.ServiceUtils;

/**
 * Created by 74071 on 2017/4/22.
 */
public class activityListTest {

    @Test
    public void ad() {

        String str = getList();
        str = JsonUtils.jsonToJsonObject(str, "activity");
        String[] strArray = JsonUtils.getStringArrayJson(str);
        Activity[] listData = new Activity[strArray.length];
        for (int i = 0; i < strArray.length; i++) {
            listData[i] = (Activity) JsonUtils.getObjectJsonString(strArray[i], Activity.class);
            L.e(listData[i].toString());
        }

    }

    //    @Test
    public String getList() {
        Context appContext = InstrumentationRegistry.getTargetContext();
        String str = "no data";
        Map<String, Integer> m = new HashMap<String, Integer>();
        m.put("pageNum", 1);
        m.put("pageSize", 8);
        try {
            str = ServiceUtils.analysis(appContext, Http.getInfoByParameter(APIAddress.GETACTIVITYLIST, m, appContext));
            ;
        } catch (Exception e) {
            L.e(e.toString());
            e.printStackTrace();
//            Assert.fail();
            return str;
        }
        return str;
    }

}
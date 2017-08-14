package cn.huas.xueshe.activity.activity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.huas.xueshe.R;
import cn.huas.xueshe.bean.Activity;
import cn.huas.xueshe.config.APIAddress;
import cn.huas.xueshe.service.Http;
import cn.huas.xueshe.util.JsonUtils;
import cn.huas.xueshe.util.L;
import cn.huas.xueshe.util.ServiceUtils;

import static cn.huas.xueshe.config.APIAddress.userInfo;

/**
 * An example full-screen activityList that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class activityList extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        setContentView(R.layout.activity_common_list);
        String string = getListString(1, 8, this);
        Activity[] list = activityStringToList(string);
        SimpleAdapter simpleAdapter = bindsimpleAdapter(list);


        ListView listView = (ListView) findViewById(R.id.activity_ListView);
        listView.setAdapter(simpleAdapter);
        listView.isShown();
    }

    private SimpleAdapter bindsimpleAdapter(Activity[] list) {
        List<Map<String, Object>> ListItems =
                new ArrayList<Map<String, Object>>();
        for (int i = 0; i < list.length; i++) {
            Map<String, Object> ListItem = new HashMap<String, Object>();
//            ListItem.put("header", imaegIds[i]);

            ListItem.put("tvTitle", list[i].getActivityTitle());
            ListItem.put("desc", list[i].getActivityDescribtion());
            ListItem.put("joiner", list[i].getActivityJoiner());
            ListItem.put("interest", list[i].getActivityInterest());
//            ListItem.put(,list[i].)
            ListItems.add(ListItem);
        }
        L.e("SimpleAdapter:" + list[3].toString());

        SimpleAdapter simpleAdapter = new SimpleAdapter(this, ListItems, R.layout.activity_activity_post_item, new String[]{"tvTitle", "header", "desc"}, new int[]{
                R.id.tvTitle, R.id.header, R.id.desc
        });


        return simpleAdapter;
    }

    @SuppressLint("NewApi")
    private Activity[] activityStringToList(String str) {
        str = JsonUtils.jsonToJsonObject(str, "activity");
        String[] strArray = JsonUtils.getStringArrayJson(str);
        Activity[] listData = new Activity[strArray.length];
        for (int i = 0; i < strArray.length; i++) {
            listData[i] = (Activity) JsonUtils.getObjectJsonString(strArray[i], Activity.class);
        }
        L.e(this.getLocalClassName() + listData[3].toString());
        return listData;
    }

    public static String getListString(int pageNum, int pageSize, Context context) {
        String str = "no data";
        Map<String, Integer> m = new HashMap<String, Integer>();
        m.put("pageNum", pageNum);
        m.put("pageSize", pageSize);
        try {
            str = ServiceUtils.analysis(context, Http.getInfoByParameter(APIAddress.GETACTIVITYLIST, m, context));
        } catch (Exception e) {
            L.e(e.toString());
            e.printStackTrace();
            return "error";
        }
        return str;
    }


    public void doGet(View view) {
        String str;
        try {
            Http.getInfo(userInfo("10"), getApplicationContext());

        } catch (IOException e) {
//            L.e(e.toString());
            e.printStackTrace();
//            str = "error";
        }
//        Toast.makeText(this,str,Toast.LENGTH_LONG).show();
    }

    public void toActivityInfo(View view) {
        Intent intent = new Intent(activityList.this, activityInfo.class);
        startActivity(intent);
    }

    public void finish(View view) {
        this.finish();
    }

    public void CreatActivity(View view) {
        Intent intent = new Intent(activityList.this, creatActivity.class);
        startActivity(intent);
    }


}


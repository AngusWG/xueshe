package cn.huas.xueshe.activity.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import java.io.IOException;

import cn.huas.xueshe.R;
import cn.huas.xueshe.bean.Activity;
import cn.huas.xueshe.config.APIAddress;
import cn.huas.xueshe.service.Http;
import cn.huas.xueshe.util.L;
import cn.huas.xueshe.util.ServiceUtils;

import static cn.huas.xueshe.util.JsonUtils.getObjectJsonString;

public class activityInfo extends AppCompatActivity {


    private TextView m标题;
    private TextView m描述;
    private TextView m开始时间edtTxt;
    private TextView m结束时间edtTxt;
    private TextView m期望人数edtTxt;
    private TextView m已有人数edtTxt;
    private TextView m联系电话edtTxt;
    private TextView m联系QQedtTxt;
    private TextView m地点edtTxt;
    private ListView mActList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_info);
        Intent getIntent = getIntent();
        String Id = getIntent.getStringExtra("Id");
        bindViews();
        Activity act = getActivityBy(Id);
        putToUI(act);
        loadReply(Id);
    }

    // End Of Content View Elements
    private void bindViews() {
        m标题 = (TextView) findViewById(R.id.标题);
        m描述 = (TextView) findViewById(R.id.描述);
        m开始时间edtTxt = (TextView) findViewById(R.id.开始时间edtTxt);
        m结束时间edtTxt = (TextView) findViewById(R.id.结束时间edtTxt);
        m期望人数edtTxt = (TextView) findViewById(R.id.期望人数edtTxt);
        m已有人数edtTxt = (TextView) findViewById(R.id.已有人数edtTxt);
        m联系电话edtTxt = (TextView) findViewById(R.id.联系电话edtTxt);
        m联系QQedtTxt = (TextView) findViewById(R.id.联系QQedtTxt);
        m地点edtTxt = (TextView) findViewById(R.id.地点edtTxt);
        mActList = (ListView) findViewById(R.id.actList);
    }


    private void loadReply(String id) {
    }

    private void putToUI(Activity act) {
        m标题.setText(act.getActivityTitle());
        m描述.setText(act.getActivityDescribtion());
//        m开始时间edtTxt.setText(act.getActivityCreatDate());


    }


    private Activity getActivityBy(String id) {
        //GetJavaBean
        String result = "";

        try {
            result = ServiceUtils.analysis(this, Http.getInfo(APIAddress.GETACTIVITY(id), getApplicationContext()));
        } catch (IOException e) {
            L.e(e.getMessage());
            e.printStackTrace();
        }

        return (Activity) getObjectJsonString(result, Activity.class);
    }

    public void like(View view) {
    }

    public void join(View view) {
    }
}

package cn.huas.xueshe.activity;

import android.annotation.SuppressLint;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;

import cn.huas.xueshe.R;
import cn.huas.xueshe.bean.User;
import cn.huas.xueshe.service.Http;
import cn.huas.xueshe.util.JsonUtils;
import cn.huas.xueshe.util.L;
import cn.huas.xueshe.util.ServiceUtils;

import static cn.huas.xueshe.config.APIAddress.userInfo;
import static cn.huas.xueshe.util.JsonUtils.getObjectJsonString;

public class UserInfo extends AppCompatActivity {

    User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        setContentView(R.layout.activity_user_info);
        Intent getIntent = getIntent();
        if (getIntent != null) {
            String userId = getIntent.getStringExtra("userId");
            L.e(this.getLocalClassName() + " userID:" + getIntent.getStringExtra("userId"));
            getInformation(userId);
        } else L.e(this.getLocalClassName() + "Null userID.");
    }

    @SuppressLint("NewApi")
    public void getInformation(String id) {
        ImageView head = (ImageView) findViewById(R.id.info_head);
        TextView Name = (TextView) findViewById(R.id.info_name);
        TextView Email = (TextView) findViewById(R.id.info_Email);
        TextView QQnum = (TextView) findViewById(R.id.info_QQnum);

        String str = "";
        try {
            str = ServiceUtils.analysis(this, Http.getInfo(userInfo(id), getApplicationContext()));
        } catch (IOException e) {
            L.e(e.getMessage());
            e.printStackTrace();
        }

        str = JsonUtils.jsonToJsonObject(str, "userInfo");
        L.e(getLocalClassName() + " " + str);
        if (str == "false") return;

        System.out.println(str);
        user = (User) getObjectJsonString(str, User.class);
        Name.setText(user.getUserName());
        Email.setText("邮箱:" + user.getUserEmail());
        QQnum.setText("QQ号:" + user.getUserQq());
    }

    public void getQQnum(View view) {
        ClipboardManager clipboardManager = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
        clipboardManager.setPrimaryClip(ClipData.newPlainText(null, user.getUserQq()));
        // 将内容set到剪贴板
        Toast.makeText(this, "已复制到剪贴板", Toast.LENGTH_SHORT);
    }

    public void getEmail(View view) {
        ClipboardManager clipboardManager = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
        clipboardManager.setPrimaryClip(ClipData.newPlainText(null, user.getUserEmail()));
        // 将内容set到剪贴板
        Toast.makeText(this, "已复制到剪贴板", Toast.LENGTH_SHORT);
    }
}


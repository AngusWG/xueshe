package cn.huas.xueshe.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import cn.huas.xueshe.R;
import cn.huas.xueshe.config.APIAddress;
import cn.huas.xueshe.config.configXML;
import cn.huas.xueshe.service.Http;
import cn.huas.xueshe.util.L;
import okhttp3.FormBody;
import okhttp3.RequestBody;


public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        setContentView(R.layout.activity_user_login);
    }

    @SuppressLint("NewApi")
    public void login(View v) {
        EditText username = (EditText) findViewById(R.id.input_email);
        EditText password = (EditText) findViewById(R.id.input_password);

        username.setText("breeze66xm");
        password.setText("12345678");

        RequestBody body = new FormBody.Builder().
                add("userName", username.getText().toString()).
                add("userPassword", password.getText().toString()).
//                add("userPassword", StringUtils.Md5(password.getText().toString())).
        build();
        ;
        L.e(this.getLocalClassName() + " " + body.toString());
        JSONObject jsonObject = null;
        try {
            jsonObject = JSON.parseObject(Http.doPostForm(APIAddress.LOGIN_URL, body));
        } catch (Exception e) {
            L.e(e.toString());
            Toast.makeText(getApplicationContext(), "服务器异常" + e.toString(), Toast.LENGTH_LONG).show();
            e.printStackTrace();
            return;
        }


        L.e(this.getLocalClassName() + jsonObject.toString());
        if ("success".equals(jsonObject.getString("message"))) {
            saveTokenAndId(jsonObject.getString("data"));
            Toast.makeText(getApplicationContext(), "登录成功", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(intent);
            this.finish();
            return;
        }

        L.e(jsonObject.toString());
        Toast.makeText(getApplicationContext(), "登录失败" + "\n" + jsonObject.getString("message"), Toast.LENGTH_LONG).show();


    }

    private void saveTokenAndId(String data) {
        JSONObject jsonObject = JSON.parseObject(data);
        L.e(jsonObject.toString());
        configXML.setToken(jsonObject.getString("access_token"), jsonObject.getString("userId"));
    }

    public void toRegisterActivity(View view) {
        Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
        startActivity(intent);
        this.finish();
    }


}


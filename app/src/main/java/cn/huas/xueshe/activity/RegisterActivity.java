package cn.huas.xueshe.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import cn.huas.xueshe.R;
import cn.huas.xueshe.config.APIAddress;
import cn.huas.xueshe.service.Http;
import cn.huas.xueshe.util.L;

;


public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        setContentView(R.layout.activity_user_register);
    }

    @SuppressLint("NewApi")
    public void registerUp(View view) throws JSONException {
        EditText input_email = (EditText) findViewById(R.id.input_email);
        EditText input_name = (EditText) findViewById(R.id.input_name);
        EditText input_password = (EditText) findViewById(R.id.input_password);


        JSONObject send = new JSONObject()
                .put("userName", input_name.getText().toString())
                .put("userPassword", input_password.getText().toString())
                .put("userEmail", input_email.getText().toString());

        L.e(this.getClass().toString() + "  " + send.toString());
        JSONObject result = null;
        try {
            result = Http.doPostJsom(APIAddress.REGISTER_URL, send, this);
        } catch (Exception e) {
            L.e(e.toString());
            e.printStackTrace();
            Toast.makeText(RegisterActivity.this, "服务器异常", Toast.LENGTH_SHORT).show();
            return;
        }

        if ("success".equals(result.getString("message"))) {
            Toast.makeText(RegisterActivity.this, "注册功", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
            startActivity(intent);
            this.finish();
            return;
        }

        L.e(this.getClass().toString() + "  " + result.toString());
        Toast.makeText(RegisterActivity.this, "注册失败" + "\n" + result.getString("message"), Toast.LENGTH_SHORT).show();
        return;
    }

    public void toLoginaActivity(View view) {
        Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
        startActivity(intent);
        this.finish();
    }

}

package cn.huas.xueshe.activity.activity;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.icu.util.Calendar;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import com.alibaba.fastjson.JSONObject;

import cn.huas.xueshe.R;
import cn.huas.xueshe.config.APIAddress;
import cn.huas.xueshe.service.Http;
import cn.huas.xueshe.util.L;
import cn.huas.xueshe.util.ServiceUtils;
import okhttp3.FormBody;
import okhttp3.RequestBody;

public class creatActivity extends AppCompatActivity {

    private EditText m标题edtTxt;
    private EditText m内容edtTxt;
    private EditText m期望人数edtTxt;
    private EditText m已有人数edtTxt;
    private EditText m联系电话edtTxt;
    private EditText m联系QQedtTxt;
    private EditText m开始时间edtTxt;
    private EditText m结束时间edtTxt;
    private EditText m地点edtTxt;
    private Button m提交btn;

    int mYear, mMonth, mDay;
    final int DATE_DIALOG = 1;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_create);

        m标题edtTxt = (EditText) findViewById(R.id.标题edtTxt);
        m内容edtTxt = (EditText) findViewById(R.id.内容edtTxt);
        m期望人数edtTxt = (EditText) findViewById(R.id.期望人数edtTxt);
        m已有人数edtTxt = (EditText) findViewById(R.id.已有人数edtTxt);
        m联系电话edtTxt = (EditText) findViewById(R.id.联系电话edtTxt);
        m联系QQedtTxt = (EditText) findViewById(R.id.联系QQedtTxt);
        m开始时间edtTxt = (EditText) findViewById(R.id.开始时间edtTxt);
        m结束时间edtTxt = (EditText) findViewById(R.id.结束时间edtTxt);
        m地点edtTxt = (EditText) findViewById(R.id.地点edtTxt);
        m提交btn = (Button) findViewById(R.id.提交btn);

        final Calendar ca = Calendar.getInstance();
        mYear = ca.get(Calendar.YEAR);
        mMonth = ca.get(Calendar.MONTH);
        mDay = ca.get(Calendar.DAY_OF_MONTH);
    }


    public void selectDate(View view) {
        showDialog(DATE_DIALOG);
    }

    protected Dialog onCreateDialog(int id) {
        switch (id) {
            case DATE_DIALOG:
                return new DatePickerDialog(this, mdateListener, mYear, mMonth, mDay);
        }
        return null;
    }

    private DatePickerDialog.OnDateSetListener mdateListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
            mYear = year;
            mMonth = monthOfYear;
            mDay = dayOfMonth;
            m开始时间edtTxt.setText(new StringBuffer().append(mYear).append("-").append(mMonth + 1).append("-").append(mDay).append(" "));
        }
    };

    public void Submit(View view) {
        RequestBody body = new FormBody.Builder().
                add("activityTitle", m标题edtTxt.getText().toString()).
                add("activityDescribtion", m内容edtTxt.getText().toString()).
                add("activityExpectJoiner", m期望人数edtTxt.getText().toString()).
                add("activityJoiner", m已有人数edtTxt.getText().toString()).
                add("activityQq", m联系QQedtTxt.getText().toString()).
                add("activityAddress", m地点edtTxt.getText().toString()).
                build();

        JSONObject jsonObject = null;
        String str = "";
        try {
            str = ServiceUtils.analysis(this, Http.doPostForm(APIAddress.ADD_ACITIVITY_URL, body));
        } catch (Exception e) {
            L.e(e.toString());
            Toast.makeText(getApplicationContext(), "服务器异常", Toast.LENGTH_LONG).show();
            e.printStackTrace();
            return;
        }

        L.e(str);


    }

}
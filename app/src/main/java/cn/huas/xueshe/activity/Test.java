package cn.huas.xueshe.activity;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.icu.util.Calendar;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.DatePicker;
import android.widget.TextView;

import cn.huas.xueshe.R;

public class Test extends AppCompatActivity {
    private CalendarView calendarView;

    int mYear, mMonth, mDay;
    Button btn;
    TextView dateDisplay;
    final int DATE_DIALOG = 1;


    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        btn = (Button) findViewById(R.id.dateChoose);
        dateDisplay = (TextView) findViewById(R.id.dateDisplay);

        btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                showDialog(DATE_DIALOG);
            }
        });

        final Calendar ca = Calendar.getInstance();
        mYear = ca.get(Calendar.YEAR);
        mMonth = ca.get(Calendar.MONTH);
        mDay = ca.get(Calendar.DAY_OF_MONTH);
    }

    @Override
    protected Dialog onCreateDialog(int id) {
        switch (id) {
            case DATE_DIALOG:
                return new DatePickerDialog(this, mdateListener, mYear, mMonth, mDay);
        }
        return null;
    }

    /**
     * 设置日期 利用StringBuffer追加
     */
    public void display() {
        dateDisplay.setText(new StringBuffer().append(mMonth + 1).append("-").append(mDay).append("-").append(mYear).append(" "));
    }

    private DatePickerDialog.OnDateSetListener mdateListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
            mYear = year;
            mMonth = monthOfYear;
            mDay = dayOfMonth;
            display();
        }
    };


}
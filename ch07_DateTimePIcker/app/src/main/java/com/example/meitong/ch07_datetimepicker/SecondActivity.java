package com.example.meitong.ch07_datetimepicker;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import java.util.Calendar;

public class SecondActivity extends Activity {
    private Button button;
    private TextView textView;
    private int year;
    private int month;
    private int dayOfMonth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        button = findViewById(R.id.button);
        textView = findViewById(R.id.textView);
        Calendar myCalendar = Calendar.getInstance();
        year = myCalendar.get(Calendar.YEAR);
        month = myCalendar.get(Calendar.MONTH);
        dayOfMonth = myCalendar.get(Calendar.DAY_OF_MONTH);

        DatePicker datePicker = findViewById(R.id.datepicker);
        datePicker.init(year, month, dayOfMonth, new myOnDateChangedListener());
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(SecondActivity.this, ThirdActivity.class);
                startActivity(intent);
            }
        });
    }

    class myOnDateChangedListener implements DatePicker.OnDateChangedListener {

        @Override
        public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
             textView.setText("您选择的日期是：" + year + "/" + monthOfYear + "/" + dayOfMonth);
        }
    }

}

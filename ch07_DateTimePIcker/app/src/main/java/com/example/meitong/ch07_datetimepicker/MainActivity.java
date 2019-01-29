package com.example.meitong.ch07_datetimepicker;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, DatePickerDialog.OnDateSetListener, TimePickerDialog.OnTimeSetListener{
    Calendar c = Calendar.getInstance();
    TextView txDate;
    TextView txTime;
    private int year;
    private int month;
    private int dayOfMonth;
    private int hour;
    private int minute;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //初始化变量
        txDate = findViewById(R.id.date);
        txTime = findViewById(R.id.time);
        button = findViewById(R.id.btn);

        Calendar myCalendar = Calendar.getInstance();
        year = myCalendar.get(Calendar.YEAR);
        month = myCalendar.get(Calendar.MONTH);
        dayOfMonth = myCalendar.get(Calendar.DAY_OF_MONTH);
        hour = myCalendar.get(Calendar.HOUR_OF_DAY);
        minute = myCalendar.get(Calendar.MINUTE);

        //给文本添加点击监听者
        txDate.setOnClickListener(this);

        txTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TimePickerDialog tpd;
                tpd = new TimePickerDialog(MainActivity.this, MainActivity.this, hour, minute, false);
                tpd.show();
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, SecondActivity.class);
                startActivity(intent);
            }
        });

    }

    @Override
    public void onClick(View v) {
        DatePickerDialog dpd;
        dpd = new DatePickerDialog(this,this, year, month, dayOfMonth);
        dpd.show();
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        txDate.setText(year + "／" + (month+1) + "/" + dayOfMonth);

    }


    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        txTime.setText(hourOfDay + ":" + minute);
    }
}




package com.example.meitong.ch07_datetimepicker;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.TimePicker;

public class ThirdActivity extends AppCompatActivity {
private TimePicker timePicker;
private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        textView = findViewById(R.id.textView);
        timePicker = findViewById(R.id.timepicker);
        timePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
                 textView.setText(hourOfDay + ":" + minute);
            }
        });
    }
}

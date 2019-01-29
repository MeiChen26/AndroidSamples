package com.example.meitong.vibrate;

import android.content.Context;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnTouchListener {
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.txv);
        textView.setOnTouchListener(this);
    }

    public boolean onTouch(View v, MotionEvent e) {
        Vibrator vb = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        if (e.getAction() == MotionEvent.ACTION_DOWN)
            vb.vibrate(5000);
        else if (e.getAction() == MotionEvent.ACTION_UP)
            vb.cancel();
        return true;
    }
}

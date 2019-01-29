package com.example.meitong.ch10_touchevent;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private LinearLayout touchView;
    private TextView labelView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        touchView = findViewById(R.id.touchview);
        labelView = findViewById(R.id.labelview);
        touchView.setOnTouchListener(new View.OnTouchListener(){
            @Override
            public boolean onTouch(View v, MotionEvent event){
                switch(event.getAction()) {
//                    case (MotionEvent.ACTION_DOWN):
//                            Display("ACTION_DOWN", event);
//                        break;
//                    case(MotionEvent.ACTION_UP):
//                            Display("ACTION_UP", event);
//                        break;
                    case(MotionEvent.ACTION_MOVE):
                            Display("ACTION_MOVE", event);
                                    break;
                }
                return true;

            }
        });
    }

    private void Display(String eventType, MotionEvent event){
        int x = (int)event.getX();
        int y = (int)event.getY();
        float pressure = event.getPressure();
        int RawX = (int)event.getRawX();
        int RawY = (int)event.getRawY();
        float size = event.getSize();
        String msg = "";
        msg += "相对坐标" + String.valueOf(x) + "," + String.valueOf(y) + "\n";
        msg += "绝对坐标" + String.valueOf(RawX) + "," + String.valueOf(RawY) + "\n";
    msg += "触点压力" + String.valueOf(pressure) + "\n";
    msg += "触点尺寸" + String.valueOf(size) + String.valueOf(size) + "\n";
    labelView.setText(msg);
    }
}

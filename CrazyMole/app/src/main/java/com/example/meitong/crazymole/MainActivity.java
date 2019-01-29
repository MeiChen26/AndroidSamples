package com.example.meitong.crazymole;

import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private int count = 0;
    private int time = 6000;
    private ImageView mouse = null;
    private Thread thread = null;
    private boolean normal = true;
    private Handler handler;
    private TextView timeText = null;
//    private int[][]position = new int[][]{{250, 1095},
//            {550, 1115}, {521, 740}, {255, 420}, {-35, 760}, {262, 760}};
    private int[][]position = new int[][]{{271, 760}, {521, 740},{766, 771},
    {238, 1152}, {505,1166}, {798, 1124}, {216, 1545}, {519, 1564}, {815,1574}};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mouse = findViewById(R.id.ms);
        timeText = findViewById(R.id.textView);
        mouse.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                v.setVisibility(View.INVISIBLE);
                count++;
                Toast.makeText(MainActivity.this,"打到" + count +"只地鼠", Toast.LENGTH_SHORT).show();
               return false;
            }
        });

        handler = new Handler(){
            public void handleMessage(Message msg){
                int index = 0;
                if(time > 0 && normal == true){
                    if(msg.what == 0x101){
                        timeText.setText("剩余时间为：" + time/1000);
                        index = msg.arg1;
                        mouse.setX(position[index][0]);
                        mouse.setY(position[index][1]);
                        mouse.setVisibility(View.VISIBLE);
                    }
                    super.handleMessage(msg);

                }
                else if(normal == true)
                    gameOver();
            }
        };

        thread = new MyThread();
        thread.start();

    }

    public void gameOver(){
        timeText.setText("时间到");
        handler.removeCallbacks(thread);
        thread = null;
        new AlertDialog.Builder(MainActivity.this).setTitle("游戏结束").setMessage("您一共打到"
        + count + "只地鼠").setNegativeButton("再来一局", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                thread = new MyThread();
                time = 6000;
                count = 0;
                thread.start();
            }
        }).setNeutralButton("退出", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                MainActivity.this.finish();
            }
        }).create().show();
    }

    public class MyThread extends Thread{
        public void run(){
            super.run();
            int index = 0;
            while(!Thread.currentThread().isInterrupted()){
                index = new Random().nextInt(position.length);

                Message m = handler.obtainMessage();
                m.what = 0x101;
//                if(index == 6)
//                    index = 0;
                m.arg1 = index;
                handler.sendMessage(m);
                if(time > 0 && normal == true){
                    try {
                        Thread.sleep(new Random().nextInt(500) + 1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    time = time - 100;
                }
                else{
                    thread.interrupt();
                }
            }
        }
    }
}

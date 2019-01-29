package com.example.meitong.handler;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

        ImageView imgchange;
        //定义切换的图片的数组id
//        int imgids[] = new int[]{R.drawable.move1, R.drawable.move2, R.drawable.move3, R.drawable.move4,R.drawable.move5, R.drawable.move6,
//                      R.drawable.move7,R.drawable.move9, R.drawable.move10, R.drawable.move12};
        int imgids[] = new int[]{R.drawable.chengdu, R.drawable.chengdu1, R.drawable.chengdu2};

        int imgstart = 0;

        Handler myHandler = new Handler()
        {
            @Override
            //重写handleMessage方法,根据msg中what的值判断是否执行后续操作
            public void handleMessage(Message msg) {
                if(msg.what == 0x123)
                {
                    imgchange.setImageResource(imgids[imgstart++ % imgids.length]);
                }
            }
        };


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            imgchange = (ImageView) findViewById(R.id.imgchange);
            new Thread(new Runnable(){
                @Override
                public void run() {
                    while(!Thread.currentThread().isInterrupted()) {

                        myHandler.sendEmptyMessage(0x123);
                        try {
                            Thread.sleep(3000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }).start();


        }

    }


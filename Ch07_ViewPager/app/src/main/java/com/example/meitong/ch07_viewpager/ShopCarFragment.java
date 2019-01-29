package com.example.meitong.ch07_viewpager;


import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


/**
 * A simple {@link Fragment} subclass.
 */
public class ShopCarFragment extends Fragment {

    ImageView imgchange;
    //定义切换的图片的数组id
        int imgids[] = new int[]{R.drawable.move1, R.drawable.move2, R.drawable.move3, R.drawable.move4,R.drawable.move5, R.drawable.move6,
                      R.drawable.move7,R.drawable.move9, R.drawable.move10, R.drawable.move12};
    //int imgids[] = new int[]{R.drawable.chengdu, R.drawable.chengdu1, R.drawable.chengdu2};

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

    public ShopCarFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View view = inflater.inflate(R.layout.fragment_shop_car, container, false);

        imgchange = view.findViewById(R.id.imgchange);
        new Thread(new Runnable(){
            @Override
            public void run() {
                while(!Thread.currentThread().isInterrupted()) {

                    myHandler.sendEmptyMessage(0x123);
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    return view;

    }

}

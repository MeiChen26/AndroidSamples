package com.example.meitong.banner;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;
import com.youth.banner.Banner;
import com.youth.banner.Transformer;

import java.util.Arrays;


public class MainActivity extends AppCompatActivity {

    private Banner banner;
    //设置图片资源:url或本地资源
    String[] images= new String[] {
            "http://218.192.170.132/BS80.jpg",
            "http://img.zcool.cn/community/0166c756e1427432f875520f7cc838.jpg",
            "http://img.zcool.cn/community/018fdb56e1428632f875520f7b67cb.jpg",
            "http://img.zcool.cn/community/01c8dc56e1428e6ac72531cbaa5f2c.jpg",
            "http://img.zcool.cn/community/01fda356640b706ac725b2c8b99b08.jpg",
            "http://img.zcool.cn/community/01fd2756e142716ac72531cbf8bbbf.jpg",
            "http://img.zcool.cn/community/0114a856640b6d32f87545731c076a.jpg"};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Banner banner = (Banner) findViewById(R.id.banner);
        ImageView mImageView = findViewById(R.id.iv);
        //设置图片加载器
        banner.setImageLoader(new GlideImageLoader());
        //设置图片集合
        banner.setImages(Arrays.asList(images));

//        //设置banner动画效果
      banner.setBannerAnimation(Transformer.DepthPage);
//        //设置自动轮播，默认为true
//        banner.isAutoPlay(true);
//        //设置轮播时间
//        banner.setDelayTime(1500);
//        //banner设置方法全部调用完毕时最后调用
        banner.start();

        Picasso.with(this)
                .load("http://ww3.sinaimg.cn/large/610dc034jw1fasakfvqe1j20u00mhgn2.jpg")
                .into(mImageView);

    }
}

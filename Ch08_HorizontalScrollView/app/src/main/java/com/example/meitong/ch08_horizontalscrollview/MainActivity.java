package com.example.meitong.ch08_horizontalscrollview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    private LinearLayout mGallery;
    private int[] mImgIds;
    private LayoutInflater mInflater;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mInflater = LayoutInflater.from(this);
        initData();
        initView();
    }
    private void initData(){
        mImgIds = new int[]{R.drawable.a, R.drawable.b, R.drawable.c, R.drawable.d};
    }
    private void initView(){
        mGallery = findViewById(R.id.id_gallery);
        for(int i = 0; i < mImgIds.length; i++){
            View view = mInflater.inflate(R.layout.activity_index_gallery_item, mGallery, false);
            ImageView img = view.findViewById(R.id.id_index_gallery_item_image);
            img.setImageResource(mImgIds[i]);

            mGallery.addView(view);
        }
    }
}

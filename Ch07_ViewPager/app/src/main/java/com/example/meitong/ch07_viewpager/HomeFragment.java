package com.example.meitong.ch07_viewpager;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.youth.banner.Banner;
import com.youth.banner.Transformer;

import java.util.Arrays;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

   Integer[] images= new Integer[] {
     R.drawable.chengdu,
           R.drawable.chengdu1,
           R.drawable.chengdu2

    };

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        GridView gridView = view.findViewById(R.id.gv);
        GridViewAdapter adapter = new GridViewAdapter(HomeFragment.this.getActivity());
        gridView.setAdapter(adapter);


        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch(position){
                    case 0:
                        Intent it = new Intent();
                        it.setClass(getActivity(), FriendActivity.class);
                        startActivity(it);
                }

                Toast.makeText(HomeFragment.this.getActivity(), "1", Toast.LENGTH_LONG).show();
            }
        });





        Banner banner = view.findViewById(R.id.banner);
        //设置图片加载器
        banner.setImageLoader(new GlideImageLoader());
        //设置图片集合
        banner.setImages(Arrays.asList(images));

//        //设置banner动画效果
        banner.setBannerAnimation(Transformer.DepthPage);
//        //设置自动轮播，默认为true
//        banner.isAutoPlay(true);
//        //设置轮播时间
        banner.setDelayTime(4000);
//        //banner设置方法全部调用完毕时最后调用
        banner.start();

        return view;

    }

}

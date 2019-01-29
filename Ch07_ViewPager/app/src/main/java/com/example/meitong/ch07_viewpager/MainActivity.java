package com.example.meitong.ch07_viewpager;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ViewPager main_viewPager;
    private RadioGroup main_tab_RadioGroup;
    private RadioButton radio_home, radio_shopcar, radio_sort, radio_me, radio_search;
    private ArrayList<Fragment> fragmentList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        InitViewPager();
        InitView();

    }

    public void InitView(){
        main_tab_RadioGroup = (RadioGroup) findViewById(R.id.main_tab_RadioGroup) ;
        radio_home = (RadioButton) findViewById(R.id.radio_home) ;
        radio_shopcar = (RadioButton) findViewById(R.id.radio_shopcar) ;
        radio_sort = (RadioButton) findViewById(R.id.radio_sort) ;
        radio_search = (RadioButton) findViewById(R.id.radio_search) ;
        radio_me = (RadioButton) findViewById(R.id.radio_me) ;

        //点选单选按钮实现切换页面
        main_tab_RadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

                        @Override
                        public void onCheckedChanged(RadioGroup radioGroup, int i) {
                            int current = 0;
                            switch(i) {
                                case R.id.radio_home:
                                    current = 0;
                                    break;
                                case R.id.radio_shopcar:
                        current = 1;
                        break;
                    case R.id.radio_sort:
                        current = 2;
                        break;
                    case R.id.radio_search:
                        current = 3;
                        break;
                    case R.id.radio_me:
                        current = 4;
                        break;
                }
                main_viewPager.setCurrentItem(current);

            }
        });
    }


    public void InitViewPager()

    {
        main_viewPager = (ViewPager) findViewById(R.id.main_ViewPager);

        fragmentList = new ArrayList<Fragment>();

        Fragment homeFragment = new HomeFragment();
        Fragment sortFragment = new SortFragment();
        Fragment shopCarFragment = new ShopCarFragment();
        Fragment searchFragment = new SearchFragment();
        Fragment meFragment = new MeFragment();

        fragmentList.add(homeFragment);
        fragmentList.add(shopCarFragment);
        fragmentList.add(sortFragment);
        fragmentList.add(searchFragment);
        fragmentList.add(meFragment);

        main_viewPager.setAdapter(new MyAdapter(getSupportFragmentManager(), fragmentList));

        main_viewPager.setCurrentItem(0);

    }

    public class MyAdapter extends FragmentPagerAdapter {

        ArrayList<Fragment> list;
        public MyAdapter(FragmentManager fm, ArrayList<Fragment> list){
            super(fm);
            this.list = list;
        }

        @Override
        public Fragment getItem(int position) {
            return list.get(position);
        }

        @Override
        public int getCount() {
            return list.size();
        }
    }
}

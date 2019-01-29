package com.example.meitong.ch06_listview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    String[] queArr = {"什么门永远关不上", "什么东西没人爱吃", "什么布切不断", "偷什么不犯法", "什么瓜不能吃"};
    String[] ansArr = {"球门", "吃亏", "瀑布", "偷笑", "傻瓜"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = findViewById(R.id.lv);
        //创建ArrayAdapter
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_checked, queArr);
        //为ListView对象设置Adapter
        listView.setAdapter(adapter);
    }
}

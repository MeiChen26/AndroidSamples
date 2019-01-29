package com.example.meitong.ch07_memo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.Date;

public class MainActivity extends AppCompatActivity {

    private final String[] memo =
               {"1. 单击可以编辑备忘", "2. 长按可以清除备忘", "3. ", "4. ", "5. "
            , "6. "};                       //默认的备忘内容
    private ListView listView;      //显示备忘录的listview
    ArrayAdapter<String> adapter;   //ListView与备忘数据memo的桥梁

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.lv);
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, memo);
        listView.setAdapter(adapter);       //设置listView的内容

        //设置listView被单击的监听器
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Intent it = new Intent(MainActivity.this, EditActivity.class);

                it.putExtra("编号", position + 1);
                it.putExtra("备忘", memo[position]);
                it.putExtra("日期", new Date().toString());

                // startActivity(it);   //启动editActivity活动
                startActivityForResult(it, position);
            }
        });

        //设置list被长按的监听器
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                memo[position] = (position + 1) + ".";    //将内容清除只剩编号
                adapter.notifyDataSetChanged();           //通知ListView要更新显示的内容
                return true;
            }
        });
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent it){
        if(resultCode == RESULT_OK)
        {
            memo[requestCode] = it.getStringExtra("备忘");
            adapter.notifyDataSetChanged();
            Toast.makeText(this, "备忘于" +
                    it.getStringExtra("日期"),
                    Toast.LENGTH_LONG).show();
        }
    }
}

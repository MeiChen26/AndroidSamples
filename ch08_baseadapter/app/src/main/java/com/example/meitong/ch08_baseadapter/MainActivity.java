package com.example.meitong.ch08_baseadapter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {
    private ListView listview;
    private LinkedList<User> userData;
    DataService db = new DataService();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listview = findViewById(R.id.lv);
        //配置adapter适配器
        userData = db.getUserData();
        MyAdapter adapter = new MyAdapter(userData, this);
        listview.setAdapter(adapter);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this,
                        "position: " + listview.getSelectedItem(), Toast.LENGTH_LONG).show();
            }
        });

        String[] arr = {"我的好友"};
        ListView listView1 = findViewById(R.id.lv1);
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arr);
        listView1.setAdapter(adapter1);
    }
}

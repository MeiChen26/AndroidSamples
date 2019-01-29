package com.example.meitong.lifecycle;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button=findViewById(R.id.btn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();

                intent.putExtra("intent_string","string");
                intent.putExtra("intent_integer",100);
                Data data=new Data();
                data.id=1;
                data.name="android";
                intent.putExtra("intent_object",data);

                intent.setClass(MainActivity.this,SecondActivity.class);
                startActivity(intent);
            }
        });

        Log.e("Life cycle test", "MainActivity at onCreate()");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.e("Life cycle test", "MainActivity at onRestart()");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e("Life cycle test", "MainActivity at onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e("Life cycle test", "MainActivity at onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e("Life cycle test", "MainActivity at onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e("Life cycle test", "MainActivity at onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e("Life cycle test", "MainActivity at onDestroy()");
    }
}

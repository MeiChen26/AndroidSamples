package com.example.meitong.ch01_firstapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView txv;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button=findViewById(R.id.btn);
        txv = findViewById(R.id.txv);
    }
    int size = 30;

    public void bigger(View v){

        txv.setTextSize(++size);
    }
}

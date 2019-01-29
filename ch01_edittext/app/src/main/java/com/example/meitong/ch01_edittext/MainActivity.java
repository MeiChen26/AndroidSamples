package com.example.meitong.ch01_edittext;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    EditText name;
    TextView txv;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = findViewById(R.id.name);
        txv = findViewById(R.id.txt);
        btn = findViewById(R.id.button);
        btn.setOnClickListener(this);
    }

    public void sayHi(View v){
        String str = name.getText().toString().trim();
        if(str.length() == 0)
            txv.setText("请输入姓名");
        else
            txv.setText(name.getText().toString()+",您好！");
    }

    @Override
    public void onClick(View v) {

        }
}

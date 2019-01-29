package com.example.meitong.ch03_linearlayout;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText lname,fname,phone;
    TextView txv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lname=findViewById(R.id.lastname);
        fname=findViewById(R.id.firstname);
        phone=findViewById(R.id.phone);
        txv=findViewById(R.id.textview4);
    }

    public void display(View v){
        txv.setText(lname.getText().toString()+fname.getText()+"的电话是"+phone.getText());
    }

}

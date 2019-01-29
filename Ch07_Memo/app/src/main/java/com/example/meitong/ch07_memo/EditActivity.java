package com.example.meitong.ch07_memo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Date;

public class EditActivity extends AppCompatActivity {

    TextView txv;
    EditText edt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        Intent intent = getIntent();    //获取传入的intent对象
        int no = intent.getIntExtra("编号", 0);   //读出名为"编号"的INT数据，若没有则返回0
        String str = intent.getStringExtra("备忘");          //读出名为"备忘"的String数据

        txv = findViewById(R.id.tv);
        txv.setText(no + ".");           //在画面左上角显示编号

        edt = findViewById(R.id.edittext);
        if(str.length() >= 3)
            edt.setText(str.substring(3) +
                    intent.getStringExtra("日期")); //将传来的备忘数据去除前三个字符，填入EditText组件中

        Button btn = findViewById(R.id.button);
        Button btn2 = findViewById(R.id.button2);

        //单击取消按钮
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(RESULT_CANCELED);
                finish();
            }
        });

        //单击存储按钮
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = getIntent();
                intent2.putExtra("备忘", txv.getText().toString() + edt.getText().toString());
                intent2.putExtra("日期", new Date().toString());
                setResult(RESULT_OK, intent2);
                finish();
            }
        });
    }


}

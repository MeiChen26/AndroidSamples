package com.example.meitong.ch07_implicitintent;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button button1, button2, button3, button4, button5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button1 = findViewById(R.id.button);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        button5 = findViewById(R.id.button5);

        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);



    }

    @Override
    public void onClick(View v) {
        Intent it = new Intent ();
        it.setAction(Intent.ACTION_VIEW);

        switch(v.getId()){
            case R.id.button:
                it.setData(Uri.parse("mailto:service@flag.com.tw"));
                it.putExtra(Intent.EXTRA_CC,new String[]{"test@flag.com.tw"});
                startActivity(it);
                break;
            case R.id.button2:
                it.setData(Uri.parse("sms:0999-123456?body=hello"));
                startActivity(it);
                break;
            case R.id.button3:
                it.setData(Uri.parse("http://sina.cn/?from=wap"));
                startActivity(it);
                break;
            case R.id.button4:
               it.setData(Uri.parse("geo:39.896068,116.151147"));
                startActivity(it);
                break;
            case R.id.button5:
                // 打开拍照程序
                Intent intent1 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent1, 0);
                // 取出照片数据

                startActivityForResult(intent1, 100);
                break;
        }
        //startActivity(it);
    }
    protected void onActivityResult(int requestCode, int resultCode, Intent intent){
        super.onActivityResult(requestCode, resultCode, intent);
        if(resultCode == Activity.RESULT_OK && requestCode == 100){
            Bundle extras = intent.getExtras();
            Bitmap bitmap = (Bitmap) extras.get("data");
            ImageView imageView = findViewById(R.id.iv);
            imageView.setImageBitmap(bitmap);
        }
    }
}

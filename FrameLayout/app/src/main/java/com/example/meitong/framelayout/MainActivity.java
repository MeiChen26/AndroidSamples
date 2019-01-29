package com.example.meitong.framelayout;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    private Button btn1;
    private Button btn2;
    private LinearLayout viewA;
    private LinearLayout viewB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1=findViewById(R.id.button1);
        btn2=findViewById(R.id.button2);
        viewA=findViewById(R.id.frameA);
        viewB=findViewById(R.id.frameB);


        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewA.setVisibility(View.GONE);
                viewB.setVisibility(View.VISIBLE);
            }
        });
    }


}

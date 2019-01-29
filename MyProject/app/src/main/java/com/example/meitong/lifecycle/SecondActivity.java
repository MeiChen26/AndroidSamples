package com.example.meitong.lifecycle;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends Activity {

    private Button btn;
    private TextView txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        btn=findViewById(R.id.button);
        txt=findViewById(R.id.textresult);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();
            }
        });

        String intentString=getIntent().getStringExtra("intent_string");
        int intentInteger= getIntent().getExtras().getInt("intent_integer");
        Data data=(Data)getIntent().getExtras().get("intent_object");

        StringBuffer sb=new StringBuffer();
        sb.append("string");
        sb.append(intentString);
        sb.append("\n");
        sb.append("integer");
        sb.append(intentInteger);
        sb.append("\n");
        sb.append(data.id);
        sb.append(data.name);
        txt.setText(sb.toString());
        Log.e("Life cycle test", "SecondActivity at onCreate()");


    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e("Life cycle test", "SecondActivity at onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e("Life cycle test", "SecondActivity at onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e("Life cycle test", "SecondActivity at onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e("Life cycle test", "SecondActivity at onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e("Life cycle test", "SecondActivity at onDestroy()");
    }
}

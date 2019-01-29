package com.example.meitong.ch13_hellowebview;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    WebView wv;
    EditText keyText;
    String keyword;
    String baseURL ="https://www.baidu.com/s?wd=";
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        wv = findViewById(R.id.wv);
        keyText = findViewById(R.id.editText);
        button= findViewById(R.id.button);

        wv.getSettings().setJavaScriptEnabled(true);
        wv.setWebViewClient(new WebViewClient());

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                keyword = keyText.getText().toString().replaceAll("\\s+", "+");
                wv.loadUrl(baseURL + keyword);
            }
        });
    }

    @Override
    protected void onPause(){
        super.onPause();
        SharedPreferences.Editor editor = getPreferences(MODE_PRIVATE).edit();
        editor.putString("关键字", keyword);
        editor.commit();
    }

    @Override
    protected void onResume(){
        super.onResume();
        SharedPreferences myPref = getPreferences(MODE_PRIVATE);
        keyword = myPref.getString("关键字", "Taipei101");
        if(wv.getUrl() == null)
            wv.loadUrl(baseURL + keyword);
    }

}

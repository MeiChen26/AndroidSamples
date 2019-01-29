package com.example.meitong.sharedpreferences;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    private EditText userName, passWord;
    private CheckBox box;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userName = (EditText) findViewById(R.id.et_username);
        passWord = (EditText) findViewById(R.id.et_password);
        box = (CheckBox) findViewById(R.id.cb_remerber);

        load();
    }

    // 点击登陆，写入账户密码的方法
    @SuppressLint("ShowToast")
    public void login(View v) {
        String name = userName.getText().toString();
        String pwd = passWord.getText().toString();

        // 判断是否有勾选记住密码
        if (box.isChecked()) {
            /*
             * getSharedPreferences(),第一个参数是生成info.xml文件，第二是是访问权限
             * 生成路径/data/data/包名/share_perfs/info.xml
             */
            //取得SharedPreferences对象
            SharedPreferences sp = getSharedPreferences("info", MODE_PRIVATE);
            // 取得编辑器
            SharedPreferences.Editor et = sp.edit();
            // 传入数据,参数的意思是 (key,value)看待会生成的info.xml就明白了
            et.putString("NAME", name);
            et.putString("PWD", pwd);
            // 提交数据
            et.commit();
            Toast.makeText(this, "登陆成功",  Toast.LENGTH_LONG).show();

        } else {
            Toast.makeText(this, "登陆成功", Toast.LENGTH_LONG).show();
        }
    }

    // 加载账户密码的方法
    public void load() {
        //取得SharedPreferences对象
        SharedPreferences sp = getSharedPreferences("info", MODE_PRIVATE);
        /*
         * getString,参数意义表示用key=第一个参数去取值，如果取不到值，就返回第二个参数
         * 因为有了第二个参数，所以我们也不需要判断是否存在info文件
         * */
        String nameString = sp.getString("NAME", "");
        String pwdString = sp.getString("PWD", "");

        userName.setText(nameString);
        passWord.setText(pwdString);
    }

}

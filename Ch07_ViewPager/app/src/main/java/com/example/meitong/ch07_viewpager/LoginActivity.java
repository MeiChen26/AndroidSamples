package com.example.meitong.ch07_viewpager;

import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    static final String DB_NAME = "MyDB";
    static final String TB_NAME = "user_table";
    private SQLiteDatabase db;

    private Button btInsert, btSearch;
    private EditText nameEdt, passwordEdt;
    private Cursor cur;

    AlertDialog alert;
    AlertDialog.Builder builder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btInsert = findViewById(R.id.sign_in_button); //注册按钮
        btSearch = findViewById(R.id.log_in_button); //登录按钮
        nameEdt = findViewById(R.id.user);        //用户名编辑框
        passwordEdt = findViewById(R.id.password); //密码编辑框

        db = openOrCreateDatabase(DB_NAME, Context.MODE_PRIVATE, null);//创建数据库
        String createTable = "CREATE TABLE IF NOT EXISTS "
                + TB_NAME
                + "(_id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "name VARCHAR(32), "
                + "password VARCHAR(32))";
        db.execSQL(createTable); //执行sql语句

        btInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nameStr = nameEdt.getText().toString().trim();
                String passwordStr = passwordEdt.getText().toString().trim();
                if (nameStr.length() == 0 || passwordStr.length() == 0)
                    Toast.makeText(LoginActivity.this, "请输入正确的信息", Toast.LENGTH_LONG).show();
                else
                    addData(nameStr, passwordStr);
            }
        });

        btSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nameStr = nameEdt.getText().toString().trim();
                String passwordStr = passwordEdt.getText().toString().trim();
                if (nameStr.length() == 0 || passwordStr.length() == 0)
                    Toast.makeText(LoginActivity.this, "请输入正确的信息", Toast.LENGTH_LONG).show();
                else {
                    queryData(passwordStr, nameStr);

                }
            }
        });
    }
        private void addData(String name, String password){
            ContentValues cv = new ContentValues(2);
            cv.put("name", name);
            cv.put("password", password);

            db.insert(TB_NAME, null, cv);
        }

        private void queryData(String passwordStr, String nameStr){
            cur = db.rawQuery("SELECT * FROM " + TB_NAME + " where name = "+ "'" + nameStr + "'", null);
            if(cur.moveToFirst()) {
                if (passwordStr.equals(cur.getString(cur.getColumnIndex("password")))) {
                    Toast.makeText( LoginActivity.this, "登陆成功", Toast.LENGTH_LONG).show();
AlertDialog alert;
AlertDialog.Builder builder;
                    builder = new AlertDialog.Builder(this);

                    alert = builder.setTitle("登录成功：")
                            .setMessage("这是一个最普通的AlertDialog,\n带有2个按钮，分别是取消，确定")
                            .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    Toast.makeText(LoginActivity.this, "你点击了取消按钮~", Toast.LENGTH_SHORT).show();
                                }
                            })
                            .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    Intent it = new Intent(LoginActivity.this, MainActivity.class);
                                    startActivity(it);
                                }
                            }).create();

                    alert.show();
//
                }
                else{

                }

            }
        }
    }


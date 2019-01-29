package com.example.meitong.ch15_myhotline;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    static final String DB_NAME = "HotlineDB";
    static final String TB_NAME = "user_table";
    SQLiteDatabase db;
    Button btInsert, btSearch;
    EditText nameEdt, passwordEdt;
    Cursor cur;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btInsert= findViewById(R.id.sign_in_button);
        btSearch = findViewById(R.id.log_in_button);
        nameEdt = findViewById(R.id.user);
        passwordEdt = findViewById(R.id.password);

        db = openOrCreateDatabase(DB_NAME, Context.MODE_PRIVATE, null);
        String createTable = "CREATE TABLE IF NOT EXISTS "
                + TB_NAME
                + "(_id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "name VARCHAR(32), "
                + "password VARCHAR(32))";
        db.execSQL(createTable);

        btInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nameStr = nameEdt.getText().toString().trim();
                String passwordStr = passwordEdt.getText().toString().trim();
                if(nameStr.length() == 0 || passwordStr.length() == 0)
                    Toast.makeText(LoginActivity.this, "请输入正确的信息", Toast.LENGTH_LONG).show();
                else {
                    addData(nameStr, passwordStr);
                    Toast.makeText(LoginActivity.this, "注册成功", Toast.LENGTH_LONG).show();
                }
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
                    queryData(passwordStr);
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

    private void queryData(String passwordStr){
        cur = db.rawQuery("SELECT * FROM " + TB_NAME, null);
        if(cur.moveToFirst()) {
            if (passwordStr.equals(cur.getString(cur.getColumnIndex("password"))))
                Toast.makeText(LoginActivity.this, "登陆成功", Toast.LENGTH_LONG).show();
        }
    }

}


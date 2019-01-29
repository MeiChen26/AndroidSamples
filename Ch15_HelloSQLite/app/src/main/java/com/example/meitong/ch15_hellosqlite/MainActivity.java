package com.example.meitong.ch15_hellosqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    static final String db_name = "testDB";
    static final String tb_name = "test";
    SQLiteDatabase db;
    StringBuffer buffer = new StringBuffer();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView txv = findViewById(R.id.tv);

        db = openOrCreateDatabase(db_name, Context.MODE_PRIVATE, null);
        String createTable = "CREATE TABLE IF NOT EXISTS " + tb_name + "(name VARCHAR(32), " +
                "phone VARCHAR(16), " + "email VARCHAR(64))";
        db.execSQL(createTable);

//        addData("Flag bv Co", "0417", "service@flag.com.tw");
//        addData("Magazin", "2321121", "service@pcdy.com.tw");

        //txv.setText("数据库文件路径:" + db.getPath() + "\n");
        Cursor c = db.rawQuery("SELECT * FROM " + tb_name, null);
      if(c.moveToFirst()){

          do{
              buffer.append("name:");
              buffer.append(c.getString(0));
              buffer.append("\n");
              buffer.append("phone:");
              buffer.append(c.getString(1));
              buffer.append("\n");
              buffer.append("email:");
              buffer.append(c.getString(2));
              buffer.append("\n");
              buffer.append("--------");
              buffer.append("\n");
          }
          while(c.moveToNext());

      }

      txv.setText(buffer.toString());

        db.close();
    }

    private void addData(String name, String phone, String email){
        ContentValues cv = new ContentValues(3);
        cv.put("name", name);
        cv.put("phone", phone);
        cv.put("email", email);
        db.insert(tb_name, null, cv);

    }
}

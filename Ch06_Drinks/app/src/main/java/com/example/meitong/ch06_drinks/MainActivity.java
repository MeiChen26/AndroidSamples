package com.example.meitong.ch06_drinks;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private final int index = 1;
    private Spinner drinks, temp;
    private TextView textView;
    private Button button;
    final String[] temp1 = {"冰", "去冰", "温"};
    final String[] temp2 = {"冰", "去冰"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
      textView = findViewById(R.id.txv);
      temp = findViewById(R.id.temp);
      drinks = findViewById(R.id.drink);
      button = findViewById(R.id.btn);
        drinks.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String[] tempset;
                if(position == index)
                    tempset = temp2;
                else
                    tempset = temp1;
                ArrayAdapter<String> tempadapter = new ArrayAdapter<String>(MainActivity.this, R.layout.support_simple_spinner_dropdown_item, tempset);
                temp.setAdapter(tempadapter);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String msg = drinks.getSelectedItem() + "，" + temp.getSelectedItem();
            textView.setText(msg);
            }
        });
    }
}

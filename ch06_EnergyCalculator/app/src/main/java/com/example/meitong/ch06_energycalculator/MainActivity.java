package com.example.meitong.ch06_energycalculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    final double[] energyRate={3.1, 4.4, 13.2, 9.7, 5.1};
    final int[] timeArray = {1, 2, 3, 4, 5};
    EditText weightTxt, timeTxt;
    TextView total, txvRate;
    Spinner sports;
    Spinner timeSpinner;
    Button button;
    double time;
    String str;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        weightTxt = findViewById(R.id.weight);
        total = findViewById(R.id.total);
        txvRate = findViewById(R.id.txvRate);
        sports = findViewById(R.id.spinner);
        button =findViewById(R.id.btn);
        timeSpinner = findViewById(R.id.spinner2);

        sports.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                txvRate.setText(String.valueOf(energyRate[position]));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });




       timeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
           @Override
           public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
               time = timeArray[position];
               String[] result = getResources().getStringArray(R.array.timeSpan);
               str = result[position];
           }

           @Override
           public void onNothingSelected(AdapterView<?> parent) {

           }
       });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String weightText = weightTxt.getText().toString();
                double weight;

                if(weightText.length() > 0){
                    weight = Double.parseDouble(weightTxt.getText().toString());
                    int selected = sports.getSelectedItemPosition();
                    long totalEnergy = Math.round(energyRate[selected] * weight * time);
                    total.setText("运动" + str + "消耗能量：" + totalEnergy +"千卡");
                }
                else total.setText("请输入您的体重");

            }
        });
    }
}

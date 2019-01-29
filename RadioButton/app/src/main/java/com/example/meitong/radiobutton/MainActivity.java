package com.example.meitong.radiobutton;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity{
    private TextView txv;
    private TextView txv2;
    private RadioGroup ticketType;
    private RadioGroup seatType;
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txv = findViewById(R.id.txv);
        txv2 = findViewById(R.id.txv2);
        btn = findViewById(R.id.button);
        ticketType = findViewById(R.id.ticketType);
        seatType = findViewById(R.id.seatType);

        //设置按钮的事件监听
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id = ticketType.getCheckedRadioButtonId();
                RadioButton select = findViewById(id);
                txv.setText("买" + select.getText());

            }
        });

        ticketType.setOnCheckedChangeListener(
                new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group,
                                         int checkedId) {
                RadioButton radioButton = findViewById(checkedId);
                txv.setText(radioButton.getText());


            }
        });

        seatType.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton radioButton = findViewById(checkedId);
                String str =radioButton.getText().toString();
                txv2.setText(str);
                Toast txt = Toast.makeText(MainActivity.this,
                        str, Toast.LENGTH_LONG);

                txt.show();
            }
        });
    }
}

package com.example.meitong.ch06_checkbox;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity{
    private ArrayList<CompoundButton> selected = new ArrayList<>();
    private Button button;
    private TextView showview;
    private CheckBox checkbox;
    private ImageView imageview;

    private final int[] chk_id = {R.id.chk1, R.id.chk2, R.id.chk3, R.id.chk4};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showview = findViewById(R.id.showOrder);
        checkbox = findViewById(R.id.chk1);
        button = findViewById(R.id.button);
        imageview = findViewById(R.id.o1);

        checkbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                StringBuffer msg = new StringBuffer();
                if(isChecked){
                    msg.append("您点购的餐是：");
                    msg.append(checkbox.getText());
                    imageview.setVisibility(View.VISIBLE);
                    showview.setText(msg.toString());
                }
                else{
                    msg.append("您点购的餐是：");
                    imageview.setVisibility(View.GONE);
                    showview.setText(msg.toString());
                }

            }
        });

    }


}

package com.example.meitong.ch06_tempconversion;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

/*
实现OncheckedChangeListener接口，TextWatcher接口
 */
public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener,
        TextWatcher{
    //声明变量
    private RadioGroup unit;
    private EditText value;

    //app启动时先调用onCreate方法
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //初始化变量
        unit = findViewById(R.id.unit);
        //设置监听者
        unit.setOnCheckedChangeListener(this);
        value = findViewById(R.id.value);
        value.addTextChangedListener(this);
    }

    //重写TextWatcher接口中的方法
    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }//文本框有输入之前被调用

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }//在文字刚变动完成时


    @Override
    public void afterTextChanged(Editable s) {
        calc();
        //调用calc()方法
    }//在文字变动完成后被调用的方法


    //重写OnCheckedChangeListener中的方法
    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {

        calc();  //调用calc()方法
    }

    protected void calc(){
        //初始化变量
        TextView degF = findViewById(R.id.degF);
        TextView degC = findViewById(R.id.degC);
        TextView degK = findViewById(R.id.degK);
        double f, c, k;

        if(unit.getCheckedRadioButtonId() == R.id.unitF){
            f = Double.parseDouble(value.getText().toString());
            c = (f-32)*5/9;  //如果选中的是华氏度，转换为摄氏度
            k = c + 273.15;
        }
        else if(unit.getCheckedRadioButtonId() == R.id.unitC){
            c =Double.parseDouble(value.getText().toString());
            f = c*9/5+32;   //默认选中的是摄氏度，转换为华氏度
            k = c +273.15;
        }else{
            k = Double.parseDouble(value.getText().toString());
            c = k - 273.15;
            f = c * 9 / 5 + 32;
        }
        degF.setText(String.format("%.1f", f) + getResources().getString(R.string.charF));
        degC.setText(String.format("%.1f", c) + getResources().getString(R.string.charC)); //找到资源res文件夹下，string资源类中，变量名为charC的变量值
        degK.setText(String.format("%.2f", k) + "K");
    }
}


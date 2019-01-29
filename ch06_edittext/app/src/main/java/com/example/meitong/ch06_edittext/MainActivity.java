package com.example.meitong.ch06_edittext;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.MultiAutoCompleteTextView;

public class MainActivity extends AppCompatActivity{
   private AutoCompleteTextView atv;
   private MultiAutoCompleteTextView matv;
   private EditText edittext;

   @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edittext = findViewById(R.id.editText);
        atv = findViewById(R.id.autoCompleteTextView);
        matv = findViewById(R.id.multiAutoCompleteTextView);



        String []items = {"Baiyunshan",
                "Beijing", "Bengbu", "Baicheng"};

        ArrayAdapter<String> adapter =
                new ArrayAdapter<String> (this,
                        R.layout.support_simple_spinner_dropdown_item,
                        items);

 atv.setAdapter(adapter);

        String []items2 = {"张馨予", "张艺兴","张歆艺", "张杰", "张大大"};

       ArrayAdapter<String> adapter2 = new ArrayAdapter<>(this,
               R.layout.support_simple_spinner_dropdown_item, items2);

        atv.setAdapter(adapter);

        matv.setAdapter(adapter);
        matv.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());

        edittext.addTextChangedListener(new TextWatcher() {











            private String oldText;
            private final String[] filters = {"NND", "TMD"};

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                oldText = edittext.getText().toString();
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                String newText = edittext.getText().toString();


                if(oldText.equals(newText))
                    return;
                for(String filter: filters){
                    if(newText.indexOf(filter) != -1){
                  newText = "**";

                    }
                }
                edittext.setText(newText);
                edittext.invalidate();
                edittext.setSelection(newText.length());
            }
        });
    }

}

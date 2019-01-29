package neusoft.soft.coffeestore.view;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import neusoft.soft.coffeestore.bean.People;
import neusoft.soft.coffeestore.db.DBAdapter;


public class MyAccountActivity extends Activity {
    private EditText nameText;
    private EditText ageText;
    private EditText heightText;
    private EditText idEntry;

    private TextView labelView;
    private TextView displayView;
    private DBAdapter dbUtil;
    private Button btnBack;
    private TextView tvTitle;
    private LinearLayout exit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        setTheme(R.style.CustomTheme);
        requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_account);
        //设置顶部文字及返回信息
        getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.titlebar);
        btnBack = (Button) findViewById(R.id.btn_first);
        tvTitle = (TextView) findViewById(R.id.tv_title);
        btnBack.setBackgroundResource(R.drawable.img_back);
        tvTitle.setText("个人信息");
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent intent = new Intent(MyAccountActivity.this, MainActivity.class);
//                startActivity(intent);
//                overridePendingTransition(R.anim.back_out, R.anim.back_in);
                finish();
            }
        });
        exit= (LinearLayout) findViewById(R.id.exit);
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        //输入框
        nameText = (EditText) findViewById(R.id.name);
        ageText = (EditText) findViewById(R.id.age);
        heightText = (EditText) findViewById(R.id.height);
        idEntry = (EditText) findViewById(R.id.id_entry);

        labelView = (TextView) findViewById(R.id.label);
        displayView = (TextView) findViewById(R.id.display);

        Button addButton = (Button) findViewById(R.id.add);
        Button queryAllButton = (Button) findViewById(R.id.query_all);
        Button clearButton = (Button) findViewById(R.id.clear);
        Button deleteAllButton = (Button) findViewById(R.id.delete_all);

        Button queryButton = (Button) findViewById(R.id.query);
        Button deleteButton = (Button) findViewById(R.id.delete);
        Button updateButton = (Button) findViewById(R.id.update);

        addButton.setOnClickListener(addButtonListener);
        queryAllButton.setOnClickListener(queryAllButtonListener);
        clearButton.setOnClickListener(clearButtonListener);
        deleteAllButton.setOnClickListener(deleteAllButtonListener);

        queryButton.setOnClickListener(queryButtonListener);
        deleteButton.setOnClickListener(deleteButtonListener);
        updateButton.setOnClickListener(updateButtonListener);

        dbUtil = new DBAdapter(this);
        dbUtil.open();
    }
    View.OnClickListener addButtonListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            People people = new People();
            people.Name = nameText.getText().toString();
            people.Age = Double.parseDouble(ageText.getText().toString());
            people.Height = Float.parseFloat(heightText.getText().toString());
            long colunm = dbUtil.insert(people);
            if (colunm == -1) {
                labelView.setText("添加过程错误！");
            } else {
                labelView.setText("成功添加数据，ID：" + String.valueOf(colunm));

            }
        }
    };
    View.OnClickListener queryAllButtonListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            People[] peoples = dbUtil.queryAllData();
            if (peoples == null) {
                labelView.setText("数据库中没有数据");
                return;
            }
            labelView.setText("数据库数据为：");
            String msg = "";
            for (int i = 0; i < peoples.length; i++) {
                msg += peoples[i].toString() + "\n";
            }
            displayView.setText(msg);
        }
    };

    View.OnClickListener clearButtonListener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            displayView.setText("");
        }
    };

    View.OnClickListener deleteAllButtonListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            dbUtil.deleteAllData();
            String msg = "数据全部删除";
            labelView.setText(msg);
        }
    };

    View.OnClickListener queryButtonListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            int id = Integer.parseInt(idEntry.getText().toString());
            People[] peoples = dbUtil.queryOneData(id);
            nameText.setText(peoples[0].Name);
            ageText.setText(String.valueOf(peoples[0].Age));
            heightText.setText(String.valueOf(peoples[0].Height));

            if (peoples == null) {
                labelView.setText("数据库中没有ID为" + String.valueOf(id) + "的数据");
                return;
            }
            labelView.setText("数据库数据为：");
            displayView.setText(peoples[0].toString());
        }
    };

    View.OnClickListener deleteButtonListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            long id = Integer.parseInt(idEntry.getText().toString());
            long result = dbUtil.deleteOneData(id);
            String msg = "已删除ID为" + idEntry.getText().toString() +
                    "的数据" + (result > 0 ? "成功" : "失败");
            labelView.setText(msg);
        }
    };

    View.OnClickListener updateButtonListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            People people = new People();
            people.Name = nameText.getText().toString();
            people.Age = Integer.parseInt(ageText.getText().toString());
            people.Height = Float.parseFloat(heightText.getText().toString());
            long id = Integer.parseInt(idEntry.getText().toString());
            long count = dbUtil.updateOneData(id, people);
            if (count == -1) {
                labelView.setText("更新错误！");
            } else {
                labelView.setText("更新成功，更新数据" + String.valueOf(count) + "条");

            }
        }
    };
}

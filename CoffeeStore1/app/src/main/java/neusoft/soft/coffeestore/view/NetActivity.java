package neusoft.soft.coffeestore.view;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import neusoft.soft.coffeestore.asyncTask.GoodsTask;


public class NetActivity extends Activity {
    private String path = "http://10.0.3.2:8080/eshop/goods/newGoodsForMobile.action";
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_net);
        listView = (ListView) findViewById(R.id.listView1);
        new GoodsTask(this, listView).execute(path);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                String item = (String) listView.getItemAtPosition(position).toString();
                Toast.makeText(getApplicationContext(), item, Toast.LENGTH_LONG).show();
            }
        });
    }
}

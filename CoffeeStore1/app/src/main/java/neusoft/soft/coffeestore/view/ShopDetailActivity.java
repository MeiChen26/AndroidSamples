package neusoft.soft.coffeestore.view;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import neusoft.soft.coffeestore.bean.Shop;
public class ShopDetailActivity extends Activity {
private TextView txtInfo;
private Shop shop;
private ImageView img;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_shop_detail);
		txtInfo=(TextView)findViewById(R.id.txtdetail);
		img=(ImageView)findViewById(R.id.image);
		Intent intent=this.getIntent();		
        shop=(Shop)intent.getSerializableExtra("shop");	
        txtInfo.setTextColor(Color.RED);
        txtInfo.setTextSize(20);
		txtInfo.setText("店铺名称："+shop.getShop_name()+"\n"
				+"店铺地址"+shop.getShop_address()+"\n"+
				"店铺电话："+shop.getTel());
		int picId=getResources().getIdentifier(shop.getImg_name(), "drawable" , ShopDetailActivity.this.getPackageName());
		img.setBackgroundResource(picId);
	}

	

}

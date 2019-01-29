package net.adheringsoft.coffeeonline.viewflow;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;

import neusoft.soft.coffeestore.view.R;

public class DetailActivity extends Activity {

	private ImageView imageView;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_detail);
		imageView = (ImageView)findViewById(R.id.iv_detailImage);
		
		Bundle extras = getIntent().getExtras();
		imageView.setImageResource(extras.getInt("image_id"));
	}

}

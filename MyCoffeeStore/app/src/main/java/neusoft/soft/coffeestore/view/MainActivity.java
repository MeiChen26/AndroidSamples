package neusoft.soft.coffeestore.view;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;

import java.util.ArrayList;

import neusoft.soft.coffeestore.fragment.HomeFragment;
import neusoft.soft.coffeestore.fragment.MeFragment;
import neusoft.soft.coffeestore.fragment.SearchFragment;
import neusoft.soft.coffeestore.fragment.ShopCarFragment;
import neusoft.soft.coffeestore.fragment.SortFragment;
public class MainActivity extends FragmentActivity implements OnCheckedChangeListener {

	//ViewPager???
		private ViewPager main_viewPager ;
		//RadioGroup???
		private RadioGroup main_tab_RadioGroup ;
		//RadioButton???
		private RadioButton radio_home , radio_shopcar ,
		radio_sort , radio_me,radio_search ;
		//
		private ArrayList<Fragment> fragmentList ;
		@Override
		public void onCreate(Bundle savedInstanceState)
		{
			super.onCreate(savedInstanceState);
			setContentView(R.layout.activity_main);

			InitView();

			InitViewPager();

		}
		
		public void InitView()
		{
			main_tab_RadioGroup = (RadioGroup) findViewById(R.id.main_tab_RadioGroup) ;
			
			radio_home = (RadioButton) findViewById(R.id.radio_home) ;
			radio_shopcar = (RadioButton) findViewById(R.id.radio_shopcar) ;
			radio_sort = (RadioButton) findViewById(R.id.radio_sort) ;
			radio_search = (RadioButton) findViewById(R.id.radio_search) ;
			radio_me = (RadioButton) findViewById(R.id.radio_me) ;
			
			main_tab_RadioGroup.setOnCheckedChangeListener(this);
		}
		
		public void InitViewPager()
		{
			main_viewPager = (ViewPager) findViewById(R.id.main_ViewPager);
			
			fragmentList = new ArrayList<Fragment>() ;
			
			Fragment homeFragment = new HomeFragment() ;
			Fragment sortFragment = new SortFragment();
			Fragment shopCarFragment = new ShopCarFragment();
			Fragment searchFragment=new SearchFragment();
			Fragment meFragment = new MeFragment();
			

			fragmentList.add(homeFragment);			
			fragmentList.add(shopCarFragment);
			fragmentList.add(sortFragment);
			fragmentList.add(searchFragment);
			fragmentList.add(meFragment);
			

			
			main_viewPager.setAdapter(new MyAdapter(getSupportFragmentManager() , fragmentList));

			main_viewPager.setCurrentItem(0);

			main_viewPager.setOnPageChangeListener(new MyListner());
		
		}
		
		
		
		public class MyAdapter extends FragmentPagerAdapter
		{
			ArrayList<Fragment> list ;
			public MyAdapter(FragmentManager fm , ArrayList<Fragment> list)
			{
				super(fm);
				this.list = list ;
			}
			@Override
			public Fragment getItem(int arg0) {
				return list.get(arg0);
			}
			@Override
			public int getCount() {
				return list.size();
			}
		}

		
		public class MyListner implements OnPageChangeListener
		{

			@Override
			public void onPageScrollStateChanged(int arg0) {
				
			}

			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
				
			}

			@Override
			public void onPageSelected(int arg0) {
				//
				int current = main_viewPager.getCurrentItem() ;
				switch(current)
				{
				case 0:
					main_tab_RadioGroup.check(R.id.radio_home);
					break;
				case 1:
					main_tab_RadioGroup.check(R.id.radio_shopcar);
					break;
				case 2:
					main_tab_RadioGroup.check(R.id.radio_sort);
					break;
				case 3:
					main_tab_RadioGroup.check(R.id.radio_search);
					break;
				case 4:
					main_tab_RadioGroup.check(R.id.radio_me);
					break;
				}
			}
			
		}


	@Override
	public void onCheckedChanged(RadioGroup radioGroup, int checkId) {


		int current=0;
		switch(checkId)
		{
		case R.id.radio_home:
			current = 0 ;
			break ;
		case R.id.radio_shopcar:
			current = 1 ;
			break;
		case R.id.radio_sort:
			current = 2 ;
			break;
		case R.id.radio_search:
			current = 3 ;
			break ;
		case R.id.radio_me:
			current = 4 ;
			break ;
		}
		if(main_viewPager.getCurrentItem() != current)
		{
			main_viewPager.setCurrentItem(current);
		}
		
	}

	

}

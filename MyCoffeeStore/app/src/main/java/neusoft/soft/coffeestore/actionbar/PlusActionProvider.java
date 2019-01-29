package neusoft.soft.coffeestore.actionbar;
import neusoft.soft.coffeestore.view.R;
import android.content.Context;
import android.view.ActionProvider;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.SubMenu;
import android.view.View;
import android.widget.Toast;

public class PlusActionProvider extends ActionProvider
{
	
	public PlusActionProvider(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
		this.context=context;
	}

	private Context context ;

	
	@Override
	public View onCreateActionView() {
		return null;
	}
	
	@Override
	public void onPrepareSubMenu(SubMenu submenu)
	{
		submenu.clear();
		//?????????????????????????
		submenu.add("???????").setIcon(R.drawable.action_group_chat).
		setOnMenuItemClickListener(new OnMenuItemClickListener() 
		{
			
			@Override
			public boolean onMenuItemClick(MenuItem arg0) {
				Toast.makeText(context, "???????????????????", 5000)
				.show();
				return true;
			}
		});
		
		submenu.add("???????").setIcon(R.drawable.action_add_contacts).setOnMenuItemClickListener(new OnMenuItemClickListener() {
			
			@Override
			public boolean onMenuItemClick(MenuItem arg0) {
				Toast.makeText(context, "???????????????????", 5000).show();
				return true;
			}
		});
		
		submenu.add("???").setIcon(R.drawable.action_scan_qr_code).setOnMenuItemClickListener(new OnMenuItemClickListener() {
			
			@Override
			public boolean onMenuItemClick(MenuItem arg0) {
				Toast.makeText(context, "????????????????", 5000).show();
				return true;
			}
		});
		
		submenu.add("???????").setIcon(R.drawable.action_feedback).setOnMenuItemClickListener(new OnMenuItemClickListener() {
			
			@Override
			public boolean onMenuItemClick(MenuItem arg0) {
				Toast.makeText(context, "????????????????????", 5000).show();
				return true;
			}
		});
		
	}
	
	@Override
	public boolean hasSubMenu()
	{
		return true;
	}
	
}
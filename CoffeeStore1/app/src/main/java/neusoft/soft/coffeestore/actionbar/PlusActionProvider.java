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

	public void onPrepareSubMenu(SubMenu submenu)
	{

		/**
		 增加子菜单并设置点击事件监听器
		 */
		submenu.clear();
		submenu.add("发起群聊").setIcon(R.drawable.action_group_chat).
		setOnMenuItemClickListener(new OnMenuItemClickListener() 
		{
			
			@Override
			public boolean onMenuItemClick(MenuItem arg0) {
				Toast.makeText(context, "������ˡ�����Ⱥ�ġ�ѡ��", Toast.LENGTH_LONG)
				.show();
				return true;
			}
		});
		
		submenu.add("�������").setIcon(R.drawable.action_add_contacts).setOnMenuItemClickListener(new OnMenuItemClickListener() {
			
			@Override
			public boolean onMenuItemClick(MenuItem arg0) {
				Toast.makeText(context, "������ˡ�������ѡ�ѡ��", 5000).show();
				return true;
			}
		});
		
		submenu.add("ɨһɨ").setIcon(R.drawable.action_scan_qr_code).setOnMenuItemClickListener(new OnMenuItemClickListener() {
			
			@Override
			public boolean onMenuItemClick(MenuItem arg0) {
				Toast.makeText(context, "������ˡ�ɨһɨ��ѡ��", 5000).show();
				return true;
			}
		});
		
		submenu.add("�������").setIcon(R.drawable.action_feedback).setOnMenuItemClickListener(new OnMenuItemClickListener() {
			
			@Override
			public boolean onMenuItemClick(MenuItem arg0) {
				Toast.makeText(context, "������ˡ����������ѡ��", 5000).show();
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
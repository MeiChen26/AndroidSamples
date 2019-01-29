package neusoft.soft.coffeestore.fragment;

import java.util.ArrayList;
import java.util.HashMap;

import neusoft.soft.coffeestore.view.R;


public class FragmentMeDataCtrl {
	private static ArrayList<HashMap<String, Object>> list;

	public static ArrayList<HashMap<String, Object>> getFunctionsName() {
		list = new ArrayList<HashMap<String, Object>>();
		addFunctionsName("??????", R.drawable.icon_more_context);
		addFunctionsName("???????", R.drawable.icon_more_context);
		addFunctionsName("???????", R.drawable.icon_more_context);
		addFunctionsName("??????", R.drawable.icon_more_context);
		addFunctionsName("??????", R.drawable.icon_more_context);
		addFunctionsName("?????", R.drawable.icon_more_context);
		addFunctionsName("?????", R.drawable.icon_more_context);
		addFunctionsName("???????", R.drawable.icon_more_context);
		return list;
	}

	public static void addFunctionsName(String name, int image) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("functionName", name);
		map.put("iconImage", image);
		list.add(map);
	}
}
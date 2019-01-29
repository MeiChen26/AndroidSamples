package neusoft.soft.coffeestore.fragment;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

import neusoft.soft.coffeestore.view.LoginActivity;
import neusoft.soft.coffeestore.view.ManageAddressActivity;
import neusoft.soft.coffeestore.view.MyAccountActivity;
import neusoft.soft.coffeestore.view.MyIntegralActivity;
import neusoft.soft.coffeestore.view.R;


public class MeFragment extends Fragment {
    private ListView listView;
    private ArrayList<HashMap<String, Object>> items;
    private Button btnLogin;
    private View view;
    private View headerView;
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_5, null);
        headerView = inflater.inflate(R.layout.fragment_5_header, null);
        listView = (ListView) view.findViewById(R.id.lv_functions);
        btnLogin = (Button) headerView.findViewById(R.id.btn_login_or_register);
        // 登录按钮设置监听器
        btnLogin.setOnClickListener(new ButtonLoginClickListener());
        // Fragment5上功能项描述的数据源
        items = FragmentMeDataCtrl.getFunctionsName();
        SimpleAdapter simpleAdapter = new SimpleAdapter(
                this.getActivity(),
                items,
                R.layout.fragment_5_layout,
                new String[] {"functionName", "iconImage" },
                new int[] {R.id.tv_functionName, R.id.iv_image });
        // 使ListView上面部分的内容随ListView一起上下滑动
        listView.addHeaderView(headerView);

        listView.setAdapter(simpleAdapter);
        init();
        return view;
       // return inflater.inflate(R.layout.fragment_me, container, false);
    }

    private void init() {
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int position,  long arg3) {
                switch (position) {
                    case 1:
                        // 我的信息
                        Intent intent1 = new Intent(getActivity(), MyAccountActivity.class);
                        startActivity(intent1);
                        getActivity().overridePendingTransition(R.anim.go_in, R.anim.go_out);
                        break;
                    case 2:
                        // 我的评论
                        Toast.makeText(getActivity(), "我的评论", Toast.LENGTH_SHORT).show();
                        getActivity().overridePendingTransition(R.anim.go_in, R.anim.go_out);
                        break;
                    case 3:
                        // 地址管理
					Intent intent3 = new Intent(getActivity(), ManageAddressActivity.class);
					startActivity(intent3);
					getActivity().overridePendingTransition(R.anim.go_in, R.anim.go_out);
                        break;
                    case 4:
                        // 我的收藏
                        Toast.makeText(getActivity(), "我的收藏", Toast.LENGTH_SHORT).show();
                        getActivity().overridePendingTransition(R.anim.go_in, R.anim.go_out);
                        break;
                    case 5:
                        // 我的礼券
                        Toast.makeText(getActivity(), "我的礼券", Toast.LENGTH_SHORT).show();
                        getActivity().overridePendingTransition(R.anim.go_in, R.anim.go_out);
                        break;
                    case 6:	// 我的积分
                        Intent intent6 = new Intent(MeFragment.this.getActivity(), MyIntegralActivity.class);
                        startActivity(intent6);
                        getActivity().overridePendingTransition(R.anim.go_in, R.anim.go_out);
                        break;
                    case 7:
                        // 意见反馈
//                        Intent intent7 = new Intent(getActivity(), neusoft.soft.coffeestore.view.FeedbackActivity.class);
//                        startActivity(intent7);
//                        getActivity().overridePendingTransition(R.anim.go_in, R.anim.go_out);
                        break;
                    case 8:
                        // 客服热线
                        serviceHotlineAlertDialog_OnClick();
                        break;
                }
            }
        });
    }
    /**
     * 客服热线功能的实现
     */
    private void serviceHotlineAlertDialog_OnClick() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this.getActivity());

        builder.setTitle("客服电话");
        builder.setIcon(R.drawable.main_user);
        builder.setMessage("拨打13688888888");
        DialogInterface.OnClickListener confirmListener = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                phoneCall();
            }
        };
        builder.setPositiveButton("确定", confirmListener);
        DialogInterface.OnClickListener cancelListener = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            }
        };
        builder.setNegativeButton("取消", cancelListener);

        AlertDialog dialog = builder.create();
        dialog.show();
    }
    private void phoneCall() {
        String data = "tel:" + "13688888888";
        Uri uri = Uri.parse(data);
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_DIAL);
        intent.setData(uri);
        startActivity(intent);
    }

    //登录加动画
    private class ButtonLoginClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(MeFragment.this.getActivity(),
                    LoginActivity.class);
            startActivity(intent);
            getActivity().overridePendingTransition(R.anim.up_in, R.anim.up_out);
        }
    }

    private static class FragmentMeDataCtrl {
        private static ArrayList<HashMap<String, Object>> list;

        public static ArrayList<HashMap<String, Object>> getFunctionsName() {
            list = new ArrayList<HashMap<String, Object>>();
            addFunctionsName("我的信息", R.drawable.icon_more_context);
            addFunctionsName("我的评论", R.drawable.icon_more_context);
            addFunctionsName("地址管理", R.drawable.icon_more_context);
            addFunctionsName("我的收藏", R.drawable.icon_more_context);
            addFunctionsName("我的礼券", R.drawable.icon_more_context);
            addFunctionsName("我的积分", R.drawable.icon_more_context);
            addFunctionsName("意见反馈", R.drawable.icon_more_context);
            addFunctionsName("客服热线", R.drawable.icon_more_context);
            return list;
        }

        public static void addFunctionsName(String name, int image) {
            HashMap<String, Object> map = new HashMap<String, Object>();
            map.put("functionName", name);
            map.put("iconImage", image);
            list.add(map);
        }

    }
}

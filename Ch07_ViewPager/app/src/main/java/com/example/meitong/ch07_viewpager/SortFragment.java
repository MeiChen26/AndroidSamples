package com.example.meitong.ch07_viewpager;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;


/**
 * A simple {@link Fragment} subclass.
 */
public class SortFragment extends Fragment {
    String[] queArr = {"星期一", "星期二", "星期三", "星期四", "星期五"};

    public SortFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_sort, container, false);

        ListView listView = view.findViewById(R.id.lv);
        //创建ArrayAdapter
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(SortFragment.this.getActivity(), android.R.layout.simple_list_item_checked, queArr);
        //为ListView对象设置Adapter
        listView.setAdapter(adapter);


        return view;

    }

}

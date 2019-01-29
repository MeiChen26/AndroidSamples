package com.example.meitong.ch08_expandablelistview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ExpandableListView expandableListView;
    private String[] groups = {"初中好友", "高中好友"};
    private String[][] children = {{"小明", "小红"}, {"韩梅梅"}};
    private int[] pics = {R.drawable.one, R.drawable.two};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        expandableListView = findViewById(R.id.lv);
        expandableListView.setAdapter(new MyExpandableAdapter());

    }

    class MyExpandableAdapter extends BaseExpandableListAdapter{

        @Override
        public int getGroupCount() {
            return groups.length;
        }

        @Override
        public int getChildrenCount(int groupPosition) {
            return children[groupPosition].length;
        }

        @Override
        public Object getGroup(int groupPosition) {
            return groups[groupPosition];
        }

        @Override
        public Object getChild(int groupPosition, int childPosition) {
            return null;
        }

        @Override
        public long getGroupId(int groupPosition) {
            return groupPosition;
        }

        @Override
        public long getChildId(int groupPosition, int childPosition) {
            return childPosition;
        }

        @Override
        public boolean hasStableIds() {
            return false;
        }

        @Override
        public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
            if(convertView == null)
                convertView = getLayoutInflater().inflate(R.layout.group_layout, null);
            ImageView icon = convertView.findViewById(R.id.icon_group);
            TextView title = convertView.findViewById(R.id.title_group);
            title.setText(groups[groupPosition]);
            icon.setImageResource(pics[groupPosition]);
            return convertView;
        }


        @Override
        public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
            if(convertView == null)
                convertView = getLayoutInflater().inflate(R.layout.children_layout, null);
            TextView title = convertView.findViewById(R.id.title_children);
            title.setText(children[groupPosition][childPosition]);

            return convertView;
        }

        @Override
        public boolean isChildSelectable(int groupPosition, int childPosition) {
            return true;
        }
    }
}

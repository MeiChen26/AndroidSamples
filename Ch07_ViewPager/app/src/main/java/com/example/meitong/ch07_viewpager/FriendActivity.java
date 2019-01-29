package com.example.meitong.ch07_viewpager;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.TextView;

public class FriendActivity extends AppCompatActivity {

    private ExpandableListView expandableListView;
    private String[] groups = {"散文", "小说"};
    private String[][] children = {{"呐喊", "朝花夕拾"}, {"红楼梦", "了不起的盖茨比"}};
    private int[] pics = {R.drawable.one, R.drawable.two};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friend);
        expandableListView = findViewById(R.id.lv);
        expandableListView.setAdapter(new MyExpandableAdapter());

    }

    class MyExpandableAdapter extends BaseExpandableListAdapter {

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


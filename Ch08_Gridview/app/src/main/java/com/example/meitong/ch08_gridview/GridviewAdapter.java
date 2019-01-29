package com.example.meitong.ch08_gridview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class GridviewAdapter extends BaseAdapter {
    private Context context;
    String[] titles = {"我的书", "喜欢的运动", "喜欢的电影", "我的音乐", "我的家", "我的学校"};
    int[] pics = {R.drawable.book, R.drawable.sports, R.drawable.my, R.drawable.music,
            R.drawable.home, R.drawable.school};

    public GridviewAdapter(Context context) {
        this.context = context;

    }

    @Override
    public int getCount() {
        return titles.length;
    }

    @Override
    public Object getItem(int position) {
        return titles[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null)
            convertView = LayoutInflater.from(context).inflate(R.layout.icon_item, null);

        ImageView imageView = convertView.findViewById(R.id.img_icon);
        imageView.setImageResource(pics[position]);
        TextView textView = convertView.findViewById(R.id.txt_icon);
        textView.setText(titles[position]);
        return convertView;
}
}

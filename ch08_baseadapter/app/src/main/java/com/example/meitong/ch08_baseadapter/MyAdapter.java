package com.example.meitong.ch08_baseadapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.LinkedList;

/**
 * created by meitong on 2018/11/5
 */
public class MyAdapter extends BaseAdapter{

    private Context context;
    private LinkedList<User>userData;

    public MyAdapter(LinkedList<User>userData, Context context){
        this.context = context;
        this.userData =  userData;
    }

    @Override
    public int getCount() {
        return userData.size();
    }

    @Override
    public Object getItem(int position) {
        return userData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder = null;
        if(convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.user_item,parent,false);
            holder = new ViewHolder();
            holder.img_icon = (ImageView) convertView.findViewById(R.id.iv);
            holder.txt_name = (TextView) convertView.findViewById(R.id.tv);
            holder.txt_sex = (TextView) convertView.findViewById(R.id.tv2);
            convertView.setTag(holder);   //将Holder存储到convertView中
        }else{
            holder = (ViewHolder) convertView.getTag();
        }

        User user = userData.get(position);
        holder.img_icon.setImageResource(user.getPic());
        holder.txt_name.setText(user.getName());
        holder.txt_sex.setText(user.getSex());
        return convertView;

    }
    static class ViewHolder{
        ImageView img_icon;
        TextView txt_name;
        TextView txt_sex;
    }
}

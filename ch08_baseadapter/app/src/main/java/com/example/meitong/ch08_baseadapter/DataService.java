package com.example.meitong.ch08_baseadapter;

import java.util.LinkedList;

public class DataService {

    LinkedList<User> userData = new LinkedList<User>();
    private int[] images = {R.drawable.one, R.drawable.two, R.drawable.three, R.drawable.four, R.drawable.five,R.drawable.six};
    private String[] names = {"大娃", "二娃", "三娃", "四娃", "五娃", "六娃"};//定义字符串数组，用来保存用户的名字
    private String[] sex = {"女", "男", "男", "男", "女", "女"};
    public LinkedList<User> getUserData() {

        for(int i = 0; i< 6;i++){
            userData.add(new User(names[i], images[i], sex[i]));
        }

    return userData;
    }
}

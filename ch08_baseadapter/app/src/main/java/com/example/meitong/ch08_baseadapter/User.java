package com.example.meitong.ch08_baseadapter;

public class User {
    private String name;
    private int pic;
    private String sex;
    public User(String name, int pic, String sex){
        this.name = name;
        this.pic = pic;
        this.sex = sex;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setPic(int pic){
        this.pic = pic;
    }
    public void setSex(String sex){
        this.sex = sex;
    }
    public String getName(){
        return name;
    }
    public int getPic(){
        return pic;
    }
    public String getSex(){ return sex;}

}


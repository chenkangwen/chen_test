package com.example.demo.entity;

public class Father {


    private Boolean hasWife;


    public Boolean getHasWife() {
        return hasWife;
    }

    public void setHasWife(Boolean hasWife) {
        this.hasWife = hasWife;
    }

    public Father() {
    }

    public Father(Boolean hasWife) {
        this.hasWife = hasWife;

    }

    static {

    }

    {

    }

    public void say(){
        System.out.println("这个是父类");
    }

    public static String eat(){
        return "父类吃肉";
    }
}

package com.example.jiaofeng.meida.entity;

/**
 * Created by jiaofeng on 2017/6/4.
 */

public class WithDraw {
    private String title;
    private String date;
    private float number;

    public WithDraw(String title, String date, float number) {
        this.title = title;
        this.date = date;
        this.number = number;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public float getNumber() {
        return number;
    }

    public void setNumber(float number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "WithDraw{" +
                "title='" + title + '\'' +
                ", date='" + date + '\'' +
                ", number=" + number +
                '}';
    }
}

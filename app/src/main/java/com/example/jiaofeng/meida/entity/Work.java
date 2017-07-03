package com.example.jiaofeng.meida.entity;

/**
 * Created by jiaofeng on 2017/6/4.
 */

public class Work {
    private String header;
    private String title;
    private String content;
    private String name;
    private int price;
    private String date;
    private int peoplenumber;
    private int looknumber;

    public Work(String header, String title, String content, String name, int price, String date, int peoplenumber, int looknumber) {
        this.header = header;
        this.title = title;
        this.content = content;
        this.name = name;
        this.price = price;
        this.date = date;
        this.peoplenumber = peoplenumber;
        this.looknumber = looknumber;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getPeoplenumber() {
        return peoplenumber;
    }

    public void setPeoplenumber(int peoplenumber) {
        this.peoplenumber = peoplenumber;
    }

    public int getLooknumber() {
        return looknumber;
    }

    public void setLooknumber(int looknumber) {
        this.looknumber = looknumber;
    }

    @Override
    public String toString() {
        return "Work{" +
                "header='" + header + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", date='" + date + '\'' +
                ", peoplenumber=" + peoplenumber +
                ", looknumber=" + looknumber +
                '}';
    }
}

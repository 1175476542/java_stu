package com.test.ext.demo;

import java.io.Serializable;

public class Demo  implements Serializable {
    private static final long serialVersionUID = 1L;
    private int id;
    private String info;
    private  int num;

    public Demo() {
    }

    public Demo(int id, String info, int num) {
        this.id = id;
        this.info = info;
        this.num = num;
    }

    public int getId() {
        return id;
    }

    public String getInfo() {
        return info;
    }

    public int getNum() {
        return num;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public void setNum(int num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "Demo{" +
                "id=" + id +
                ", info='" + info + '\'' +
                ", num=" + num +
                '}';
    }
}

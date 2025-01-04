package com.test.file;

import java.io.Serializable;

public class Goods implements Serializable {
    private static final long serialVersionID = 1L;
    private static String brand = "曹哥";
    private String name;
    private int price;
    private transient int sale;//表示不需要序列化

    public Goods() {
    }

    public Goods(String name, int sale, int price) {
        this.name = name;
        this.sale = sale;
        this.price = price;
    }

    public Goods(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getSale() {
        return sale;
    }

    public static String getBrand() {
        return brand;
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

    public void setSale(int sale) {
        this.sale = sale;
    }

    public static void setBrand(String brand) {
        Goods.brand = brand;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", sale=" + sale +
                ", brand = " +brand +
                '}';
    }
}

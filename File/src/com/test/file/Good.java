package com.test.file;

import java.io.*;

public class Good implements Externalizable {
    private static final long serialVersionID = 1L;
    private static String brand = "曹哥";
    private String name;
    private int price;
    private transient int sale;//表示不需要序列化

    public Good() {
    }

    public Good(String name, int sale, int price) {
        this.name = name;
        this.sale = sale;
        this.price = price;
    }

    public Good(String name, int price) {
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
        Good.brand = brand;
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

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeUTF(name);
        out.writeInt(price);
        out.writeInt(sale);
        out.writeUTF(brand);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        name = in.readUTF();
        price = in.readInt();
        sale = in.readInt();
        brand = in.readUTF();
    }
}

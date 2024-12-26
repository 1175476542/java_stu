package com.test.object;

import java.util.Objects;

public class Hash {
    public static void main(String[] args) {
        String a = "Aa";
        String b = "BB";
        System.out.println(a.hashCode());
        System.out.println(b.hashCode());
        Circle circle = new Circle();
        Circle circle1  = new Circle();
        System.out.println(circle1.equals(circle));//重写前false，重写后true
        System.out.println(circle1 == circle);//false
        String s1 = new String("hello");
        String s2 = new String("hello");
        String s3 = "hello";//true
        String s4 ="hello";//true因为这是字符串常量，s3，s4都指向的同一个对象
        System.out.println(s1 == s2);
        System.out.println(s1.equals(s2));//true 因为String类型重写了equals方法
    }
}
class Circle{
    private double radius;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Circle circle = (Circle) o;
        return Double.compare(circle.radius, radius) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(radius);
    }
}

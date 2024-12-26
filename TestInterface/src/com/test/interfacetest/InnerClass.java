package com.test.interfacetest;

import java.util.Comparator;

public class InnerClass {
    public static void main(String[] args) {
        Comparator c = new Comparator(){
            @Override
            public int compare(Object o1, Object o2) {
                Circle c1 = (Circle) o1;
                Circle c2 = (Circle) o2;
                if(c1.getRadius() > c2.getRadius()){
                    return 1;
                }else if(c1.getRadius() < c2.getRadius()){
                    return -1;
                }
                return 0;
            }
        };
        System.out.println(c.compare(new Circle(1), new Circle(2)));
    }
}
class Circle1{
    private double radius;

    public Circle1(double radius) {
        super();
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public String toString() {
        return "Circle [radius=" + radius + "]";
    }

}
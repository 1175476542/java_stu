package com.test.interfacetest;

import java.util.Arrays;
import java.util.Comparator;

public class UnknownInnerClass {
    public static void main(String[] args) {

        //报错，之所以报错是因为只创建了这个实例，但是没有说干什么，可以通过赋值或者在后边直接“.”调用方法
//        new Object(){
//            public void test(){
//                System.out.println("匿名内部类");
//            }
//        }
//        new Object() {
//            public void test() {
//                System.out.println("匿名内部类");
//            }
//        }.test();
//        //多态引用
//        Object obj = new Object() {
//            public void test() {
//                System.out.println("匿名内部类");
//            }
//        };
//        obj.toString();
//        obj.test();
        //比较两个圆的大小
//        Comparator c = new Comparator() {
//            public int compare(Object o1, Object o2) {
//                Circle c1 = (Circle) o1;
//                Circle c2 = (Circle) o2;
//                if (c1.getRadius()> c2.getRadius()) {
//                    return 1;
//                } else if (c1.getRadius()< c2.getRadius()) {
//                    return -1;
//                } else return 0;
//            }
//        };
//        System.out.println(c.compare(new Circle(1), new Circle(2)));
//        Circle c1 = new Circle(1.2);
//        Circle c2 = new Circle(1.4);
//        c.compare(c1,c2);
        Circle[] c = new Circle[3];
        c[0] = new Circle(3);
        c[1] = new Circle(2);
        c[2] = new Circle(1);
        Arrays.sort(c,new Comparator() {
            public int compare(Object o1, Object o2) {
                Circle c1 = (Circle) o1;
                Circle c2 = (Circle) o2;
                if (c1.getRadius()> c2.getRadius()) {
                    return 1;
                } else if (c1.getRadius()< c2.getRadius()) {
                    return -1;
                } else return 0;
            }
        });
        for (int i = 0; i < c.length; i++) {
            System.out.println(c[i]);
        }
    }


}

class Circle {
    private double radius;

//    public Circle() {
//    }

    public Circle(double radius) {
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
        return "Circle{" +
                "radius=" + radius +
                '}';
    }
}
//以前的做法
//class RadiusCompare implements Comparator{
//    @Override
//    public int compare(Object o1, Object o2) {
//        o1 = (Circle) o1;
//        o2 = (Circle) o2;
//        if (compare(o1,o2)>0){
//            return 1;
//        }else if (compare(o1,o2)<0){
//            return -1;
//        }else return 0;
//    }
//}
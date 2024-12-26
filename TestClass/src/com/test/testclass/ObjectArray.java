package com.test.testclass;

public class ObjectArray {
    public static void main(String[] args) {
        Circle[] c = new Circle[5];
        for (int  i = 0;i< c.length;i++){
            c[i] = new Circle();
            c[i].r = i+1;
            c[i].printInfo();
        }
    }
//    Circle[] c = new Circle[5];

}
class Circle{
    double r;
    double getArea(){
        double area = 3.14*r*r;
        return area;
    }
    public void printInfo(){
        System.out.println("圆的半径是：" + r + "圆的面积是：" + getArea());
    }
}
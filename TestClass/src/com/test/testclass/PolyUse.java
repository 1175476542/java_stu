package com.test.testclass;
/*
## 多态的应用
    -- 多态的好处：是的程序员编写代码更加灵活
    -- 1.多态数组
        -- 数组的元素是父类型，实际存储的是子类的对象
        -- 用这样的数组可以统一管理子类的对象

 */
public class PolyUse {
    public static void main(String[] args) {
        //本态数组
        Circle1[] c = new Circle1[3];
        Rectangle[] r = new Rectangle[3];
        //多态数组
        Graphic[] all = new Graphic[3];
        //左边是Graphic类型，右边是圆类型
        all[0] = new Circle1(2);
        all[1] = new Rectangle(4,2);
        all[2] = new Circle1(3);
        for (int  i = 0;i<all.length;i++){
            System.out.println(all[i].getArea());
        }

    }
}

class Graphic{
    public double getArea(){
        return 0.0;
    }
}

class Circle1 extends Graphic{
    private double radius;
    public Circle1(double radius){
        this.radius = radius;
    }
    @Override
    public double getArea() {
        return 3.14*radius*radius;
    }
}
class Rectangle extends Graphic{
    private double l;
    private double w;
    public Rectangle(double l,double w){
        this.l = l;
        this.w = w;
    }
    public double getArea(){
        return l*w;
    }
}

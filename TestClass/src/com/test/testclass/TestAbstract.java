package com.test.testclass;
import java.lang.Math;

public class TestAbstract {
    public static void main(String[] args) {
//        Graphic1 g = new Graphic1();//错误
        Graphic1 c = new Circle2();
        Graphic1 c1 = new Circle2(1.2);
    }
}

abstract class Graphic1{
    public Graphic1(){

    }
    public Graphic1(double r){

    }
    public abstract double getArea();
}
abstract class Rectangle1 extends Graphic1{

}
class Circle2 extends Graphic1{
    private double r;
    public Circle2(){
        super();
    }
    public Circle2(double r){
        super(r);
        this.r = r;
        System.out.println(getArea());
    }
    public double getRadius(){
        return this.r;
    }
    public void setRadius(double r){
        this.r = r;
    }
    public double getArea(){
        return Math.PI*r*r;
    }
}

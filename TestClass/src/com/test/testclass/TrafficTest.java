package com.test.testclass;
/*
1、练习题
（1）声明Traffic，
public void drive()方法
（2）声明子类Car,Bicycle
（3）在测试类的main中创建一个数组，有各种交通工具，遍历调用drive()方法
 */
public class TrafficTest {
    public static void main(String[] args) {
        Traffic[] t = {new Car(),new Bus(),new Bycycle()};
        for (int  i = 0;i<t.length;i++){
            t[i].drive();
        }

    }
}
class Traffic{
    public void drive(){
        System.out.println("乘坐交通工具去上学");
    }
}
class Car extends Traffic{
    public void drive(){
        System.out.println("开车去上学");
    }
}
class Bycycle extends Traffic{
    public void drive(){
        System.out.println("骑车去上学");
    }
}
class Bus extends Traffic{
    public void drive(){
        System.out.println("坐公交去上学");
    }
}

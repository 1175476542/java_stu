package com.exercise.polymorphism;
/*
2、练习题2
（1）声明一个Person类，有一个方法
public void toilet(){
}
（2）声明一个子类Woman类，重写方法
（3）声明一个子类Man类，重写方法
（4）在测试类中声明一个方法，
public static void goToToilet(Person p){
	//调用toilet()
}
 */
public class ExcerPolyPerson {
    public static void main(String[] args) {
        Person p = new Man();
        Person p1 = new Woman();
        Person[] Pa = {new Woman(),new Man()};
        goToToilet(p);
        goToToilet(p1);
        goToToilet(Pa);
        goToToilet(new Man());
    }
    public static void goToToilet(Person... p){
        for (int  i = 0;i<p.length;i++){
            p[i].toilet();
        }
    }
}

class Person{
    public void toilet(){
        System.out.println("上厕所");
    }
}
class Man extends Person{
    public void toilet(){
        System.out.println("站着上厕所");
    }
}
class Woman extends Person{
    public void toilet(){
        System.out.println("蹲着上厕所");
    }
}


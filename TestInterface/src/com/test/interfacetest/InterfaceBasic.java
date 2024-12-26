package com.test.interfacetest;

public class InterfaceBasic {
    public static void main(String[] args) {
//        Bird b = new Bird();
//        b.fly();
//        Plane p = new Plane();
//        p.fly();
//        Kite k = new Kite();
//        k.fly();
        Jumpable[] j = new Jumpable[3] ;
        j[0] = new Bird();
        Flyable[] f = new Flyable[3];
        f[0] = new Bird();
        f[1] = new Plane();
        f[2] = new Kite();
        for (int i = 0; i < f.length; i++) {
            f[i].fly();
        }
        j[0].jump();

    }
}
interface Flyable{
    long MAX_SPEED = 790000;
    void fly();
}
interface Jumpable extends Flyable{
    void jump();
}


class Bird implements Flyable,Jumpable{
    @Override
    public void fly() {
        System.out.println("煽动翅膀，自由翱翔");
    }
    public void jump(){
        System.out.println("跳着走");
    }
}

class Plane implements Flyable{
    public void fly(){
        System.out.println("发动机转动");
    }
}
class Kite implements Flyable{
    public void fly(){
        System.out.println("放风筝");
    }
}
interface A{
    void a();
}
interface B{
    void b();
}
interface C extends A,B{
    void c();
}
class Imp implements C{
    @Override
    public void a() {

    }

    @Override
    public void b() {

    }

    @Override
    public void c() {

    }
}
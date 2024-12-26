package com.test.testclass;
/*
## 多态参数
    --形参是父类型，实参是子类对象
 */
public class PolyPara {
    public static void main(String[] args) {
        Animal animal1 = new Dog();
        Animal animal2 = new Cat();
        Animal[] animalsSet = new Animal[3];
        animalsSet[0] = new Cat();
        animalsSet[1] = new Dog();
        animalsSet[2] = new Dog();
        check(animal1);
        check(animal2);
        check(animalsSet);
        check(new Dog());//匿名对象 形参隐含了，形参Animal a = 实参new Dog()
    }
    public static void check(Animal... animal){
        for (int i = 0;i<animal.length;i++){
            animal[i].call();
        }
    }

}

class Animal{
    public void call(){
        System.out.println("叫");
    }
}
class Dog extends Animal{
    @Override
    public void call() {
        System.out.println("汪汪");
    }
}
class Cat extends Animal{
    @Override
    public void call() {
        System.out.println("喵喵");
    }
}

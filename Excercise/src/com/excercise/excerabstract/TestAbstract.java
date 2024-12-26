package com.excercise.excerabstract;
/*
1、父类：动物，Animal，包含属性：name（动物名称）
抽象方法，生育：public abstract void giveBirthTo();
2、子类：卵生动物，Oviparity
3、子类：胎生动物，Viviparity
4、在测试类中，创建Animal数组，并保存多个子类对象，
并调用getName()和giveBirthTo()方法，打印：例如：狗是胎生动物

 */
public class TestAbstract {
    public static void main(String[] args) {
        Animal[] a = {new Oviparity("蛇"),new Viviparity("狗")};
        System.out.println(a[0].getName() + "是" + a[0].giveBirthTo());
        System.out.println(a[1].getName() + "是" + a[1].giveBirthTo());
    }


}
abstract class Animal{
    private String name;

    public Animal() {
    }
    public Animal(String name) {
        this.name = name;
    }

    public  String getName(){
     return this.name;
    }

    public abstract String giveBirthTo();
}
class Oviparity extends Animal{
    private String name;
    public Oviparity(String name) {
        super(name);
        this.name = name;
    }


    @Override
    public String giveBirthTo() {
        return "卵生动物";
    }
}
class Viviparity extends Animal{
    private String name;
    public Viviparity(String name) {
        super(name);
        this.name = name;
    }

    @Override
    public String giveBirthTo() {
        return "胎生动物";
    }
}

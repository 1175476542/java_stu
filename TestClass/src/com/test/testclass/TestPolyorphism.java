package com.test.testclass;
/*
##多态
####多态：多种形态
-- 1.变量的引用形式
-- （1）本态引用
-- （2）多态引用
-- 2.多态表现出来的特征
--      编译的时候是按照父类进行编译的
--      执行的方法是子类重写的方法
--      编译看左边，执行看右边
--      （1）前提：继承 重写
--      （2）用途：方法的动态绑定
--      （3）多态与属性无关，只说方法
--      网上也有人说：把重载也归为多态，我们以官方为准
*/
public class TestPolyorphism {
    public static void main(String[] args) {
        //1.本态引用，通俗讲：两边类型相同，等级相同
        Poet p = new Poet();
        Poem po = new Poem();
        PoemType pt = new PoemType();
        //2.多态引用，左边的是父类对象，右边的是子类对象
        Poet p1 = new Poem();
        Poet p2 = new PoemType();
        p1.drink();
        p2.drink();
    }
}

class Poet{
    private String name;
    public void drink(){
        System.out.println("斗酒诗百篇");
    }
}
class Poem extends Poet{
    private String poemName;
    public void drink(){
        System.out.println("传世流芳");
    }
}
class PoemType extends Poet{
    private String type;
    public void drink(){
        System.out.println("豪言壮语");
    }
}

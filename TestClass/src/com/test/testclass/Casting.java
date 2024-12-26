package com.test.testclass;
/*
## 数据的类型转换
    -- 1.基本数据转换
        -- （1）自动类型转换
            -- byte->short->int->long->float->double
                     char->
            -- boolean不参与
        -- （2）强制类型转换
            -- 上面翻过来
    -- 2.引用数据转换
        -- 父子之间的转换
            -- （1）向上转型：从子类->到父类
                -- 把子类变量赋值给父类变量时
            -- （2）向下转型：从父类->到子类
                -- 把父类变量赋值给子类变量时
    -- 3.为什么要向上转型
        -- 因为多态数组、多态参数的应用场景，使的有时候不得不向上转型
    -- 4.为什么要向下转型
        --为了调用子类特有的方法
    -- 5.不是任意父类的变量都可以向下转型，需要先向上转型，才能再向下转型
    想转型成功，必须之前是向上转型的，才能向下转型成功。
 *  或者说，要想转型成功，必须保证该变量中保存的对象的运行时类型是<=强转的类型
 *  例如：
 *  	Person p = new Woman();//向上转型
 *  	//向下转型
 *  	Woman m = (Woman)p; p变量中实际存储的对象就是Woman类型，和强转的Woman类型一样
 *
 *		Person p4 = new ChineseWoman();//向上转型


 *		//向下转型
		Woman w4 = (Woman) p4; p4变量中实际存储的对象是ChineseWoman类型，强制的类型是Woman，ChineseWoman<Woman类型
        ```java
        Person p = new Person();
        Woman w = (Woman)p//不行！报错
        ```
        ```java
        Woman w = new Woman();
        Man m = (Man)w//也不行！
        ```

 */
public class Casting {
    public static void main(String[] args) {
        Person p = new Man();
        Person p1 = new Woman();//多态引用，向上转型，只能调用父类有的方法
        p1.eat();
        p1.toilet();
//        p1.shop();//报错
        //想要调用Woman特有的方法时，向下转型
//        Woman w = p1;//编译不通过
        //编译时,p是Person类型，那么编译不通过，因为java中认为父类的概念范围大于子类的
        Woman m = (Woman) p1;
        ((Woman) p1).shop();//两个都可以
        m.shop();
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
    public void eat(){
        System.out.println("吃饭");
    }
}
class Man extends Person{
    public void toilet(){
        System.out.println("站着上厕所");
    }
    public void smoke(){
        System.out.println("抽烟");
    }
}
class Woman extends Person{
    public void toilet(){
        System.out.println("蹲着上厕所");
    }
    public void shop(){
        System.out.println("买东西");
    }
}
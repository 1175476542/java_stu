package com.test.packagetest;

public class TestInherit {
    /*
    ## 继承
    -- （1）延续
    -- （2）扩展
    #### 1.为什么要有扩展
    -- （1）当某个类需要派生出很多子类别，那么此时poet中的共有部分就不需要在子类别中再次声明

    --（2）当多个类，出现了共同的特征时，就可以把共同的特征抽取到父类中
    -- 目的：
    -- 代码的服用和扩展
    #### 2.如何实现继承
            -- 【修饰符】 class 【子类】 extends 【父类】{}
            -- 子类subclass，也称为派生类
            -- 父类superclass，也称为超类，基类
   #### 3.继承的特点；
        -- （1）子类继承了父类，
        -- 从事物的特征来说，子类会继承父类的所有特征
        -- 但是从代码的角度来说，父类中私有的属性、方法在子类中是不能直接使用的
        -- （2）子类继承父类时，父类的构造器是不能被继承的
        -- （3）子类在继承父类时，在子类的构造器中一定回去调用父类的构造器，默认调用父类的无参构造
        -- 如果父类没有无参构造，那么要在子类的首行手动调用父类的要参构造；super(【形参列表】)
        -- （4）java只支持单继承，即一个java类只能有一个直接父类
        -- （5）java支持多层继承，即父类还可以有父类
        -- （6）一个java类可以有很多子类，而且子类还能有子类
        -- （7）子类可以扩展父类没有的属性、方法
     */
    public static void main(String[] args) {

        Poem p = new Poem();
        p.printInfo();
        Poem p2 = new Poem("五言");
        p2.printInfo();
        Poem p3 = new Poem();
        p3.setName("杜甫");
        p3.setType("五言");
        p3.printInfo();
    }
}
class Poet{
    private String name = "李白";
    public Poet(){

    }
    public Poet(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name = name;
    }

}
class Poem extends Poet{
//    super(String name);
    private String type = "七言";
//    private String qiyan = "七言";
    public Poem(){

    }
    public Poem(String type){
        this.type = type;
    }
//    public com.test.packagetest.Poem(String qiyan){
//
//    }
//    public com.test.packagetest.Poem(String type,String qiyan){
//
//    }
    public String getType(){
        return this.type;
    }
    public void setType(String type){
        this.type = type;
    }
    public void  printInfo(){
        System.out.println("这首诗是"+ this.getName()+"的"+ this.getType());
    }
}
package com.test.packagetest;

/*
## 方法的重写
-- 当子类继承了父类的方法时，但是父类的方法体不适用于子类了，那么子类可以选择进行重写overwrite
-- 方法 = 方法签名/方法头+方法体

## 重写有要求
    -- （1）方法名：必须和父类被重写的方法名相同
    -- （2）形参列表：必须和父类被重写的形参列表相同
    -- （3）返回值类型：
        -- 基本数据类型和void，要求与父类被重写的方法的返回值类型相同
        -- 引用数据类型：要求子类重写的方法的返回值类型<=父类被重写的返回值类型
        -- 例如：子类必须包含在父类
    -- （4）修饰符
            -- 1.权限修饰符：子类重写的方法的权限修饰符的可见范围>=父类被重写的方法的权限修饰符的可见范围
            -- 2.其他修饰符
 */
public class TestOverwrite {
    public static void main(String[] args) {
        PoetDemo p = new PoetDemo();
        p.printInfo();
        PoetDemo p2 = new PoetDemo("杜甫");
        p2.printInfo();
        PoemDemo p3 = new PoemDemo();
        p3.printInfo();
        PoemDemo p4 = new PoemDemo("七言");
        p4.printInfo();
        p.printInfo();
    }
}
class PoetDemo{
    private String name = "李白";
    public PoetDemo(){

    }
    public PoetDemo(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void printInfo(){
        System.out.println("这个诗人是：" + this.name);
    }

}
class PoemDemo extends PoetDemo{
    private String type = "五言";
    public PoemDemo(){

    }
    public PoemDemo(String type){
        this.type = type;
    }
    public String getType(){
        return this.type;
    }
    public void setType(String type){
        this.type = type;
    }
    public void printInfo(){
        System.out.println("诗人是：" + this.getName()+ "类型是：" + this.getType());
    }
}

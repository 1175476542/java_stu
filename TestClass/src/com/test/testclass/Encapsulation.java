package com.test.testclass;
/*
面向对象的基本特征
    1.封装
        1.隐藏实现细节
        2.安全
      封装的范围：
        1.属性的封装、方法的封装
        2.组件的封装
        3.系统的封装

     封装的实现是依靠权限修饰符（通俗点：用getter和setter读取和修改类中的值）
        权限修饰符
                        本类          本包          其他包         本工程
            private       √
            缺省           √           √
            protect       √           √             √
            public        √           √             √               √

    哪些可以加权限修饰符
    类、属性、方法、构造器、内部类
    分别可以加什么修饰符
        类：缺省、public
            如果类前面有public、必须与原文件名一样
        属性、方法：四个都可以
    属性的封装：
        大多数情况下都是private
    方法的封装：
        大多数情况下都是public
    2.继承
    3.多态
 */
public class Encapsulation {
    public static void main(String[] args) {
        XiaoChuang xiao = new XiaoChuang();
        System.out.println(xiao.getUnit());
        xiao.setUnit("集景");
//        xiao.unit = "集景";//错误
        System.out.println(xiao.getUnit());
    }
}
class XiaoChuang{
    private String unit = "集醒";
    public String getUnit(){
        return unit;
    }
    public void setUnit(String unit){
        this.unit = unit;
    }
}
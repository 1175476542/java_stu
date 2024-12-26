package com.test.packagetest;
/*
this:
1.当前对象
    （1）构造器
        正在被创建的对象
    （2）方法
        正在调用该方法的对象
2.用法
    （1）this.属性
        当局部变量与成员变量同名时，可以在成员变量前加this
    （2）this.方法
        没有费用不可的时候
    （3）this()或this(实参列表)
            this()表示调用的类的无参构造
            this()或this(实参列表)必须在构造器的首行
 */
public class TestThis {
    public static void main(String[] args) {
        String[]  sr = {""};
        ShiRen s = new ShiRen(sr);
    }

}
class ShiRen{
    public ShiRen(){
        String[] sr = {"李白","杜甫","白居易"};
        for (int  i = 0;i<sr.length;i++){
            System.out.println(sr[i]);
        }
    }
    public ShiRen(String[] sr){
        this();
    }


}


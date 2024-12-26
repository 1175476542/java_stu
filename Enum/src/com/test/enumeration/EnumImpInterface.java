package com.test.enumeration;

public class EnumImpInterface {
    public static void main(String[] args) {
        MyEnum A = MyEnum.A;
        MyEnum B = MyEnum.B;
        A.test();
        B.test();
    }
}
interface Inter{
    void test();
}
enum MyEnum implements Inter{//分别实现
    A{
      public void test(){
          System.out.println("aaa");
      }
    },
    B{
        public void test(){
            System.out.println("bbb");
        }
    }
}
enum MyEnum1 implements Inter{//统一实现
    A,B;
    public void test(){
        System.out.println("test");
    }
}
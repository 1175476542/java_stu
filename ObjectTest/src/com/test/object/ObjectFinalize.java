package com.test.object;

public class ObjectFinalize {
    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            MyClass my = new MyClass();
            //for循环创建的对象是局部变量，每调用一次都是一个新的对象
        }
        //通知垃圾回收期尽快回收,但是不能保证马上过来
        System.gc();
        //延迟
        Thread.sleep(1000);
    }
}
class MyClass{
    @Override
    protected void finalize() throws Throwable {
        System.out.println("我走了哈！");
    }
}

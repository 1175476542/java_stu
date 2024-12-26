package com.test.testclass;
/*
## native也是一个修饰符
-- 1.表示原生的、本地的
-- 2.可以修饰什么（方法）
-- 3.他修饰的方法有什么不同
    -- 语法格式
        -- 【修饰符】 class 类{
            【其他修饰符】 native 返回值类型 方法名(【形参列表】)；
        }
        -- native修饰的方法看不见方法体
        -- native修饰的方法不是用java语言实现的，而是调用了底层C/C++代码实现的，这些代码被编译为dll文件，让java来执行的
-- 4.特殊
    -- （1）native方法，对于java程序员来说，该怎么调用就怎么调用
    -- （2）子类还可以选择对他进行重写
 */
public class TestNative {
}

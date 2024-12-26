package com.test.testclass;
/*
向下转型有风险，这是一个运行时异常，不能提前发现要避免的话，可以使用incetanceof
-- 语法格式：
    -- 变量/对象 instanceof 类型，返回布尔值
-- 什么时候返回true
    -- 当存的就是当前比较类型或当前比较类型的子类对象，返回true
 */
public class TestInstanceof {
    public static void main(String[] args) {
        Man m = new Man();
        Woman w = new Woman();
        test(m);
        test(w);
    }
    public static void test(Person p){//隐含了向下转型，Person p = m/w
        if (p instanceof Person){
            p.eat();
            p.toilet();
        }
        else if (p instanceof Man){
            Man m  = (Man)p;
            m.smoke();
        }
        else if (p instanceof Woman){
            Woman w = (Woman) p;
            w.shop();
        }
    }
}


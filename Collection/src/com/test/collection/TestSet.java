package com.test.collection;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class TestSet {
    @Test
    public void test1(){
        Set set = new HashSet();
        set.add("zhangsan");
        set.add("zhangsan");
        set.add("lisi");
        System.out.println(set);
    }
    @Test
    public void test2(){
        TreeSet ts = new TreeSet();
        //String类型实现了Comparable接口，可以添加到TreeSet，可以定制排序也可以自然排序
        ts.add(3);
        ts.add(1);
        ts.add(8);
        ts.add(2);
        System.out.println(ts);//1 2 3 8
    }
    @Test
    public void test3(){
        LinkedHashSet lhs = new LinkedHashSet();
        lhs.add(3);
        lhs.add(1);
        lhs.add(8);
        lhs.add(2);
        System.out.println(lhs);//3 1 8 2
    }

}

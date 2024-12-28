package com.test.collection;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Stack;

public class TestList {
    @Test
    public void test(){
        //这里多态引用凸显List的接口
        List list = new ArrayList();
        list.add(1);
        list.add(0,2);
        list.remove(1);//删除的是下标为1的对象
        list.remove(new Integer(1));//删除的是内容为1的对象
        System.out.println(list);
    }
    @Test
    public void test1(){
        List list =new ArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.set(4,100);
        Object obj = list.get(4);
        System.out.println(obj);
        System.out.println(list);
    }
    @Test
    public void test2(){
        List list =new ArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        ListIterator listIterator = list.listIterator(list.size());//可以吧游标指向任意位置
        while (listIterator.hasPrevious()){
            Object obj = listIterator.previous();//默认游标在第一个如果不重新初始化游标，无法打印
            System.out.println(obj);
        }
        while (listIterator.hasNext()){
            Object obj = listIterator.next();
            System.out.println(obj);
        }
        while (listIterator.hasPrevious()){
            Object obj = listIterator.next();
            System.out.println(obj);
        }

    }
    @Test
    public void test3(){
        Stack s = new Stack();
        s.add("1");
        s.add("2");
        s.add("3");
        s.add("4");
        System.out.println(s.peek());
        System.out.println(s.peek());
        System.out.println(s.peek());
        System.out.println(s.peek());
    }
    @Test
    public void test4(){
        Stack s = new Stack();
        s.add("1");
        s.add("2");
        s.add("3");
        s.add("4");
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        System.out.println(s.pop());
        System.out.println(s.pop());
    }
    @Test
    public void test5(){
        //使用ArrayList实现先进后出
        List list = new ArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        System.out.println(list.remove(list.size()-1));
        System.out.println(list.remove(list.size()-1));
        System.out.println(list.remove(list.size()-1));
        System.out.println(list.remove(list.size()-1));
        System.out.println(list.remove(list.size()-1));
    }
}

package com.test.generic;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class CollectionTools {
    public static void main(String[] args) {

    }
}

class test1{
    @Test
    //public static <T> boolean addAll(Collection<?super T> c,T... elements):把elements这些元素添加到c这个集合中

    public void test1(){
        ArrayList<Integer> list = new ArrayList<Integer>();
        ArrayList<String> list1 = new ArrayList<String>();
        ArrayList<Object> list2 = new ArrayList<Object>();
        ArrayList<Number> list3 = new ArrayList<Number>();
        //此时T是Integer类型
        //<? super T>:可以是Integer或者他的父类
        Collections.addAll(list,1,2,3,4);
        Collections.addAll(list,1,2,3,4);
        Collections.addAll(list2,1,2,3,4);//Number和Object都可以都是Integer的父类
        Collections.addAll(list3,1,2,3,4);
//        Collections.addAll(list2,1,2,3,4);//错误的
    }
    @Test
    public void test2(){
        ArrayList list = new ArrayList();
        list.add(1);
        list.add(3);
        list.add(5);
        int index = Collections.binarySearch(list,2);//找到value返回key，没有找到是负数
        System.out.println(index);
    }
    @Test
    public void test3(){
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        Collections.shuffle(list);//[3, 2, 5, 4, 1]
        //打乱重组
    }
}
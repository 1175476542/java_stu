package com.test.collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class Collection1 {
    public static void main(String[] args) {
        Collection c = new ArrayList();
        c.add("张三");
        c.add("李四");
        c.add("王五");
        Iterator iterator = c.iterator();
        while (iterator.hasNext()){
            Object obj = iterator.next();
            System.out.println(obj);

        }
        while (iterator.hasNext()){
            String name =(String) iterator.next();
            if (name.startsWith("王")){
                iterator.remove();
            }
        }
        System.out.println(c);
        for (Object obj : c) {
            System.out.println(obj);
        }
    }
}


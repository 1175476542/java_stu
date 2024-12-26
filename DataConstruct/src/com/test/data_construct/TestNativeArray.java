package com.test.data_construct;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class TestNativeArray {
    @Test
    public void test1(){
        NativeArray na = new NativeArray();
        na.add(15);
        na.add(new Apple());
        for (int i = 0; i < 10; i++) {
            na.insert(1,i);
        }
        System.out.println(na.get(1));
        System.out.println(na.arrLength());
//        System.out.println(na.sise());
//        na.insert(2,"33");
        System.out.println(Arrays.toString(na.getAll()));
        na.delete(2);
        System.out.println(Arrays.toString(na.getAll()));
        System.out.println(na.indexOf(1));
        na.remove(111);
        na.remove(3);
    }
}
class Apple{
    @Override
    public String toString() {
        return "Apple{}";
    }
}

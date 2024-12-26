package com.test.interfacetest;

import java.util.Arrays;

public class TestComparableSort {
    public static void main(String[] args) {
        Students2[] all = new Students2[3];
        all[0] = new Students2("张三",18,56);
        all[1] = new Students2("李四",19,38);
        all[2] = new Students2("王五",20,100);
        Arrays.sort(all);
        for (int i = 0; i < all.length; i++) {
            System.out.println(all[i]);
        }
    }
}

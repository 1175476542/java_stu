package com.test.testclass;

import java.util.Arrays;

/*
API:
java.util.Arrays:
 */
public class TestArrayTool {
    public static void main(String[] args) {
        int [] a = {1,3,5,7,9};
        System.out.println(Arrays.binarySearch(a,3));//key是要找的值，找到返回下标，没找到返回负数
        System.out.println(Arrays.binarySearch(a,10));
    }
}

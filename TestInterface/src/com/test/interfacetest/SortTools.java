package com.test.interfacetest;

import java.util.Comparator;

public class SortTools {
    public static void sort(Object[] arr, Comparator comparator){
        for (int i = 1; i < arr.length ; i++) {
            for (int j = 0; j < arr.length-i; j++) {
                System.out.println("比较：arr["+j+"]和arr["+(j+1)+"]");
                System.out.println(arr[j]);
                System.out.println(arr[j+1]);
                System.out.println();
                if (comparator.compare(arr[j],arr[j+1])>0){
                    Object temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
//        System.out.println(arr.toString());
    }
}

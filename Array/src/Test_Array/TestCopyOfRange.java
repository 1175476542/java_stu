package Test_Array;

import java.util.Arrays;

public class TestCopyOfRange {
    public static void main(String[] args) {
        int[] arr = {1,3,5,7,9};
        int[] newarr = Arrays.copyOfRange(arr,0,3);
        newarr = Arrays.copyOfRange(arr,3,9);//右边超过自动加
        newarr = Arrays.copyOfRange(arr,9,13);//左边超过报错
        for (int i = 0;i< newarr.length;i++){
            System.out.println(newarr[i]);
        }
    }
}

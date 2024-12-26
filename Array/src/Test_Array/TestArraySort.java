package Test_Array;

import java.util.Arrays;

public class TestArraySort {
    public static void main(String[] args) {
        int[] arr = {5,6,8,7,3,1,6};
        Arrays.sort(arr);
        for (int  i = 0;i< arr.length;i++){
            System.out.println(arr[i]);
        }
    }
}

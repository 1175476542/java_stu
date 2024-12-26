package Test_Array;

import java.util.Arrays;

public class TestCopyOf {
    public static void main(String[] args) {
        int [] arr = {1,3,5,7,9};
//        int[] newArr = Arrays.copyOf(arr,5);//5是新数组长度
//        int[] newArr = Arrays.copyOf(arr,15);//新数组超过原来数组长度时会自动增加病初始化
        int[] newArr = Arrays.copyOf(arr,3);//没有超过则按newLength截取
        for (int i = 0;i< newArr.length;i++){
            System.out.println(newArr[i]);
        }
    }


}

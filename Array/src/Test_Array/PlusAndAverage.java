package Test_Array;

import java.util.Scanner;

public class PlusAndAverage {
    public static void main(String[] args) {
        int[] array = new int[10];
        int sum = 0;
        double average = 0;
        for (int i = 0;i<array.length;i++){
            System.out.println("请输入第"+(i+1)+"个数：");
            java.util.Scanner input = new Scanner(System.in);
            array[i] = input.nextInt();
            sum = sum + array[i];
        }
        average =(double)sum/array.length;
        System.out.println("和为："+sum+"平均数为："+average);
    }
}

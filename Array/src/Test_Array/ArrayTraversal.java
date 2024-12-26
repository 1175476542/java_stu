package Test_Array;

import java.util.Scanner;

public class ArrayTraversal {
    public static void main(String[] args) {
        System.out.println("请输入人数：");
        java.util.Scanner input = new java.util.Scanner(System.in);
        int count = input.nextInt();
        int[] scores = new int[count];
        for (int i = 0;i<count;i++){
            System.out.println("请输入第" +(i+1) +"个学生的分数");
            scores[i] = input.nextInt();
        }
        System.out.println("学生们分数如下：");
        for (int i = 0;i<scores.length;i++){

            System.out.println(scores[i]);
        }
    }
}

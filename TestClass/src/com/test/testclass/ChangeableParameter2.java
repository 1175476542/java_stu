package com.test.testclass;

public class ChangeableParameter2 {
    //求1到n个数相加
    //第一个不是可变参数
    //第一个是非可变参数，必须传值
    /*
    注意：
        一个方法只能包含一个可变参数
        可变参数必须放在形参列表最后
     */
    public static void main(String[] args) {
        System.out.println(add(1,3,5,7,9));
        System.out.println(max(1,3,5,7,9));
    }
    public static int add(int num1,int... nums){
        int sum = num1;
        for (int i = 0;i<nums.length;i++){
            sum+=nums[i];
        }
        return sum;
    }


    public static int max(int num1,int... nums){
//        int max = 0;
        for (int i = 0;i<nums.length;i++){
            if (num1<nums[i]){
                num1 = nums[i];
            }
        }
        return num1;
    }

}

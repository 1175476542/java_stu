package com.test.testclass;
//不能和数组参数同时出现
public class ChangeableParameters {

    public static void main(String[] args) {
        System.out.println(add(1,2,3,4,5));
        System.out.println(add(1,2,3));
    }
    public static int add(int... nums){
        int sum = 0;
        for (int i = 0; i< nums.length;i++){
            sum = sum +nums[i];
        }
        return sum;
    }
}

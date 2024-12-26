package com.test.testclass;

public class TestTemplate {
    public static void main(String[] args) {
        Calcu c = new Calcu();
        long time = c.calculate();
        System.out.println("花费了" + time + "的时间");
    }
}
abstract class CalculateTime{
    public  long calculate(){
        long start = System.currentTimeMillis();
        doWork();
        long end = System.currentTimeMillis();
        System.out.println(end - start);
        return end - start;
    }
    public abstract void doWork();
}
class Calcu extends CalculateTime{
    public void doWork(){
        int sum = 1;
        for (int i =2;i<10;i++){
            sum *= i;
        }
        System.out.println(sum);
    }
}
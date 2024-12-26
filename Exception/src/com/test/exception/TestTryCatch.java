package com.test.exception;

public class TestTryCatch {
    public static void main(String[] args) {
        //从命令行参数接受两个整数
        try{
            int a = Integer.parseInt(args[0]);
            int b = Integer.parseInt(args[1]);
            System.out.println(a);
            System.out.println(b);
        }catch (NumberFormatException e){
//            e.printStackTrace();
            System.err.println(e.getMessage());
        }catch (ArrayIndexOutOfBoundsException e){
//            e.printStackTrace();
            System.err.println(e.getMessage());
        }catch (ArithmeticException e){
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }


        System.out.println("其它代码");
    }
}

package com.test.exception;

public class TestDefine {
    public static void main(String[] args) {
        Account1 a = new Account1("111",1000,-1);

        try {
            a.withDraw();
        }catch (MoneyConnotNegativeException e){
//            System.err.println(e.getMessage());
            e.printStackTrace();
        }


    }
}
class MoneyConnotNegativeException extends Exception{
    public MoneyConnotNegativeException() {

    }

    public MoneyConnotNegativeException(String message) {
        super(message);
    }
}
class Account1{
    private String id;
    private double money;
    private double out;

    public Account1() {
    }

    public Account1(String id, double money, double out) {
        this.id = id;
        this.money = money;
        this.out = out;
    }

    public String getId() {
        return id;
    }

    public double getMoney() {
        return money;
    }

    public double getOut() {
        return out;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public void setOut(double out) {
        this.out = out;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id='" + id + '\'' +
                ", money=" + money +
                ", out=" + out +
                '}';
    }
    public void withDraw() throws MoneyConnotNegativeException{
        if (money<out){
            throw new  RuntimeException("余额不足");
        } else if (out<0) {
            throw new MoneyConnotNegativeException("非法参数");//因为这里包含编译时异常，所以要加throws或者try...catch
        }else {
            money -=out;
        }
    }
}
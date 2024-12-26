package com.test.exception;

public class TestThrow {
    public static void main(String[] args) {
        Account a = new Account("111",1000,300);
        Account a1 = new Account("222",1000,-1);
        try {
            a.withDraw();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            System.out.println(a);
        }
        try {
            a1.withDraw();
        }catch (Exception e){
            System.err.println(e.getMessage());
        }finally {
            System.out.println(a1);
        }



    }
}

class Account{
    private String id;
    private double money;
    private double out;

    public Account() {
    }

    public Account(String id, double money, double out) {
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
    public void withDraw() throws Exception{
        if (money<out){
            throw new  RuntimeException("余额不足");
        } else if (out<0) {
            throw new Exception("非法参数");//因为这里包含编译时异常，所以要加throws或者try...catch
        }else {
            money -=out;
        }
    }
}
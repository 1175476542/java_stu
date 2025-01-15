package com.test.lambda;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class LambdaSentence {
    @Test
    public void test(){
        ArrayList<String> list = new ArrayList<String>();
        list.add("你从丹东来");
        list.add("换我一城雪白");
        list.add("想吃广东菜");
        list.add("要记得将军的恩情");
        list.add("核爆近距离观察员");
        list.forEach((str)->{
            System.out.println(str);
        });
        list.forEach(str-> System.out.println(str));
        list.removeIf(str-> str.length()>6);
    }
}

package com.test.lambda;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;

public class LambdaTest2 {
    @Test
    public void test() {
        Students[] s = new Students[5];
        s[0] = new Students(1, "将军");
        s[1] = new Students(2, "金正恩");
        s[2] = new Students(3, "核弹近距离观察员");
        s[3] = new Students(4, "紫蛋");
        s[4] = new Students(5, "你从丹东来");
        Arrays.sort(s);//按照自然顺序排序
        for (Students student : s) {
            System.out.println(student);
        }
        System.out.println("----------------");
        Arrays.sort(s, new NameComparator());//按照定制顺序排序
        for (Students student : s) {
            System.out.println(student);
        }
    }

    @Test
    public void test2() {
        Students[] s = new Students[5];
        s[0] = new Students(1, "将军");
        s[1] = new Students(2, "金正恩");
        s[2] = new Students(3, "核弹近距离观察员");
        s[3] = new Students(4, "紫蛋");
        s[4] = new Students(5, "你从丹东来");
        Arrays.sort(s, new Comparator<Students>() {
            @Override
            public int compare(Students o1, Students o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });//按照定制顺序排序,匿名捏不累实现
        for (Students student : s) {
            System.out.println(student);
        }
    }
    @Test
    public void test3(){
        Students[] s = new Students[5];
        s[0] = new Students(1, "将军");
        s[1] = new Students(2, "金正恩");
        s[2] = new Students(3, "核弹近距离观察员");
        s[3] = new Students(4, "紫蛋");
        s[4] = new Students(5, "你从丹东来");
        //Lambda表达式
        Arrays.sort(s,(o1,o2)->{
            return o1.getName().compareTo(o2.getName());
        });
        for (Students student : s) {
            System.out.println(student);
        }
    }
}

class NameComparator implements Comparator<Students> {
    @Override
    public int compare(Students o1, Students o2) {
        return o1.getName().compareTo(o2.getName());
    }
}

class Students implements Comparable<Students> {
    private int id;
    private String name;

    public Students() {
    }

    public Students(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Students{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public int compareTo(Students o) {
        return this.id - o.id;
    }
}
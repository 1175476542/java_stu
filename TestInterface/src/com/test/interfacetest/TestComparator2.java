package com.test.interfacetest;

import java.util.Comparator;

public class TestComparator2 {
    public static void main(String[] args) {
        Students1[] obj = new Students1[3];
        obj[0] = new Students1("张三",18,56);
        obj[1] = new Students1("李四",19,76);
        obj[2] = new Students1("王五",20,100);
        SortTools.sort(obj,new AgeCompare());
        for (int i = 0; i < obj.length; i++) {
            System.out.println(obj[i].toString());
        }
    }
}
class Students1{
    private String name;
    private int age;
    private int score;

    public Students1() {
    }

    public Students1(String name, int age, int score) {
        this.name = name;
        this.age = age;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getScore() {
        return score;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Students1{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", score=" + score +
                '}';
    }
}

class AgeCompare implements Comparator {
    @Override
    public int compare(Object o1, Object o2) {
        Students1 s1 = (Students1) o1;
        Students1 s2 = (Students1) o2;
//        if (s1.getAge()> s2.getAge()){
//            return 1;
//        }else if (s1.getAge()<s1.getAge()){
//            return  -1;
//        }else return 0;
//        可以浓缩为
        return s1.getAge()-s2.getAge();
    }
}

package com.test.interfacetest;

import java.util.Arrays;
import java.util.Comparator;

public class TestComparator {
    public static void main(String[] args) {
        Students s1 = new Students("张三",15,86);
        Students s2 = new Students("李四",30,77);
        Compare c = new Compare();
        ScoreCompare s = new ScoreCompare();
        if (c.compare(s1,s2)>0){
            System.out.println(s1.getName()+"大于"+s2.getName());
        } else if (c.compare(s1,s2)<0) {
            System.out.println(s1.getName()+"小于"+s2.getName());
        }else if (c.compare(s1,s2) == 0){
            System.out.println("两者相等");
        }


        if (s.compare(s1,s2)>0){
            System.out.println(s1.getName()+"大于"+s2.getName());
        } else if (s.compare(s1,s2)<0) {
            System.out.println(s1.getName()+"小于"+s2.getName());
        }else if (s.compare(s1,s2) == 0){
            System.out.println("两者相等");
        }
        Students[] all = new Students[5];
        all[0] = new Students("张三",15,86);
        all[1] = new Students("李四",25,23);
        all[2] = new Students("王五",16,35);
        all[3] = new Students("赵六",92,76);
        all[4] = new Students("周七",35,83);
        Arrays.sort(all,new Compare());
        for (int i = 0; i < all.length; i++) {
            System.out.println(all[i].toString());

        }
    }
}
class Compare implements Comparator{
    @Override
    public int compare(Object o1, Object o2) {
        Students s1 = (Students)o1;
        Students s2 = (Students)o2;
        if (s1.getAge()>s2.getAge()){
            return 1;
        } else if (s1.getAge()<s2.getAge()) {
            return -1;
        }else return 0;
    }
}
class ScoreCompare implements Comparator{
    @Override
    public int compare(Object o1, Object o2) {
        Students s1 = (Students)o1;
        Students s2 = (Students)o2;
        if (s1.getScore()>s2.getScore()){
            return 1;
        } else if (s1.getScore()<s2.getScore()) {
            return -1;
        }else return 0;
    }
}
class Students{
    private String name;
    private int age;
    private int score;

    public Students() {
    }

    public Students(String name, int age, int score) {
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
        return "Students{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", score=" + score +
                '}';
    }
}
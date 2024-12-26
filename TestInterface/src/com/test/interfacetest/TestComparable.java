package com.test.interfacetest;

public class TestComparable {
    public static void main(String[] args) {
        Students2[] obj = new Students2[3];
        obj[0] = new Students2("张三",18,56);
        obj[1] = new Students2("李四",19,76);
        obj[2] = new Students2("王五",20,100);
        if (obj[0].compareTo(obj[1])>0){
            System.out.println("obj[0]>obj[1]");
        } else if (obj[0].compareTo(obj[1])<0) {
            System.out.println("obj[0]<obj[1]");
        }else {
            System.out.println("obj[0]=obj[1]");
        }
    }
}
class Students2 implements Comparable{
    private String name;
    private int age;
    private int score;

    public Students2() {
    }

    public Students2(String name, int age, int score) {
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
    public int compareTo(Object obj){
        Students2 s = (Students2) obj;
        //按照成绩排名就可以吧自然顺序定为成绩
//        if (this.score>s.score) return 1;
//        else if (this.score<s.score) return -1;
//        else return 0;

        //因为是int类型所以可以写成
        return this.score-s.score;
    }
}
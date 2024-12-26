package com.classTest;

public class StudentDemo {
    public static void main(String[] args) {
        Student s1 = new Student();
        s1.setName("caoxiaoyu");
        s1.setAge(18);
        s1.show();
        Student s2 = new Student("曹啸宇", 25);
        s2.show();
    }
}

package com.test.enumeration;

public class TestEnum2 {
    public static void main(String[] args) {
        Season s = Season.SUMMER;
        System.out.println(Season.SPRING);
        System.out.println(s);
        System.out.println(s.name());
        System.out.println(s.ordinal());
        System.out.println("----------------");
        Season[] s1 = Season.values();
        for (int i = 0; i < s1.length; i++) {
            System.out.println(s1[i]);
        }
        System.out.println("----------");
        Season spring = Season.valueOf("SPRING");
        System.out.println(spring);
    }
}
enum Season{
    //没有值的调用无参构造，有参的调用有参构造
    SPRING("春天"),SUMMER("夏天"),
    AUTUMN("秋天"),WINTER;
    private String description;

    private Season() {
    }

    private Season(String description) {
        this.description = description;
    }
    public String toString(){
        return name() + ":" + description;
    }
}
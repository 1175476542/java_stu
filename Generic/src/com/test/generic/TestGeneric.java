package com.test.generic;

import org.junit.jupiter.api.Test;

import java.util.*;

public class TestGeneric {
    public static void main(String[] args) {

    }
}
class TestGeneric1{
    @Test
    public void test(){
        ArrayList list = new ArrayList();
        list.add("红楼梦");
        list.add("西游记");
        list.add("水浒传");
        list.add(3);
//        使用时不知道里面是什么，统统按照Object
        for(Object obj:list){
            //强转很麻烦
            String name = (String) obj;
            System.out.println(name.length());//强转有风险，可能会把原本的类型弄混
        }
    }
    @Test
    public void test2(){
        //求两数之和
        //在完成这个功能的时候，不确定，要求的两个整数的值，我通过形参让调用者告诉我整数的值
        //a，b叫做形参，调用时由实参赋值
        //为了区别，把a和b成为数据形参，因为a和b穿的是数据值，不是类型
        ArrayList<String> list = new ArrayList();
        list.add("红楼梦");
        list.add("水浒传");
        list.add("西游记");
    //        list.add(3);//直接报错，因为限定了String类型
        //此时不需要用Object处理了，因为他知道里面的元素是String
        for(Object obj:list){
            System.out.println(obj);
        }
    }
    @Test
    public void test3(){
        //语文老师
        Students<String> s1 = new Students<String>("张三","优秀");
        Students<Integer> s2 = new Students<Integer>("李四",66);
        Students<Character> s3 = new Students<Character>("王五",'A');
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
    }
    @Test
    public void test4(){
        List<Integer> list = Arrays.asList(1,2,3,4,5);
        List<String> list1 = Arrays.asList("hello","java");
    }
    @Test
    public void test5(){
        test6(1);
        test6(1.0);
//        test6("张三");//错误
    }
    public <T extends Number> T test6(T t){
        return t;
    }
    @Test
    public void test7(){
        List<Integer> list = Arrays.asList(1,2,3,4);
        print(list);
    }


    public void print(Collection<?> c){
//    public void print(Collection<Object> c){//这个是错误的
        for(Object obj:c){
            System.out.println(obj);
        }
    }
    @Test
    public void test8(){
        Collection<String> c = new ArrayList<String>();
        c.add("张三");
        Collection<Integer> c1 = new ArrayList<Integer>();
        c1.add(1);
        System.out.println(Collections.disjoint(c, c1));
    }
    @Test
    public void test9(){
        ArrayList<String> list = new ArrayList<String >();
//        printGraphic(list);//错误的
        ArrayList<Circle> list1 = new ArrayList<Circle>();
        printGraphic(list1);
    }
    public void printGraphic(Collection<? extends Graphic> graphic){
        for(Object obj:graphic){
            System.out.println(obj);
        }
    }
    @Test
    public void test10(){
        //把一个Collection集合的元素，添加到另一个Collection集合dest中
        Collection<String> src = new ArrayList<String>();
        src.add("hello");
        src.add("java");
        Collection<Integer> dest = new ArrayList<Integer>();
        dest.add(1);
        dest.add(2);
//        copy(src,dest);//错误的
        Collection<Object> dest1  = new ArrayList<Object>();
        copy(src,dest1);
    }

    public <T>void copy(Collection<T> src,Collection<? super T> dest){
        for(T obj : src){
            dest.add(obj);
        }
    }
}
/*
//自定义一个泛型类：
定义一个特殊的学生类，学生类包含两个属性：姓名，成绩
此时成绩的情况很复杂
语文老师在表示学生时：成绩登记为：优秀、良好、及格、不及格
数学老师在表示学生时：成绩登记为：95、90...
语文老师在表示学生时：成绩登记为：A、B、C...


*/


class Graphic{

}
class Circle extends Graphic{

}
class Rectangle extends Graphic{

}

class Students<T>{
    private String name;
    private T score;
    public Students(){

    }
    public Students(String name){
        this.name = name;
    }
    public Students(T score){
        this.score = score;
    }
    public Students(String name,T score){
        this.name = name;
        this.score = score;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setScore(T score){
        this.score = score;
    }
    public String getName(){
        return this.name;
    }
    public T getScore(){
        return this.score;
    }

    @Override
    public String toString() {
        return "Students{" +
                "name='" + name + '\'' +
                ", score=" + score +
                '}';
    }



}


package com.test.file;

import java.io.Serializable;

public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    private String name;
    private String password;
    private int age;
    private char gender;
    private String address;
    public User(){
    }
    public User(String name,String password,int age){
        this.name = name;
        this.password = password;
        this.age = age;
    }
    public User(String name,String password,int age,char gender){
        this.name = name;
        this.password = password;
        this.age = age;
        this.gender = gender;
    }

    public String getName(){
        return name;
    }
    public String getPassword(){
        return password;
    }
    public int getAge(){
        return age;
    }

    public char getGender() {
        return gender;
    }

    public void setName(String name){
        this.name = name;
    }
    public void  setPassword(String password){
        this.password = password;
    }
    public void setAge(int age){
        this.age = age;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                ", address='" + address + '\'' +
                '}';
    }
}

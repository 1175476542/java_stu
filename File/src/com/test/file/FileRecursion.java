package com.test.file;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileFilter;

public class FileRecursion {
    public static void main(String[] args) {

    }
}

class Test2 {
    @Test
    public void test1() {
        //得到下一级目录名（字符串）
        File file = new File("../file");
        String[] list = file.list();
//        for (int i = 0; i < list.length; i++) {
//            System.out.println(list[i]);
//        }
        for (Object obj : list) {
            System.out.println(obj);
        }
    }

    @Test
    public void test2() {
        //得到下一级目录对象
        File file = new File("{path}");
        listAllSub(file);
    }
    public void listAllSub(File file) {
        if (file.isDirectory()) {
            File[] fileList = file.listFiles();
            for(File dir:fileList){
                listAllSub(dir);
//                System.out.println(dir);
            }
        }else {
            System.out.println(file);
        }
    }
    @Test
    public void test3(){
        File file = new File("{path}");
        System.out.println(getLength(file));

    }
    public long getLength(File file){

        if(file.isFile()){
            return file.length();
        } else {
            long sum = 0;
            File[] fileList = file.listFiles();
            for(File dir:fileList){
                sum += getLength(dir);
            }
            return sum;
        }
//        return 0;
    }
    @Test
    public void test4(){
        File file = new File("{path}");
        deleteAllFile(file);
    }
    public void deleteAllFile(File file){
            if(file.isDirectory()){
            File[] fileList = file.listFiles();
            for(File dir:fileList){
                dir.delete();
                deleteAllFile(dir);
            }
        }else if(file.isFile()){
            file.delete();
        }
    }
    @Test
    public void test5(){
        File file = new File("F:\\笔记\\java");
        File[] listFiles = file.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
             return pathname.getName().endsWith(".md") &&
                     pathname.getName().contains("s");
            }
        });
        for(File list:listFiles){
            System.out.println(list);
        }
    }
    @Test
    public void test6(){

    }
}
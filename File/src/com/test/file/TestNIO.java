package com.test.file;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

public class TestNIO {
    @Test
    public void test(){
        Path file = Paths.get("test","1.txt");
        int count = file.getNameCount();
        System.out.println(count);
        Path name = file.getName(1);
        System.out.println(name);
    }
    @Test
    public void test2() throws IOException {
        Path src = Paths.get("test","1.txt");
        Path dest = Paths.get("test","2.txt");
        Files.copy(src,dest, StandardCopyOption.REPLACE_EXISTING);
    }
    @Test
    public void test3() throws IOException {
        //当文件不存在时会报错
        Path path =  Paths.get("test","2.txt");
        Files.delete(path);
    }
    @Test
    public void test4Move() throws IOException {
        Path src = Paths.get("test2.txt");
        Path dest =  Paths.get("test","2.txt");
        Files.move(src,dest,StandardCopyOption.REPLACE_EXISTING);
    }
    @Test
    public void test5Read() throws IOException {
        Path path  = Paths.get("test","1.txt");
        List<String> allLines = Files.readAllLines(path, Charset.forName("utf-8"));
        for(String str:allLines){
            System.out.println(str);
        }
    }
}

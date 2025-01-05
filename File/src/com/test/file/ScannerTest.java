package com.test.file;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class ScannerTest {
    @Test
    public void test() throws IOException {
        Scanner sc = new Scanner(new FileInputStream("Geforce.txt"));
        while(sc.hasNextLine()){
            System.out.println(sc.nextLine());
        }
        sc.close();
    }
    @Test
    public void test2(){
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        System.out.println(num);
    }
    @Test
    public void test3() throws IOException{
        Scanner sc = new Scanner(new File("Geforce.txt","GBK"));
        while(sc.hasNextLine()){
            System.out.println(sc.nextLine());
        }
        sc.close();
    }
}

package com.test.file;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.PrintStream;

public class SystemIO {
    @Test
    public void test(){
        //System的IO流
        PrintStream out = System.out;
        System.out.println(out);
    }
    @Test
    public void test2() throws FileNotFoundException {
        System.setOut(new PrintStream("Geforce.txt"));
        System.out.println("4080");
    }
}

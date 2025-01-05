package com.test.file;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.PrintStream;

public class PrintStreamTest {
    public static void main(String[] args) {
        
    }
}
class TestPrintStream{
    @Test
    public void test(){
        PrintStream ps = System.out;
        ps.println("hello");
        ps.println();
    }
    @Test
    public void test1() throws FileNotFoundException {
        PrintStream ps = new PrintStream("Geforce.txt");
        ps.println("4070TI");
        ps.println("4070TI Super");
        ps.close();

    }
}

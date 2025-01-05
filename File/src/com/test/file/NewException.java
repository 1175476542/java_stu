package com.test.file;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.shadow.com.univocity.parsers.common.processor.InputValueSwitch;

import java.io.*;

public class NewException {
    @Test
    public void test1() {
        //从d:/1.txt(GBK)文件中，读取内容，写到项目根目录下1.txt(UTF-8)文件中
        try(
                FileInputStream fis = new FileInputStream("Geforce.txt");
                InputStreamReader isr = new InputStreamReader(fis,"GBK");
                BufferedReader br = new BufferedReader(isr);

                FileOutputStream fos = new FileOutputStream("Geforce.txt");
                OutputStreamWriter osw = new OutputStreamWriter(fos,"UTF-8");
                BufferedWriter bw = new BufferedWriter(osw);
        ){
            String str;
            while((str = br.readLine()) != null){
                bw.write(str);
                bw.newLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test02() {
        //从d:/1.txt(GBK)文件中，读取内容，写到项目根目录下1.txt(UTF-8)文件中
        BufferedReader br = null;
        BufferedWriter bw = null;
        try {
            br = new BufferedReader(new InputStreamReader(new FileInputStream("Geforcetxt"),"GBK"));
            bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("Geforce.txt"),"UTF-8"));

            String str;
            while((str = br.readLine()) != null){
                bw.write(str);
                bw.newLine();
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            try {
                if(bw!=null){
                    bw.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if(br!=null){
                    br.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    @Test
    public void test01(){
        //从d:/1.txt(GBK)文件中，读取内容，写到项目根目录下1.txt(UTF-8)文件中
        FileInputStream fis = null;
        InputStreamReader isr = null;
        BufferedReader br = null;
        FileOutputStream fos = null;
        OutputStreamWriter osw = null;
        BufferedWriter bw = null;
        try {
            fis = new FileInputStream("Geforce.txt");
            isr = new InputStreamReader(fis,"GBK");
            br = new BufferedReader(isr);

            fos = new FileOutputStream("Geforce.txt");
            osw = new OutputStreamWriter(fos,"UTF-8");
            bw = new BufferedWriter(osw);

            String str;
            while((str = br.readLine()) != null){
                bw.write(str);
                bw.newLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            try {
                if(bw!=null){
                    bw.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if(osw!=null){
                    osw.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if(fos!=null){
                    fos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                if(br!=null){
                    br.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if(isr!=null){
                    isr.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if(fis!=null){
                    fis.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

/*	public static void main(String[] args) {
		//从d:/1.txt(GBK)文件中，读取内容，写到项目根目录下1.txt(UTF-8)文件中
		FileInputStream fis = new FileInputStream("Geforce.txt");
		InputStreamReader isr = new InputStreamReader(fis,"GBK");
		BufferedReader br = new BufferedReader(isr);

		FileOutputStream fos = new FileOutputStream("Geforce.txt");
		OutputStreamWriter osw = new OutputStreamWriter(fos,"UTF-8");
		BufferedWriter bw = new BufferedWriter(osw);

		String str;
		while((str = br.readLine()) != null){
			bw.write(str);
			bw.newLine();
		}

		bw.close();
		osw.close();
		fos.close();

		br.close();
		isr.close();
		fis.close();

	}*/
}

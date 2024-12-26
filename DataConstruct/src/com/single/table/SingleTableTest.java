package com.single.table;

import java.util.Arrays;

public class SingleTableTest {
    public static void main(String[] args) {
        SingleTable st = new SingleTable();
        st.add("张三");
        st.add("张四");
        st.add("张五");
        System.out.println(st.size());
        System.out.println(Arrays.toString(st.getAll()));
    }
}

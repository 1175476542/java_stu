package com.test.data_construct;

import java.util.Arrays;

public class NativeArray {
    private Object[] arr;
    private int total;

    public NativeArray() {
        arr = new Object[5];
    }

    public void add(Object o) {
        extracted();
        arr[total++] = o;
    }

    private void extracted() {
        if (total >= arr.length) {
            arr = Arrays.copyOf(arr, arr.length * 2);
        }
    }

    public int sise() {
        return total;
    }

    public int arrLength() {
        return arr.length;
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= arr.length) {
            throw new ArrayIndexOutOfBoundsException("数组下标溢出");
        }
    }

    public Object get(int index) {
        checkIndex(index);
        return arr[index].toString();
    }

    public void set(int index, Object o) {
        checkIndex(index);
        arr[index] = o;
    }

    public void insert(int index, Object o) {
        checkIndex(index);


        extracted();
        System.arraycopy(arr, index, arr, index + 1, total - index);
        arr[index] = o;
        total++;
    }

    public Object[] getAll() {
        return Arrays.copyOf(arr, total);
    }

    public void delete(int index) {
        checkIndex(index);
        System.arraycopy(arr, index + 1, arr, index, total - index - 1);
        arr[total - 1] = null;
        total--;
    }

    public int indexOf(Object obj) {
        if (obj == null) {
            for (int i = 0; i < total; i++) {
                if (arr[i] == null){
                    return i;
                }
            }
        } else {
            for (int i = 0; i < total; i++) {
                if (obj.equals(arr[i])) {
                    return i;
                }
            }
        }
        return -1;
    }
    public void remove(Object obj){
        int index = indexOf(obj);
        if (index!=-1){
            delete(index);
        }else {
            System.out.println("数组下标不存在");
        }
    }
    public void set(Object old,Object value){
        //先查询
        int index = indexOf(old);
        if (index!=-1){
            set(index,value);
        }else{
            System.out.println("不存在");
        }
    }
}

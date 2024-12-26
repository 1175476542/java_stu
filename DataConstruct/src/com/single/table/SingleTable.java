package com.single.table;

public class SingleTable {
    private Node first;
    private int total;
    class Node{
        Object data;
        Node next;

        Node(Object data,Node next){
            this.data = data;
            this.next = next;
        }
    }
    public void add(Object obj){
       Node node =  new Node(obj,null) ;
       if (first == null){
           first = node;
       }else {
           Node nodeList = first;
           while (nodeList.next!=null){
               nodeList = nodeList.next;
           }
           nodeList.next = node;
       }
       total++;
    }
    public int size(){
        return total;
    }
    public Object[] getAll(){
        Object[] obj = new Object[total];
        Node node = first;
        for (int i = 0; i < total; i++) {
            obj[i] = node.data;
            node= node.next;
        }
        return obj;
    }
    public void remove(Object obj){
        if(obj == null){
            //(1)先考虑是否是第一个
            if(first!=null){//链表非空

                //要删除的结点正好是第一个结点
                if(first.data == null){
                    //让第一个结点指向它的下一个
                    first = first.next;
                    total--;
                    return;
                }

                //要删除的不是第一个结点
                Node node = first.next;//第二个结点
                Node last = first;
                while(node.next!=null){//这里不包括最后一个，因为node.next==null，不进入循环，而node.next==null是最后一个
                    if(node.data == null){
                        last.next = node.next;
                        total--;
                        return;
                    }
                    last = node;
                    node = node.next;
                }

                //单独判断最后一个是否是要删除的结点
                if(node.data == null){
                    //要删除的是最后一个结点
                    last.next = null;
                    total--;
                    return;
                }
            }
        }else{
            //(1)先考虑是否是第一个
            if(first!=null){//链表非空

                //要删除的结点正好是第一个结点
                if(obj.equals(first.data)){
                    //让第一个结点指向它的下一个
                    first = first.next;
                    total--;
                    return;
                }

                //要删除的不是第一个结点
                Node node = first.next;//第二个结点
                Node last = first;
                while(node.next!=null){//这里不包括最后一个，因为node.next==null，不进入循环，而node.next==null是最后一个
                    if(obj.equals(node.data)){
                        last.next = node.next;
                        total--;
                        return;
                    }
                    last = node;
                    node = node.next;
                }

                //单独判断最后一个是否是要删除的结点
                if(obj.equals(node.data)){
                    //要删除的是最后一个结点
                    last.next = null;
                    total--;
                    return;
                }
            }
        }
    }
}

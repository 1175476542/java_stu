package com.test.collection;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.*;

public class TestMap {
    @Test
    public void test1(){
        Map m = new HashMap();
        Map m1 = new HashMap();
        Map m2 = new HashMap();
        m.put("红楼","曹雪芹");
        m.put("三国演义","罗贯中");
        m.put("水浒传","施耐庵");
        m.put("西游记","吴承恩");
        System.out.println(m.size());//4
        System.out.println(m.isEmpty());//false
        System.out.println(m1.isEmpty());//true
        System.out.println(m.containsKey("红楼"));//true
        System.out.println(m.containsKey("曹雪芹"));//false,曹雪芹对应value
        System.out.println(m.containsValue("曹雪芹"));//true
        System.out.println(m.get("红楼"));//返回key对应的value
        System.out.println(m.remove("红楼"));//删除key为红楼的键值对
        Set s = m.keySet();
        System.out.println(s);//返回键集合
        System.out.println(m.entrySet());//返回键值对
    }
    @Test
    public void test2(){
        //Map的遍历
        Map m = new HashMap();
        m.put("红楼","曹雪芹");
        m.put("三国演义","罗贯中");
        m.put("水浒传","施耐庵");
        m.put("西游记","吴承恩");
        Set keys = m.keySet();
        System.out.println(keys);
        for (Object key : keys) {
            System.out.println(key+"=>"+m.get(key));
        }
    }
    @Test
    public void test3(){
        Map m = new HashMap();
        m.put("红楼","曹雪芹");
        m.put("三国演义","罗贯中");
        m.put("水浒传","施耐庵");
        m.put("西游记","吴承恩");
        Set set = m.entrySet();
        for (Object obj :
                set) {
            System.out.println(obj);
        }
    }
    @Test
    public void test4(){
        Map map = new HashMap();
        String[] s = {"西游记","水浒传","三国演义","红楼梦"};
        ArrayList list = new ArrayList();
        list.add("论语");
        list.add("中庸");
        list.add("大学");
        list.add("孟子");
        map.put("cxy",s);
        map.put("cao",list);
        Set entrySet = map.entrySet();
        for(Object obj:entrySet){
            System.out.println(obj);
        }
    }



    //Map的实现类
    @Test
    public void test5(){
        Map m = getMap();
        Map m1 = new LinkedHashMap();//
        m.put("红楼","曹雪芹");
        m.put("三国演义","罗贯中");
        m.put("水浒传","施耐庵");
        m.put("西游记","吴承恩");


        Set entry = m.entrySet();

        for(Object obj:entry){
            System.out.println(obj);
        }
        System.out.println("---------------");
        Set entry1 = m1.entrySet();

        for(Object obj1:entry1){
            System.out.println(obj1);
        }
    }
    @Test
    public void test6(){
        Map map = new TreeMap();//按照key大小
        getMap(map);
        Set entrySet = map.entrySet();
        for(Object obj:entrySet){
            System.out.println(obj);
        }
    }
    @Test
    public void test7(){
        Properties pro = new Properties();
        pro.setProperty("user","caoxiaoyu");
        pro.setProperty("pwd","123456");
        String user = pro.getProperty("user");
        String pwd = pro.getProperty("pwd");
        System.out.println(user);
        System.out.println(pwd);
    }
    @Test
    public void test8() throws IOException {
          Properties pro = new Properties();
          pro.load(TestMap.class.getClassLoader().getResourceAsStream("jdbc.properties"));
          String user = pro.getProperty("user");
          String pwd = pro.getProperty("pwd");
          System.out.println(user);
          System.out.println(pwd);
    }
    @Test
    public void test9(){
        //获取系统属性配置
        Properties pro = System.getProperties();
        Set entry = pro.entrySet();
        for(Object obj:entry){
            System.out.println(obj);
        }
    }

    private static Map getMap(Map m) {
        m.put("红楼","曹雪芹");
        m.put("三国演义","罗贯中");
        m.put("水浒传","施耐庵");
        m.put("西游记","吴承恩");
        return m;
    }
    private static Map getMap() {
        Map m = new HashMap();
        m.put("红楼","曹雪芹");
        m.put("三国演义","罗贯中");
        m.put("水浒传","施耐庵");
        m.put("西游记","吴承恩");
        return m;
    }
}

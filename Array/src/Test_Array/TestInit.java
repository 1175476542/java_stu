package Test_Array;

/*
 * 1、类的初始化
 * 2、实例初始化
 */
public class TestInit {
    public static void main(String[] args) {
        Demo d = new Demo();//2631745
    }
}
class Demo{
    {
        System.out.println("（1）Demo的非静态代码块1");
    }
    static{
        System.out.println("（2）Demo的静态代码块1");
    }
    private static String info = assign();
    private String message = getMessage();
    static{
        System.out.println("（3）Demo的静态代码块2");
    }
    {
        System.out.println("（4）Demo的非静态代码块2");
    }
    public Demo(){
        System.out.println("（5）无参构造");
    }
    public static String assign(){
        System.out.println("（6）assign()方法");
        return "hello";
    }
    public String getMessage(){
        System.out.println("（7）getMessage()方法");
        return "msg";
    }
}
package Test_Array;

/*
 * (1)先完成父类的类初始化
 * (2)再完成子类的类初始化
 * (3)父类的实例初始化方法
 * (4)子类的实例初始化方法
 */
public class TestInit2 {
    public static void main(String[] args) {
        DemoZi zi1 = new DemoZi();
//        System.out.println("-------------------");
//        DemoZi zi2 = new DemoZi();
    }
}
class DemoFu{
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
    public DemoFu(){
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
class DemoZi extends DemoFu{
    {
        System.out.println("（8）");
    }
    static{
        System.out.println("（9）");//9 13 10 8 14 11 12
    }
    private static String info = assign();
    private String message = getMessage();
    static{
        System.out.println("（10）");
    }
    {
        System.out.println("（11）");
    }
    public DemoZi(){
        System.out.println("（12）");
    }
    public static String assign(){
        System.out.println("（13）");
        return "hello";
    }
    public String getMessage(){
        System.out.println("（14）getMessage()方法");
        return "msg";
    }
}
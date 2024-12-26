package Test_Array;

public class Test02_Array {
    public static void main(String[] args) {
        //静态初始化
        int[] scores = new int[]{11,22,33,44,55,66} ;
        //遍历数组
        System.out.println(scores.length);
        for (int index = 0;index<scores.length;index++){
            System.out.println(scores[index]);
        }
        //动态初始化

        int[] scores2= new int[6];
        for (int index = 0,score = 30;index<scores2.length;index++){
            scores2[index] = score;
            score+=10;
            System.out.println(scores2[index]);
        }
        System.out.println(scores2.length);
    }
}

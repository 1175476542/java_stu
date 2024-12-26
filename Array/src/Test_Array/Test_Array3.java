package Test_Array;

public class Test_Array3 {
    public static void main(String[] args) {
        int[] array = {5,84,4,56,4};
        int max = array[0];
        for(int i = 0;i<array.length;i++){
            if (max<array[i]){
                max = array[i];
            }else{
                continue;
            }
        }
        System.out.println("最大值是："+ max);
    }
}

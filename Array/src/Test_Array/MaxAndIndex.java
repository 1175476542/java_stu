package Test_Array;

public class MaxAndIndex {
    public static void main(String[] args) {
        int[] array = {261,45,1,66,121,366};
        int max = array[0];
        int min = array[0];
        int indexMax = 0;
        int indexMin = 0;
        for (int i = 0;i<array.length;i++){
            if (max<array[i]){
                max = array[i];
                indexMax = i;
            } else if (min>array[i]) {
                min = array[i];
                indexMin = i;
            }
        }
        System.out.println("最大的数是："+ max +"下标是："+indexMax+ "，最小的数是："+min+"下标是："+indexMin);
    }
}

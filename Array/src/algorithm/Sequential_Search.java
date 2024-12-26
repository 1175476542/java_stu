package algorithm;

public class Sequential_Search {
    public static void main(String[] args) {
        int[] arr = {1,65,4,9,2};
        int index = -1;
        int value = 2;
        for (int i = 0;i< arr.length;i++){
            if (arr[i] == value){
                index = i;
                break;
            }
        }
        if (index == -1){
            System.out.println(value + "不存在");
        }else {
            System.out.println(value + "在数组中的下标是：" + index);
        }
    }
}

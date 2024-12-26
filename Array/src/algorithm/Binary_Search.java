package algorithm;
//用于有序的数组查找
public class Binary_Search {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6};
        int value = 8;
        int index = -1;
        int left = 0;
        int right = arr.length-1;
        int mid = (left+right)/2;
        while (left<=right){
            if (arr[mid] == value){
                index = mid;
                break;
            }else if (arr[mid]< value){
                left = mid+1;
            }else {
                right = mid -1;
            }
            mid = (left+right)/2;
        }
        if (index == -1){
            System.out.println(value + "不存在");
        }else {
            System.out.println(value + "的下标是："+ index);
        }
    }
}

package algorithm;

public class Bubble_Sort {
    public static void main(String[] args) {
        int[] arr = {1, 6, 9, 5, 7, 2};
        //从小到大或者从大到小
        //从小到大
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = 0;j< arr.length-i-1;j++){
                if (arr[j]>arr[j+1]){
                    arr[j] = arr[j + 1] + arr[j];
                    arr[j + 1] = arr[j]-arr[j+1];
                    arr[j] = arr[j] - arr[j + 1];
                }else {
                    continue;
                }
            }
        }
        for (int i = 0;i< arr.length;i++){
            System.out.println(arr[i]);
        }
        //从大到小
        System.out.println("从大到小");
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = 0;j< arr.length-i-1;j++){
                if (arr[j]<arr[j+1]){
                    arr[j] = arr[j + 1] + arr[j];
                    arr[j + 1] = arr[j]-arr[j+1];
                    arr[j] = arr[j] - arr[j + 1];
                }else {
                    continue;
                }
            }
        }
        for (int i = 0;i< arr.length;i++){
            System.out.println(arr[i]);
        }
    }
}

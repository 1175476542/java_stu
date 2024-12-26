package algorithm;

public class Direct_Selection_Sort {
    public static void main(String[] args) {
        int[] arr = {1, 5, 3, 4, 6, 9};
        for (int i = 0; i < arr.length - 1; i++) {
            int min =arr[i];
            int index = i;
            for (int j = i+1;j< arr.length;j++){
                if (arr[j]<min){
                    min = arr[j];
                    index = j;
                }
            }
            if (index != i){
                int temp = arr[i];
                arr[i] = arr[index];
                arr[index] = temp;
            }
        }
        for (int i = 0;i<arr.length;i++){
            System.out.println(arr[i]);
        }
    }

}

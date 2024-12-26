package Test_Array;

public class ArrayCopy {
    public static void main(String[] args) {
        char[] arr = new char[26];
        char[] newArr = new char[arr.length];
        for(int i = 0;i<arr.length;i++){
            arr[i] = (char)('a'+i);
        }

        for (int i = 0;i< arr.length;i++){
            newArr[i] = arr[i];
        }
        for (int i = 0;i< newArr.length;i++){
            System.out.println(newArr[i]);
        }
    }
}

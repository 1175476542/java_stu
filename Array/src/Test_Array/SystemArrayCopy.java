package Test_Array;

public class SystemArrayCopy {
    public static void main(String[] args) {
        String[] arr = {"hello","java","today",null,null};
        //实现删除arr[0]
        System.arraycopy(arr,1,arr,0,2);
        arr[2] = null;
        //实现在hello，java之间插入cxy
        System.arraycopy(arr,1,arr,2,2);
        arr[1] = "cxy";
        for (int i = 0;i< arr.length;i++){
            System.out.println(arr[i]);//java today today null null
        }
    }
}

package Test_Array;

public class ArrayLetters {
    public static void main(String[] args) {
        char[] letters = new char[26];
        for (int i = 0;i< letters.length;i++){
            letters[i] = (char) ('a'+i);
        }
        for (int i = 0;i< letters.length;i++){
            System.out.println(letters[i] +"->" + (char)(letters[i]-32));
        }
    }
}

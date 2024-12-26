package Test_Array;

public class ArrayReverse2 {
    public static void main(String[] args) {
        char[] letters = new char[26];
        char buffer;
        for (int i = 0;i<letters.length;i++){
            letters[i] = (char)('a'+i);
        }
        for(int i = 0;i<letters.length/2;i++){
           buffer = letters[i];
           letters[i] = letters[letters.length-1-i];
           letters[letters.length-1-i] = buffer;
        }
        for (int i = 0;i< letters.length;i++){
            System.out.println(letters[i]);
        }
    }
}

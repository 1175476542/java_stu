package Test_Array;

public class ArrayReverse {
    public static void main(String[] args) {
        char[] letter = new char[26];
        for(int i = 0;i< letter.length;i++){
            letter[i] = (char)('a'+i);
//            System.out.println(letter[i]);
        }
        char[] newLetter = new char[26];
        for (int  i = 0;i<newLetter.length;i++){
            newLetter[i] = letter[letter.length-1-i];
//            System.out.println(newLetter[i]);
        }
        letter = newLetter;
        for (int  i = 0;i<letter.length;i++){
//            newLetter[i] = letter[letter.length-1-i];
            System.out.println(letter[i]);
        }
    }
}

package Test_Array;

public class LettersTimes {
    public static void main(String[] args) {
        char[] letters = {'a','b','a','b','a','l','h','o','h','n','g','c',};
        char[] words = new char[26];
        int[] count = new int[26];
        for (int i = 0;i< words.length;i++){
            words[i] = (char)('a'+i);
        }
        for (int i = 0;i< words.length;i++){
            for (int j = 0;j< letters.length;j++){
                if (words[i] == letters[j]){
                    count[i]++;
                    continue;
                }
            }
        }
        for (int i = 0;i<words.length;i++){
            System.out.println(words[i] + "出现的次数为：" + count[i]);
        }
    }
}

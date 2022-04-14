import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public class Permutations {

    public static void main(String args[]) {
        //char[] str = "gol".toCharArray();
        //Scanner sc = new Scanner(System.in);
        //System.out.println(str);
        //permutationFinder(str,0);
        //subString();
        //removeElementFromArray();
        startFindingPermutations("gol");
        //subPermutation();
    }
    /*
        public static void text(String word){

        }
    */
    /**
     * Given any word the method will find all permutations
     * */
    private static String permutationFinder(char[] str, int i) {
        /*char[] ch = word.toCharArray();
        for (char c : ch){
            System.out.println(c);
        }*/
        if (i >= str.length) {
            return null;
        }
        if (i == str.length - 1) {
            String word = String.valueOf(str);
            System.out.println(word);
            return word;
        } else {
            int j = i;
            while (j < str.length) {
                char temp = str[j];
                str[j] = str[i];
                str[i] = temp;
                j++;
                //System.out.println(str);
                permutationFinder(str, i + 1);
            }
        }
        //return word;
        return null;
    }

    private static void startFindingPermutations(String word) {
        //String word = "gol";
        //System.out.println(word.length());
        //permutationFinder(word.toCharArray(),0);
        char[] wordToBePermutaded;

        for (int i = 0; i < word.length() - 1; i++) {
            wordToBePermutaded = word.substring(i).toCharArray();
            permutationFinder(wordToBePermutaded, 0);
            subPermutation(String.valueOf(wordToBePermutaded));
            System.out.println("------");
        }
    }
    /**
     * Given a word the method will find all permutations possible
     * */
    private static void subPermutation(String subWord) {
        //String subWord = "gol";
        if (subWord.length() > 2) {
            for (int i = 0; i < subWord.length(); i++) {
                //String[] array = ArrayUtils.removeElement();
                permutationFinder(removeElementFromArray(subWord, i), 0);
                //delete element and create new array
                //llamo a permutation
            }
        }
    }

    private static char[] removeElementFromArray(String word, int removeIndex){
        //int removeIndex = 4;
        //char[] str = "permutacion".toCharArray();
        char[] str = word.toCharArray();
        char[] newString = new char[str.length-1];
        //String str = "this is Java";
        //System.out.println(charRemoveAt(str,3));

        //System.out.println(str);

        //String word = "gol";
        int pos = 0;
        for (int j = 0; j < str.length; j++){
            //System.out.println(str[j]);
            if (j != removeIndex) {
                //System.out.println(pos);
                newString[pos] = str[j];
                pos++;
            }
        }
        //System.out.println(newString);
        return newString;
        //List<String> myList = new ArrayList<String>(Arrays.asList(word.split(",")));
        //System.out.println(myList);
        //System.out.println(myList.remove(1));
        }
}
            /*
            for (int j = i; j < str.length; j++) {
                char temp = str[j];
                str[j] = str[i];
                str[i] = temp;
                //System.out.println(str);
                permutationFinder(str, i + 1);

                temp = str[j];
                str[j] = str[i];
                str[i] = temp;
                */
package utils;

import com.sun.jdi.connect.spi.TransportService;

import java.util.ArrayList;
import java.util.LinkedList;

public class Permutation {

    private static ArrayList<String> ans = new ArrayList<>();

    public static ArrayList<String> getAns() {
        return ans;
    }

    private static String hasOnlyLetters(String word) throws  Exception {

        if (word.matches("[a-zA-Z]+")){
            return word;
        } else {
            throw new Exception("Validation failed " + word +" does not contain only letters" );
        }
    }

    public static String inputText(String word){
        try {
            return hasOnlyLetters(word);
        } catch (Exception e) {
            e.printStackTrace();
        }
    return null;
    }

    public static void findAllPermutations(String word) {
        String wordToBePermuted = inputText(word);
       
        try {
            findPermutations(wordToBePermuted.toCharArray(), 0, ans);
            for (int i = 0; i < ans.size() - 1; i++) {
                for (int j = 0; j < ans.get(i).length() - 2 ; j++) {
                    removeACharacterAndFindAllPermutations(ans.get(i).substring(j));
                }
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

    private static ArrayList<String> findPermutations(char[] str, int pos, ArrayList<String> ans){
        if (pos == str.length && !ans.contains(String.valueOf(str))){
            String word = String.valueOf(str);
            ans.add(word);
        } else {
            for (int currentPos = pos; currentPos < str.length; currentPos++){
                changePosition(pos, currentPos,str);
                findPermutations(str,pos+1,ans);
                changePosition(pos, currentPos,str);
            }
        }
        return ans;
    }

    private static void changePosition(int posA, int posB, char[] str){
        char temp = str[posA];
        str[posA] = str[posB];
        str[posB] = temp;
    }

    private static void removeACharacterAndFindAllPermutations(String subWord) {
        for (int i = 0; i < subWord.length(); i++) {
            findPermutations(removeElementFromArray(subWord, i), 0,ans);
        }
    }

    private static char[] removeElementFromArray(String word, int removeIndex) {
        char[] str = word.toCharArray();
        char[] subWord = new char[str.length-1];

        int pos = 0;
        
        for (int i = 0; i < word.length(); i++) {
            if (i !=  removeIndex) {
                subWord[pos] = str[i];
                pos++;
            } else{
                continue;
            }
        }
        return subWord;
    }

    public static void printArrayWithResults(){
        System.out.println(ans);
    }
}

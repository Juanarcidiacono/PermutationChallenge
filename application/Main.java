package application;

import dictionary.Dictionary;
import utils.Permutation;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws Exception {
        Permutation.findAllPermutations("abc");
    }

    public static void startApplication(String str){
        Permutation.findAllPermutations(str);
        Permutation.printArrayWithResults();
        
        ArrayList<String> words = Permutation.getAns();
        ArrayList<String> permutationEnglish = new ArrayList<>();
        
        for (String word: words) {
            if(Dictionary.isEnglishWord(word)){
                permutationEnglish.add(word);
            }
        }
    }
}

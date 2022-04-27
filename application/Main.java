package application;

import dictionary.Dictionary;
import utils.Permutation;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws Exception {
        //Permutation.printArrayWithResults();
        //System.out.println(Permutation.getAns().size());
        //per.findAllPermutations();
        //per.findPermutations("bcd".toCharArray(),per.ans);
        //System.out.println("abcd".substring(0));
        //if (Permutation.getAns().contains("wta")){
          //  System.out.println("OK");
        //} else {
          //  System.out.println("NO");
        //}
       //startApplication("ABCD");
        Permutation.findAllPermutations("abc");
        System.out.println(Permutation.getAns());
        System.out.println(Permutation.getAns().size());
    }

    public static void startApplication(String str){
        Permutation.findAllPermutations(str);
        Permutation.printArrayWithResults();
        ArrayList<String> words = Permutation.getAns();
        ArrayList<String> permutationEnglish = new ArrayList<>();
        for (String word: words) {

            System.out.println(word);
            System.out.println(Dictionary.isEnglishWord(word));
            if(Dictionary.isEnglishWord(word)){
                permutationEnglish.add(word);
            }
            System.out.println("---");
        }
        System.out.println(permutationEnglish);
    }
}

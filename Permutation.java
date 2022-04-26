import com.sun.jdi.connect.spi.TransportService;

import java.util.ArrayList;
import java.util.LinkedList;

public class Permutation {

    //public static ArrayList<String> wordsArray = new ArrayList<>();
    private static ArrayList<String> ans = new ArrayList<>();

    public static ArrayList<String> getAns() {
        return ans;
    }

    /*
        public static void main(String args[]) {
            findAllPermutations("abcd");
        }
    */
    private static String hasOnlyLetters(String word) throws  Exception {

        if (word.matches("[a-zA-Z]+")){
            return word;
        } else {
            throw new Exception("Validation failed " + word +" does not contain only letters" );
        }
        /*
        for (char i : word.toCharArray()) {
            if (!Character.isLetter(i)) {
                //flag = false;
                throw new Exception("Validation failed " + i + " is not a letter");
                //return word;
            }
        }
        if (flag) {
             return word;
        } else {
            return null;
        }
        */
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
        //String word = "gol";
        //System.out.println(word.length());
        //permutationFinder(word.toCharArray(),0);
        //String str = inputText(word);

        String wordToBePermuted = inputText(word);

        //StringBuilder strInv = new StringBuilder(wordToBePermuted).reverse();

        //String wordToBePermutadedInv = strInv.toString();
        //int count = wordToBePermuted.length();

        try {
            findPermutations(wordToBePermuted.toCharArray(), 0, ans);
            for (int i = 0; i < ans.size() - 1; i++) {
                for (int j = 0; j < ans.get(i).length() - 2 ; j++) {
                    //System.out.println(ans.get(i).substring(j));
                    removeACharacterFindAllPermutations(ans.get(i).substring(j));
                }
            }
            /*
            for (int i = 0; i < wordToBePermuted.length(); i++) {
                //wordToBePermuted = str.substring(i);
                //wordToBePermutadedInv = new StringBuilder(str).reverse();
                //System.out.println(wordToBePermutadedInv);

                //wordToBePermutadedInv = str.substring(str.length()-i).toCharArray();
                //System.out.println("reversa");
                //System.out.println(wordToBePermutadedInv.reverse().toString().substring(i));

                //System.out.println(wordToBePermutadedInv);
                //findPermutations(wordToBePermuted.toCharArray(), 0, ans);
                //findPermutations(wordToBePermuted.substring(i).toCharArray(), 0, ans);
                System.out.println("-------");
                System.out.println(ans.get(i));
                for (int j = 0; j <)
                removeACharacterFindAllPermutations(ans.get(count).substring(i));

                //System.out.println(ans);
                //System.out.println(wordToBePermutadedInv.reverse().substring(i));
                //System.out.println(":::" + wordToBePermutadedInv.substring(i));
                //removeACharacterFindAllPermutations(wordToBePermuted.substring(i));
                //removeACharacterFindAllPermutations(wordToBePermutadedInv.substring(i));
                //subPermutation(wordToBePermutadedInv.substring(i));
                //System.out.println("aca:" + wordToBePermutadedInv.substring(i));
                //System.out.println(;
                //subPermutation(wordToBePermutadedInv.reverse().substring(i));
            }


            /*
            for(int j = 1; j < ans.get(count).length() - 2; j++){

                System.out.println("-------");
                System.out.println(wordToBePermuted.substring(j));
                //removeACharacterFindAllPermutations(wordToBePermuted.substring(j));
                removeACharacterFindAllPermutations(ans.get(count).substring(j));
                count ++;
            }*/
            /*
            do {
                System.out.println("-------");
                System.out.println(wordToBePermuted.substring(j));
                //removeACharacterFindAllPermutations(wordToBePermuted.substring(j));
                removeACharacterFindAllPermutations(ans.get(i).substring(j));
            } while (count < ans.get(count).length() -1);

            for(int j =1; j < ans.get(i).length() - 1; j++){

                System.out.println("-------");
                System.out.println(wordToBePermuted.substring(j));
                //removeACharacterFindAllPermutations(wordToBePermuted.substring(j));
                removeACharacterFindAllPermutations(ans.get(i).substring(j));
            }

            count ++;
            */

        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }
/*
    public static ArrayList<String> permutationFinder(char[] str, int i) {
        char[] ch = word.toCharArray();
        for (char c : ch){
            System.out.println(c);
        }
        if (i >= str.length) {
            return null;
        }
        if (i == str.length - 1 && !wordsArray.contains(String.valueOf(str))) {
            String word = String.valueOf(str);
            wordsArray.add(word);
            System.out.println(word);
            //System.out.println(word);

            if (!wordsArray.contains(word)){
                wordsArray.add(word);
            }


        } else {
            for (int j = i; j < str.length; j++) {
                System.out.println("i: "+i+"\nj: "+j);
                char temp = str[j];
                System.out.println(temp);
                str[j] = str[i];
                System.out.println(str[j]);
                str[i] = temp;
                System.out.println(str[i]);
                System.out.println(str);
                permutationFinder(str, i + 1);
                System.out.println("j: "+ j+"\ni: "+i+"\nStr: "+str[0]+str[1]+str[2]);
                temp = str[j];
                System.out.println(temp);
                str[j] = str[i];
                System.out.println(str[j]);
                str[i] = temp;
                System.out.println(str[i]);
                System.out.println(str);
                System.out.println("i: "+i+"\nj: "+j);
            }
        }
        return wordsArray;
    }

 */
/*
    private static ArrayList<String> findPermutations(char []str,ArrayList<String> ans){
        findPermutations(str,0,ans);
        printArrayWithResults();
        return ans;
    }

*/
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
/*
    private static String permutationFinder2(char[] str, int i) {
        char[] ch = word.toCharArray();
        for (char c : ch){
            System.out.println(c);
        }
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
        return null;
    }
*/
    private static void removeACharacterFindAllPermutations(String subWord) {
        for (int i = 0; i < subWord.length(); i++) {
            findPermutations(removeElementFromArray(subWord, i), 0,ans);
        }
    }

    private static char[] removeElementFromArray(String word, int removeIndex) {
        //int removeIndex = 4;
        //char[] str = "permutacion".toCharArray();
        char[] str = word.toCharArray();
        char[] subWord = new char[str.length-1];
        //String str = "this is Java";
        //System.out.println(charRemoveAt(str,3));

        //System.out.println(str);

        //String word = "gol";
        int pos = 0;
        for (int i = 0; i < word.length(); i++) {
            if (i !=  removeIndex) {
                subWord[pos] = str[i];
                pos++;
            } else{
                continue;
            }
        }
/*
        System.out.println(word);
        System.out.println(subWord);
        System.out.println("--------------");
   */
        return subWord;
        //List<String> myList = new ArrayList<String>(Arrays.asList(word.split(",")));
        //System.out.println(myList);
        //System.out.println(myList.remove(1));
    }

    public static void printArrayWithResults(){
        System.out.println(ans);
    }
}
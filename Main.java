public class Main {

    public static void main(String[] args) throws Exception {

        Permutation.findAllPermutations("abcdef");
        Permutation.printArrayWithResults();
        //per.findAllPermutations();
        //per.findPermutations("bcd".toCharArray(),per.ans);
        //System.out.println("abcd".substring(0));
        if (Permutation.getAns().contains("cd")) {
            System.out.println("OK");
        } else {
            System.out.println("NO");
        }

    }
}

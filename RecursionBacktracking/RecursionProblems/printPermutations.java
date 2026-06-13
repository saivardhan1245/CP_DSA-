// package RecursionBacktracking.RecursionProblems;

public class printPermutations {

    public static void printPerm(String str, String asf) {
        if (str.length() == 0) {
            System.out.print(asf + " ");
            return;
        }
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            String rem = str.substring(0, i) + str.substring(i + 1);
            printPerm(rem, asf + ch);
        }
    }

    public static void main(String[] args) {
        String str = "abc";
        printPerm(str, "");
    }
}

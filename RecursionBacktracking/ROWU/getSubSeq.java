
public class getSubSeq {

    public static void printSubSeq(String str, String ssf) {
        if (str.length() == 0) {
            System.out.println(ssf);
            return;
        }
        char ch = str.charAt(0);
        String smallAns = str.substring(1);
        // ch says no
        printSubSeq(smallAns, ssf);
        printSubSeq(smallAns, ssf + ch);
    }

    public static void main(String[] args) {

        printSubSeq("abc", "");
        // output [, c, b, bc, a, ac, ab, abc]
    }
}

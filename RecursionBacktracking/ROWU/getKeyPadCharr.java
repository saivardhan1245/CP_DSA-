
public class getKeyPadCharr {

    static String[] letters = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public static void printKeyPad(String str, String asf) {
        if (str.length() == 0) {
            System.out.println(asf);
            return;
        }

        int fd = str.charAt(0) - '0';
        String fs = letters[fd];
        String smallAns = str.substring(1);
        for (char ch : fs.toCharArray()) {
            printKeyPad(smallAns, asf + ch);
        }
    }

    public static void main(String[] args) {
        printKeyPad("23", "");
        /**
         * ad ae af bd be bf cd ce cf
         */
    }
}

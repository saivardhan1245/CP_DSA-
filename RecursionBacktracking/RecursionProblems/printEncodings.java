package RecursionBacktracking.RecursionProblems;

public class printEncodings {

    public static char digitToString(int digit) {
        return (char) ((digit - 1) + 'a');
    }

    public static void printEncoding(String str, String asf) {
        if (str.length() == 0) {
            System.out.println(asf);
            return;
        }
        int ch = str.charAt(0) - '0';
        if (ch == 0) {
            return;
        }
        char digit = digitToString(ch);
        String nextStr = str.substring(1);
        printEncoding(nextStr, asf + digit);

        if (str.length() >= 2) {
            String ss = str.substring(0, 2);
            int d = Integer.parseInt(ss);
            if (d <= 26) {
                char c = digitToString(d);
                String t = str.substring(2);
                printEncoding(t, asf + c);
            }
        }

    }

    public static void main(String[] args) {
        String curr = "123";
        printEncoding(curr, "");
    }
}

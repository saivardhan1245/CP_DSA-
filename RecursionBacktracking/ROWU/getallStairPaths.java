
public class getallStairPaths {

    public static void printStairPaths(int n, String asf) {

        if (n == 0) {
            System.out.println(asf);
            return;
        }
        if (n < 0) {
            return;
        }
        printStairPaths(n - 1, asf + "1");
        printStairPaths(n - 2, asf + "2");
        printStairPaths(n - 3, asf + "3");
    }

    public static void main(String[] args) {
        printStairPaths(6, "");
    }
}

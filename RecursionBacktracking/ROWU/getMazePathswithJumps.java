
public class getMazePathswithJumps {

    public static void printPathsWithJumps(int sr, int sc, int dr, int dc, String asf) {
        if (sr == dr && sc == dc) {
            System.out.println(asf);
            return;
        }
        if (sr > dr || sc > dc) {
            return;
        }
        for (int jumps = 1; jumps <= dc - sc; jumps++) {
            printPathsWithJumps(sr, sc + jumps, dr, dc, asf + "h" + jumps);
        }
        for (int jumps = 1; jumps <= dr - sc; jumps++) {
            printPathsWithJumps(sr + jumps, sc, dr, dc, asf + "v" + jumps);
        }
    }

    public static void main(String[] args) {
        printPathsWithJumps(0, 0, 2, 2, "");
        //h1v1v1h1 ,v1h1v1h1 ,v1v1h1h1 , v1v1h2 ,v2h1h1 ,v2h2//
    }
}


import java.util.*;

public class getMazePathswithJumps {

    public static List<String> getPathsJumps(int sr, int sc, int dr, int dc) {
        if (sr > dr || sc > dc) {
            List<String> barr = new ArrayList<>();
            return barr;
        }
        if (sr == dr && sc == dc) {
            List<String> barr = new ArrayList<>();
            barr.add("");
            return barr;
        }
        List<String> res = new ArrayList<>();
        // horizontal jumps
        for (int jumps = 1; jumps <= dc - sc; jumps++) {
            List<String> afterHjumps = getPathsJumps(sr, sc + jumps, dr, dc);
            for (String c : afterHjumps) {
                res.add("h" + jumps + c);
            }
        }
        // vertical jumps
        for (int jumps = 1; jumps <= dr - sr; jumps += 1) {
            List<String> afterVjumps = getPathsJumps(sr + jumps, sc, dr, dc);
            for (String c : afterVjumps) {
                res.add("v" + jumps + c);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(getPathsJumps(0, 0, 2, 2));
        //[h1h1v1v1, h1h1v2, h1v1h1v1, h1v1v1h1, h1v2h1, h2v1v1, h2v2, 
        //v1h1h1v1, v1h1v1h1, v1h2v1, v1v1h1h1, v1v1h2, v2h1h1, v2h2]
    }
}

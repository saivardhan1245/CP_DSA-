
public class getMazePaths {

    public static void getPathsHV(int sr, int sc, int dr, int dc, String asf) {
        if (sr == dr && sc == dr) {
            System.out.println(asf);
            return;
        }
        if (sr > dr || sc > dc) {
            return;
        }
        getPathsHV(sr, sc + 1, dr, dc, asf + "h");
        getPathsHV(sr + 1, sc, dr, dc, asf + "v");
    }

    public static void main(String[] args) {
        getPathsHV(0, 0, 2, 2, "");
        //[hhvv, hvhv, hvvh, vhhv, vhvh, vvhh]
    }
}

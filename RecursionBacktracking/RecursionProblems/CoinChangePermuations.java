package RecursionBacktracking.RecursionProblems;

public class CoinChangePermuations {

    public static void ccpOneCoin(int[] arr, int tar, boolean[] vis, String asf) {
        if (tar == 0) {
            System.out.println(asf);
            return;
        }
        if (tar < 0) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            if (!vis[i]) {
                vis[i] = true;
                ccpOneCoin(arr, tar - arr[i], vis, asf + arr[i] + " ");
                vis[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 4, 6, 5};
        int tar = 10;
        boolean[] vis = new boolean[5];
        ccpOneCoin(arr, tar, vis, "");

    }
}

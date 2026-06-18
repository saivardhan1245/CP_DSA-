//package RecursionBacktracking.RecursionProblems;

import java.util.*;

public class targetSwithSubset {

    List<List<Integer>> ans = new ArrayList<>();

    public static void printTargetSubsets(int[] arr, int tar, int idx, String asf) {
        if (idx == arr.length || tar < 0) {
            return;
        }
        if (tar == 0) {
            System.out.println(asf);
            return;
        }
        //pick
        printTargetSubsets(arr, tar - arr[idx], idx + 1, asf + arr[idx] + ", ");
        //not pick
        printTargetSubsets(arr, tar, idx + 1, asf);
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 5, 1, 4, 6, 8};
        int tar = 8;
        printTargetSubsets(arr, tar, 0, "");
    }
}

package Heaps.Problems;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class ksortedarr {
    //https://www.geeksforgeeks.org/problems/merge-k-sorted-arrays/1
    class Solution {
    class Pair{
        int row;
        int col;
        int val;
        public Pair(int r,int c ,int v){
            this.row = r;
            this.col = c;
            this.val = v;
        }
    }
    public ArrayList<Integer> mergeArrays(int[][] mat) {
        // Code here
        ArrayList<Integer> ans = new ArrayList<>();
        PriorityQueue<Pair> pq = new PriorityQueue<>( (Pair a , Pair b)->{
            return a.val-b.val;
        });
        for(int i = 0 ; i < mat.length ; i++){
            pq.add(new Pair(i,0,mat[i][0]));
        }
        while(pq.size()>0){
            Pair top = pq.remove();
            int r = top.row;
            int c = top.col;
            int v = top.val;
            ans.add(v);
            if(c + 1 < mat[r].length){
                pq.add(new Pair(r,c+1,mat[r][c+1]));
            }
        }
        return ans;
        
    }
}
}

package StackQueues.MediumQuestions;

import java.util.ArrayDeque;
import java.util.Deque;

public class TrappingWater {
    /*
    problem :
    
    Given n non-negative integers representing an elevation map where the width of each bar is 1, 
    compute how much water it can trap after raining

    link:
    https://leetcode.com/problems/trapping-rain-water/description/

    
     */
    // T.c O(N), S.C:O(N)
    public int trap(int[] height) {
       int n =  height.length;
       int[] lmax = new int[n];
       int[] rmax = new int[n];
       for(int i = 1 ; i < n ; i++){
        lmax[i] = Math.max(lmax[i-1],height[i-1]);
       }
       for(int i = n - 2 ; i>=0; i--){
        rmax[i] = Math.max(rmax[i+1],height[i+1]);
       }
       int totalWater = 0 ; 
       for(int i = 0 ; i < n ; i++){
          int maxWater = Math.min(lmax[i],rmax[i]);
          int currentWaterunits = Math.max(maxWater-height[i],0);
          totalWater+=currentWaterunits;
       }
       return totalWater;
    }
    /*  Using stack */
    public int trap2(int[] height) {
        int n = height.length;
        Deque<Integer> st = new ArrayDeque<>();
        int trap = 0 ;
        for(int i = 0 ; i < n ; i++){
            while(st.size()>0 && height[st.peek()]< height[i]){
                int poppedidx = st.pop();
                if(st.size()==0){
                    break;
                }
                int ngr = i ;
                int ngl = st.peek();
                int maxWaterallowed = Math.min(height[ngr],height[ngl]);
                int maxheight = maxWaterallowed - height[poppedidx];
                int width = ngr-ngl-1;
                trap += (maxheight*width);
            }
            st.push(i);

        }
        return trap;
    }
}

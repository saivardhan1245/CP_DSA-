package StackQueues.MediumQuestions;

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
}

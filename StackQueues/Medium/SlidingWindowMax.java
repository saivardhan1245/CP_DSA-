package StackQueues.Medium;

import java.util.ArrayDeque;
import java.util.Deque;
/*
https://leetcode.com/problems/sliding-window-maximum/
 */

public class SlidingWindowMax {
    //Using Stack
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] ngr = new int[n];
        Deque<Integer> st = new ArrayDeque<>();

        for (int i = 0; i < nums.length; i++) {
            int ce = nums[i];
            while (st.size() > 0 && nums[st.peek()] < ce) {
                ngr[st.peek()] = i;
                st.pop();
            }
            st.push(i);
        }
        while (st.size() > 0) {
            ngr[st.pop()] = n;
        }
        int[] ans = new int[n - k + 1];
        int idx = 0;
        for (int i = 0; i < ans.length; i++) {
            if (idx < i) {
                idx = i;
            }
            while (ngr[idx] < i + k) {
                idx = ngr[idx];
            }
            ans[i] = nums[idx];
        }
        return ans;
    }
    // Using Deque
    public int[] maxSlidingWindow1(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[n-k+1];
        Deque<Integer> que = new ArrayDeque<>();
        // remove the ele if out of idx range
        // remove the ele if is not ans
        int ansIdx = 0  ;
        for(int i = 0 ; i < n ; i++){
            while(!que.isEmpty() && que.peekFirst() <=  i -  k  ){
                que.pollFirst();
            }
            
            while(!que.isEmpty() && nums[que.peekLast()]< nums[i]){
                que.pollLast();
            }
            que.offerLast(i);

            if(i>=k-1){
                ans[ansIdx++] = nums[que.peekFirst()];
            }
        }
        return ans;
    }
}

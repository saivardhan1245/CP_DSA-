// https://leetcode.com/problems/final-prices-with-a-special-discount-in-a-shop/description/

import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int[] finalPrices(int[] prices) {
        Deque<Integer> st = new ArrayDeque<>();
        
        int n = prices.length ;
        int[] ans = new int [n];
        for(int i = n - 1 ; i >= 0 ; i--){
            int ce = prices[i];
            while(!st.isEmpty() && prices[st.peek()] > ce) {
                st.pop();
            }
            ans[i] = ce -  ( st.isEmpty() ? 0 : prices[st.peek()]  ) ;
            st.push(i);
        }
        return ans;
    }

       public int[] finalPrices2(int[] prices) {
        Deque<Integer> st = new ArrayDeque<>();
        
        int n = prices.length ;
        int[] ans = new int [n];
        for(int i = n - 1 ; i >= 0 ; i--){
            int ce = prices[i];
            while(!st.isEmpty() && st.peek()> ce) {
                st.pop();
            }
            int disc = st.isEmpty()?0:st.peek();
            ans[i] = ce - disc;
            st.push(ce);
        }
        return ans;
    }
}
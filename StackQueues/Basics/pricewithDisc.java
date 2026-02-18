import java.util.ArrayDeque;
import java.util.Deque;

public class pricewithDisc {
    //https://leetcode.com/problems/final-prices-with-a-special-discount-in-a-shop/description/
     public int[] finalPrices(int[] prices) {
        Deque<Integer> st = new ArrayDeque<>();
        int n = prices.length ;
        int[] ans = new int [n];
        for(int i = 0 ; i < n  ; i++){
            ans[i] = prices[i];
        }
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

}

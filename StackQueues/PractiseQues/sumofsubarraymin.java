import java.util.ArrayDeque;
import java.util.Deque;
//
public class sumofsubarraymin {
    class Solution {
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        int[] nsl = new int[n];
        int[] nsr = new int[n];
        Deque<Integer> st = new ArrayDeque<>();
        for(int i = 0 ; i < n ; i++){
            int ce = arr[i];
            while(!st.isEmpty() && arr[st.peek()] > ce ){
                st.pop();
            }
            nsl[i] = !st.isEmpty() ? st.peek() : -1;
            st.push(i);
        }
        st = new ArrayDeque<>();
        for(int i = n - 1 ; i >= 0 ; i--){
            int ce = arr[i];
            while(!st.isEmpty() && arr[st.peek()] >= ce){
                st.pop();
            }
            nsr[i] = !st.isEmpty() ? st.peek() : n ;
            st.push(i);
        }
         int mod = (int) 1e9+ 7;
        long sum = 0 ;
        for(int i = 0 ; i < n ; i++){
            int ce = arr[i];

            long l = i - nsl[i];
            long r = nsr[i] - i;
            sum = (sum + ce * l * r)% mod;
        }
       
        return (int)sum%mod;
    }
}
    
}

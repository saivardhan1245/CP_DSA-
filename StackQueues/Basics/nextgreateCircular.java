import java.util.Arrays;
import java.util.Stack;
//https://leetcode.com/problems/next-greater-element-ii/
public class nextgreateCircular {
    //
      public int[] nextGreaterElements(int[] nums) {
        int n = nums.length ;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();
        
        Arrays.fill(ans,-1);
        for(int i = 0 ; i < 2 * n ; i++){
            int ce = nums[i%n];
            while(!st.isEmpty() && nums[st.peek()]  < ce ){
                ans[st.peek()] = ce;
                st.pop();
            }
            st.push(i%n);
        }
        return ans;
    }
}

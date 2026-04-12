import java.util.ArrayDeque;
import java.util.Deque;
//https://leetcode.com/problems/maximum-width-ramp/description/
public class maxRampWidth {
    class Solution {
    public int maxWidthRamp(int[] nums) {
        Deque<Integer> st = new ArrayDeque<>();
        int n = nums.length;

        int ramp = 0;

        for (int i = 0; i < n; i++) {
            if (st.isEmpty() || (nums[st.peek()]) > nums[i]) {
                st.push(i);
            }
        }
        for (int j = n - 1; j >= 0; j--) {
            while (!st.isEmpty() && nums[st.peek()] <= nums[j]) {
                int i = st.pop();
                ramp = Math.max(ramp, j - i);
            }
            if(st.isEmpty()){
                break;
            }
        }
        return ramp;
    }
}
}

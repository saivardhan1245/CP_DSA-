import java.util.Stack;
public class validStackSeq {
    //https://leetcode.com/problems/validate-stack-sequences/description/
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> st = new Stack<>();
        int pop_idx = 0 , n = pushed.length ;
        for(int i = 0 ; i < n ; i++){
            int ce = pushed[i];
            st.push(ce);
            while(!st.isEmpty() && st.peek().equals(popped[pop_idx])){
                st.pop();
                pop_idx++;
            }
        }
        while(!st.isEmpty() && st.peek().equals(popped[pop_idx])){
             
                st.pop();
                pop_idx++;
        
        }
        return pop_idx==n;
    }
}

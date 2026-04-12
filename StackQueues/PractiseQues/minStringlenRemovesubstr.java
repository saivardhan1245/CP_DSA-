import java.util.ArrayDeque;
import java.util.Deque;

public class minStringlenRemovesubstr {
    //https://leetcode.com/problems/minimum-string-length-after-removing-substrings/description/
    class Solution {
    public int minLength(String s) {
        Deque<Character> st = new ArrayDeque<>();
        for(char ch:s.toCharArray()){
          if(!st.isEmpty()){
             char prev = st.peek();
             if(prev=='A' && ch=='B'){
                st.pop();
                continue;
             }
             if(prev=='C' && ch=='D'){
                st.pop();
                continue;
             }
             
          }
          st.push(ch);
        }
        return st.size();
    }
}
}

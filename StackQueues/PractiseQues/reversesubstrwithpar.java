//https://leetcode.com/problems/reverse-substrings-between-each-pair-of-parentheses/description/

import java.util.ArrayDeque;
import java.util.Deque;

class Solution1 {
    public String reverseParentheses(String s) {
    
        Deque<StringBuilder> st = new ArrayDeque<>();
        StringBuilder curr = new StringBuilder();
        for(char ch:s.toCharArray()){
            if(ch=='('){
                
                st.push(curr);
                curr = new StringBuilder();
            }else if(ch==')'){
              
                curr.reverse();
                curr = st.pop().append(curr);
                
            }else{
                curr.append(String.valueOf(ch));
            }
        }
       
        return curr.toString();
    }
}
class Solution {
    public String reverseParentheses(String s) {
        Deque<String> st = new ArrayDeque<>();
        StringBuilder curr = new StringBuilder();
        for(char ch:s.toCharArray()){
            if(ch=='('){
                st.push(curr.toString());
                curr = new StringBuilder();
            }else if(ch==')'){
                String prev = st.pop();
                StringBuilder temp = new StringBuilder(curr.toString());
                curr = new StringBuilder();
                curr.append(prev);
                curr.append(temp.reverse().toString());
                
            }else{
                curr.append(String.valueOf(ch));
            }
        }
        StringBuilder res = new StringBuilder();
        return curr.toString();
    }
}
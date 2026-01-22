package StackQueues.Basics;

import java.util.Stack;

public class validParenthes{
    //https://leetcode.com/problems/valid-parentheses/
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        for(char ch:s.toCharArray()){
            if(ch=='(' || ch=='[' || ch=='{'){
                st.push(ch);
            }
            else if(ch==')'){
                if(st.isEmpty() || st.peek()!='('){
                    return false;
                }
                st.pop();//(
            }
            else if(ch==']'){
                if(st.isEmpty() ||st.peek()!='['){
                    return false;
                }
                st.pop();//[
            }
            else if( ch=='}'){
                if(st.isEmpty() ||st.peek()!='{'){
                    return false;
                }
                st.pop();//{
            }
        }
        return st.isEmpty();
    }
    public static void main(String[] args) {
        
    }
}
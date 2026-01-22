package StackQueues.Basics;

import java.util.Stack;

public class DuplicateParthensis{
    public static boolean checkDuplicate(String str){
        Stack<Integer> st = new Stack<>();
        for(char ch:str.toCharArray()){
            if(ch==')'){
                if(st.peek()=='('){
                    return true;
                }
                while(st.peek()!='('){
                    st.pop();
                }
                st.pop();

            }else{
                st.push(ch);
            }
        }
        return false;
    }
    public static void main(String[] args) {
       // https://www.geeksforgeeks.org/dsa/find-expression-duplicate-parenthesis-not/
    
    }
}
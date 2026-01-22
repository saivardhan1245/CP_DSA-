package StackQueues.Basics;

import java.util.Stack;

public class DuplicateBrackets{
     // https://www.geeksforgeeks.org/dsa/find-expression-duplicate-parenthesis-not/
    public static boolean checkDuplicate(String str){
        Stack<Character> st = new Stack<>();
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
    //https://www.geeksforgeeks.org/problems/expression-contains-redundant-bracket-or-not/1
    public static boolean checkRedundancy(String s) {
        // code here
        Stack<Character> st = new Stack<>();
        for(int i = 0 ; i < s.length() ; i++){
            char ch = s.charAt(i);
            if(ch==')'){
                if(st.peek()=='('){
                    return true;
                }
                boolean isOp = false;
                while(st.peek()!='('){
                    
                    char chr = st.pop();
                    if(chr=='+' || chr=='-' || chr=='*' || chr=='/'){
                        isOp = true;
                    }
                }
                st.pop();
                if(!isOp){
                    return true;
                }
            }else{
                st.push(ch);
            }
        }
        return false;
    }
    public static void main(String[] args) {
      
    
    }
}
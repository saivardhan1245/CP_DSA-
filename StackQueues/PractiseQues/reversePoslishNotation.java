import java.util.ArrayDeque;
import java.util.Deque;
//https://leetcode.com/problems/evaluate-reverse-polish-notation/
public class reversePoslishNotation {
    class Solution1 {
    public boolean isOptr(String str){
        if(str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/")){
            return true;
        }
        return false;
    }
    public int evaluate(String str,int a , int b){
        int res = 0 ;
       
        if(str.equals("+")){
            return a+b;
        }else if(str.equals("-")){
            return a-b;
        }else if(str.equals("*")){
            return a*b;
        }else if(str.equals("/")){
            return a/b;
        }
        return -1;
    }
    public int evalRPN(String[] tokens) {
        Deque<Integer> st = new ArrayDeque<>();
        for(String str:tokens){
            if(isOptr(str)){
               
                    Integer a = st.pop();
                    Integer b = st.pop();
                    int res = evaluate(str,b,a);
                    st.push(res);
                
            } else{
                st.push(Integer.parseInt(str));
            }
        }
        return st.peek();
    }
}
class Solution2 {
    public int evalRPN(String[] tokens) {
        Deque<Integer> st = new ArrayDeque<>();
        for (String str : tokens) {
            if ("+-*/".contains(str)) {
                int b = st.pop();
                int a = st.pop();
                if (str.equals("+")) {
                    st.push( a + b);
                } else if(str.equals("-")) {
                    st.push( a - b);
                } else if(str.equals("*")) {
                    st.push( a * b);
                } else if(str.equals("/")) {
                    st.push( a / b);
                }
            } else{
                st.push(Integer.parseInt(str));
            }
        }
        return st.peek();
    }
}
}

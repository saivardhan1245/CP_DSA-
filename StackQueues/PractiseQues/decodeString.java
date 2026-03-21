import java.util.ArrayDeque;
import java.util.Deque;
//https://leetcode.com/problems/decode-string/
public class decodeString {
    class Solution {
    
    public String decodeString(String s) {
        
        Deque<Integer> digit = new ArrayDeque<>();
        Deque<String> st = new ArrayDeque<>();

     //   StringBuilder ans = new StringBuilder();
        StringBuilder curr = new StringBuilder();
        int k = 0 ; 
        for(char ch:s.toCharArray()){
            if(Character.isDigit(ch)){
                k =  k * 10 + (ch-'0');
            }else if(ch=='['){
                digit.push(k);
                st.push(curr.toString());
                k = 0;
                curr = new StringBuilder();
            }else if(ch==']'){
                int d = digit.pop();
                String prev = st.pop();
                StringBuilder temp = new StringBuilder(prev);
                while(d-->0){
                    temp.append(curr.toString());
                }
                curr = temp;
            }else{
                curr.append(ch);
            }
        }

        
        return curr.toString();
    }
}
}

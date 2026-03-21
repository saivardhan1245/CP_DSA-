import java.util.ArrayDeque;
import java.util.Deque;
//https://leetcode.com/problems/make-the-string-great/
public class makeStringGreat {
    class Solution {
    public String makeGood(String s) {
        Deque<Character> st = new ArrayDeque<>();
        StringBuilder str = new StringBuilder();
        int n = s.length();
        for(int i = n - 1 ; i >= 0 ; i-- ){
            char ch = s.charAt(i);
            char lower_ch = ' ', upper_ch = ' ' ;
            boolean l = false , u = false;
            if(Character.isLowerCase(ch)){
                l = true;
                upper_ch = (char) (ch-32) ; 
            }else if(Character.isUpperCase(ch)){
                u = true;
                lower_ch = (char) (ch+32);
            }
            boolean notpush = true;
            if(!st.isEmpty() && (( l  &&  upper_ch == st.peek() ) || (u && lower_ch == st.peek() ))){
                st.pop();
                notpush = false;
            }
            if(notpush){
                st.push(ch);
            }
        }
        while(!st.isEmpty()){
            str.append(st.pop());
        }
        String res = str.toString();
        return res;
        
    }
    public String makeGood2(String s) {
        Deque<Character> st = new ArrayDeque<>();
        StringBuilder str = new StringBuilder();
        int n = s.length();
        for(int i = n - 1 ; i >= 0 ; i-- ){
            char ch = s.charAt(i);
            
            if(!st.isEmpty() && Character.toLowerCase(ch)== Character.toLowerCase(st.peek()) && ch!=st.peek()){
                st.pop();
            }else{
                st.push(ch);
            }
           

        }
        while(!st.isEmpty()){
            str.append(st.pop());
        }
        String res = str.toString();
        return res;
        
    }

}
}

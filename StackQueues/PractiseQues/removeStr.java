import java.util.ArrayDeque;
import java.util.Deque;
//https://leetcode.com/problems/removing-stars-from-a-string/
public class removeStr {
    class Solution {
    public String removeStars(String s) {
        Deque<Character> st = new ArrayDeque<>();
        for(char ch : s.toCharArray() ){
            if(ch=='*'){
                st.pop();
            }else{
                st.push(ch);
            }
        }
        StringBuilder str = new StringBuilder();
        while(!st.isEmpty()){
            str.append(st.pop());
        }
        return str.reverse().toString();
    }
}
}

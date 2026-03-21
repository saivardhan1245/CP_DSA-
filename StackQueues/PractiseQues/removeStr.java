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
        // while(!st.isEmpty()){
        //     str.append(st.pop());
        // }
        // return str.reverse().toString();
         while(!st.isEmpty()){
            str.append(st.removeLast());
        }
        return str.toString();
    }
}
class Solution2 {
    public String removeStars(String s) {
        StringBuilder sb = new StringBuilder();

        for (char ch : s.toCharArray()) {
            if (ch == '*')
                sb.deleteCharAt(sb.length() - 1);
            else
                sb.append(ch);
        }

        return sb.toString();
    }
}
}

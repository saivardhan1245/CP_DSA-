//https://leetcode.com/problems/minimum-string-length-after-removing-substrings/submissions/1955495086/

import java.util.ArrayDeque;
import java.util.Deque;

public class removesubstrminlen {
    //brute
    class Solution1 {
    public int minLength(String s) {
    
    String res = "";
        for(char ch:s.toCharArray()){
            res+=ch;
            res = res.replace("AB","");
            res = res.replace("CD","");
        }
        System.out.println(res);
      
        return res.length();
    }
}
// using stack
class Solution2 {
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
// using stringbuilder
class Solution3 {
    public int minLength(String s) {
        StringBuilder sb = new StringBuilder();
        for(char ch:s.toCharArray()){
            sb.append(ch);
            int len = sb.length();
            if(len>=2){
                char f = sb.charAt(len-2);
                char sec = sb.charAt(len-1);
                if(f=='A' && sec == 'B' || f=='C' &&  sec =='D'){
                    sb.delete(len-2,len);
                }
            }
        }
        return sb.length();
    }
}
}

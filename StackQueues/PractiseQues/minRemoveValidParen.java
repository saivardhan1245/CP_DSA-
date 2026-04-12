import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

class Solution2 {
    public String minRemoveToMakeValid(String s) {
        Deque<Integer> st = new ArrayDeque<>();
        Set<Integer> set = new HashSet<>();
        for(int i = 0 ; i < s.length() ; i++){
            char ch = s.charAt(i);
            if(ch=='('){
                st.push(i);
                
            }else if(ch==')'){
                if(st.isEmpty()){
                    set.add(i);
                }else{
                    st.pop();
                }
            }
        }
        while(!st.isEmpty()){
            set.add(st.pop());
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < s.length();i++){
            if(!set.contains(i)){
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}
class Solution1 {
    public String minRemoveToMakeValid(String s) {
        Deque<Integer> st = new ArrayDeque<>();
        Set<Integer> set = new HashSet<>();
        for(int i = 0 ; i < s.length() ; i++){
            char ch = s.charAt(i);
            if(ch=='('){
                st.push(i);
                
            }else if(ch==')'){
                if(st.isEmpty()){
                    set.add(i);
                }else{
                    st.pop();
                }
            }
        }
        while(!st.isEmpty()){
            set.add(st.pop());
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < s.length();i++){
            if(!set.contains(i)){
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}
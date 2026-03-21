import java.util.ArrayDeque;
import java.util.Deque;

class removeDuplicatesStringII{
    class Pair{
        char ch;
        int cnt;
        public Pair(char ch,int cnt){
            this.ch = ch;
            this.cnt = cnt;
        }
    }
    public String removeDuplicates(String s, int k) {
        Deque<Pair> st = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        
        for(char ch:s.toCharArray()){
            
            if(!st.isEmpty() && st.peek().ch == ch){
                // Pair curr = st.pop();
                // st.push(new Pair(ch,curr.cnt+1));
                st.peek().cnt++;
                if(st.peek().cnt==k){
                    st.pop();
                }
                
            }
            
             else{
                st.push(new Pair(ch,1));
            }
        }
        while(!st.isEmpty()){
            Pair curr = st.removeLast();
            // String currStr = curr.ch+"";
            // int c = curr.cnt;
            // sb.append(currStr.repeat(c));
            sb.append(String.valueOf(curr.ch).repeat(curr.cnt));
        }
        return sb.toString();
    }
}
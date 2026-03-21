
import java.util.ArrayDeque;
import java.util.Deque;

//https://leetcode.com/problems/baseball-game/description/
public class BaseBall {
    class Solution {
    public int calPoints(String[] operations) {
        Deque<Integer> st = new ArrayDeque<>();
        for(String str:operations){
            if(str.equals("C")){
                if(!st.isEmpty()){
                    st.pop();
                }
            }else if(str.equals("D")){
                if(!st.isEmpty()){
                    st.push(st.peek() + st.peek());
                }
            }else if(str.equals("+")){
                Integer a = st.pop();
                Integer b = st.peek();
                st.push(a);
                st.push(a+b); 
            }else{
                st.push(Integer.parseInt(str));
            }
        }
        int sum = 0 ;
        while(!st.isEmpty()){
            sum += st.pop();
        }
        return sum;
    }
}
}

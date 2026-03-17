package StackQueues.PractiseQues;
import java.util.ArrayDeque;
import java.util.Deque;
//https://leetcode.com/problems/crawler-log-folder/description/
//import java.util.*;
public class CrawerLog {
    class Solution {
    public int minOperations(String[] logs) {
        Deque<String> st = new ArrayDeque<>();
        for(String str:logs){
            if(str.equals("../")){
                if(!st.isEmpty()){
                    st.pop();
                }
            
            }else if(!str.equals("./")){
                st.push(str);
              
            } 

        }
        return st.size();
    }
}
}

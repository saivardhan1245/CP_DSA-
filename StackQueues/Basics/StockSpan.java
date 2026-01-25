package StackQueues.Basics;


import java.util.ArrayList;
import java.util.Stack;

public class StockSpan {
    //https://www.geeksforgeeks.org/problems/stock-span-problem-1587115621/1
     public ArrayList<Integer> calculateSpan(int[] arr) {
        // code here
        Stack<Integer> st = new Stack<>();
        ArrayList<Integer> ans = new ArrayList<>();
        st.push(-1);
        for(int i = 0 ; i < arr.length ; i++){
            int ce = arr[i];
            while(st.peek()!=-1 && arr[st.peek()]<= ce){
                st.pop();
                
            }
            ans.add(i-st.peek());
            st.push(i);
        }
        return ans;
    }
    public static void main(String[] args) {
        
    }
}

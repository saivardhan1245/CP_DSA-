package StackQueues.Basics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class NextGreaterLeser {
    //https://www.geeksforgeeks.org/problems/next-larger-element-1587115620/1
    //ngr traversing from right 
    public ArrayList<Integer> nextLargerElement1(int[] arr) {
        // code here
         int n = arr.length;
         Stack<Integer> st = new Stack<>();
         int[] ngr = new int[n];
         for(int i = n - 1 ; i>=0 ; i--){
             int ce = arr[i];
             while(st.size()>0   &&   st.peek()<=ce){
                 st.pop();
             }
             if(st.size()==0){
                 ngr[i] = -1;
             }else{
                ngr[i] = st.peek();
             }
             st.push(ce);
         }
         ArrayList<Integer> ans = new ArrayList<>();
         for(int i = 0 ; i < n ; i++){
              ans.add(ngr[i]);
         }
         return ans;
    }
    public ArrayList<Integer> nextLargerElement2(int[] arr) {
        // code here
         int n = arr.length;
         Stack<Integer> st = new Stack<>();
         int[] ngr = new int[n];
        
        Arrays.fill(ngr,-1);
        for(int i = 0 ; i < n ; i++){
            int ce = arr[i];
            while(st.size()>0 && arr[st.peek()]<ce){
                ngr[st.peek()] = ce;
                st.pop();
            }
            st.push(i);
        }
        
         ArrayList<Integer> ans = new ArrayList<>();
         for(int i = 0 ; i < n ; i++){
              ans.add(ngr[i]);
         }
         return ans;
    }
    public static void main(String[] args) {
        
    }
}

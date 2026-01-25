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

    // stock span class
   // https://leetcode.com/problems/online-stock-span/
   class StockSpanner {
    
    Stack<int[]> st;
    int idx;
    public StockSpanner() {
        st = new Stack<>();
        idx = -1;
    }
    
    public int next(int price) {
        idx++;
        int span = 0;
        while(!st.isEmpty() && st.peek()[0]<=price){
            st.pop();
        }
        
         span  =  idx -  (st.isEmpty()? -1:st.peek()[1]);
        st.push(new int[]{price,idx});
        return span;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */


    public static void main(String[] args) {
        /*
how to use stack of pairs


class Pair {
    int first;
    int second;

    Pair(int f, int s){
        this.first = f;
        this.second = s;
    }
}
Stack<Pair> st = new Stack<>();

st.push(new Pair(1, 10));
st.push(new Pair(2, 20));

Pair p = st.pop();
System.out.println(p.first + " " + p.second);  // 2 20

Deque<Pair> st = new ArrayDeque<>();

st.push(new Pair(5, 100));
st.push(new Pair(6, 200));

Pair p = st.pop();
System.out.println(p.first + " " + p.second);


Stack<int[]> st = new Stack<>();

st.push(new int[]{1, 10});
st.push(new int[]{2, 20});

int[] p = st.pop();
System.out.println(p[0] + " " + p[1]);


*/
    }
}

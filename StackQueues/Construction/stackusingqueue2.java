package StackQueues.Construction;

import java.util.ArrayDeque;
import java.util.Queue;

class MyStack {
    Queue<Integer> que ;
    public MyStack() {
        que = new ArrayDeque<>();
    }
    
    public void push(int x) {
        que.add(x);
    }
    
    public int pop() {
        Queue<Integer> temp = new ArrayDeque<>();
        while(que.size()>1){
            temp.add(que.remove());
        }
        int ans = que.peek();
        que = temp;
        return ans;
    }
    
    public int top() {
        Queue<Integer> temp = new ArrayDeque<>();
        while(que.size()>1){
            temp.add(que.remove());
        }
        int ans = que.peek();
        temp.add(ans);
        que = temp;
        return ans;
    }
    
    public boolean empty() {
        return que.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */

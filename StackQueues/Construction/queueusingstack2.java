import java.util.Stack;
class MyQueue {
    Stack<Integer> st ;
    public MyQueue() {
        st = new Stack<>();
    }
    
    public void push(int x) {
        st.add(x);
    }
    
    public int pop() {
        Stack<Integer> temp = new Stack<>();
        while(st.size()>1){
            temp.push(st.pop());
        }
        int ans = st.pop();
        while(!temp.isEmpty()){
            st.push(temp.pop());
        }
        return ans;
    }
    
    public int peek() {
         Stack<Integer> temp = new Stack<>();
        while(st.size()>1){
            temp.push(st.pop());
        }
        int ans = st.pop();
        st.push(ans);
        while(!temp.isEmpty()){
            st.push(temp.pop());
        }
        return ans;
    }
    
    public boolean empty() {
        return st.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
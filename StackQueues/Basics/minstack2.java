import java.util.Stack;
//https://leetcode.com/problems/min-stack/description/
class MinStack {
    Stack<Long> st;
    long  min;
    public MinStack() {
        st = new Stack<>();
        min = Long.MAX_VALUE;
    }
    
    public void push(int x) {
        Long val = x *1L;
        if(st.isEmpty()){
            min = val;
            st.push(val);
        }
        else if( x  < min){
            long updated_min = val;
            long  prev_min = min;
            long encoded = 2*updated_min - prev_min;
            st.push(encoded);
            min = x;
        }else{
            st.push(val);
        }
    }
    
    public void pop() {

        if(  st.peek() < min ){
            long encoded = st.peek();
            long recent_min = min;
            long  prev_min = 2*recent_min - encoded;
            min = prev_min;
            st.pop();
        }else{
            st.pop(); 
        }
    }
    
    public int top() {
        if( st.peek() < min){
            return Math.toIntExact(min);
        }
        return Math.toIntExact(st.peek());
    }
    
    public int getMin() {
        return Math.toIntExact(min);
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
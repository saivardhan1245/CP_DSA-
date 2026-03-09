import java.util.Stack;
//https://leetcode.com/problems/min-stack/description/
class MinStack {
    Stack<Integer> st;
    Stack<Integer> minst;
    public MinStack() {
        st = new Stack<>();
        minst = new Stack<>();
    }
    
    public void push(int val) {
        
        if(st.isEmpty() && minst.isEmpty()){
            st.push(val);
            minst.push(val);
        }
        else if(!minst.isEmpty() && minst.peek() >= val){
            st.push(val);
            minst.push(val);
        }else{
            st.push(val);
        }
    }
    
    public void pop() {
        if(!st.isEmpty()){

            if(!minst.isEmpty() && st.peek() .equals ( minst.peek() ) ){
                st.pop();
                minst.pop();
            } else{
                st.pop();
            }
        }
       

    }
    
    public int top() {
        return st.peek();
    }
    
    public int getMin() {
        return !minst.isEmpty()?minst.peek():0;
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

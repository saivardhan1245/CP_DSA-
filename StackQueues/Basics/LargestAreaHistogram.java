import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class LargestAreaHistogram {

    //https://leetcode.com/problems/largest-rectangle-in-histogram/
    
    public int[] getnsl(int[] heights){
        int n = heights.length;
        int[] nsl = new int[n];
        Arrays.fill(nsl,-1);
        Deque<Integer> st = new ArrayDeque<>();
        st.push(-1);
        for(int i = 0 ; i < n ; i++){
            int ce = heights[i];
            while(st.peek()!=-1 && ce <= heights[st.peek()] ){
                st.pop();
            }
            nsl[i] = st.peek();
            st.push(i);
        }
        return nsl;
    }
    public int[] getnsr(int[] heights){
        int n = heights.length;
        int[] nsr = new int[n];
        Arrays.fill(nsr,n);
        
        Deque<Integer> st = new ArrayDeque<>();
        st.push(n);
        for(int i = 0 ; i < n ;i++){
            int ce = heights[i];
            while(st.peek()!=n && ce < heights[st.peek()]){
                nsr[st.peek()] = i ;
                st.pop();
            }
            st.push(i);
        }
        return nsr;
    }
    public int largestRectangleArea(int[] heights) { // 2pass
        int n = heights.length;
        int[] nsr = getnsr(heights);
        int[] nsl = getnsl(heights);
        int maxArea = 0 ;
        for(int i = 0 ; i < n ; i++){
            int h = heights[i];
            int w = nsr[i]-nsl[i]-1;
            maxArea  = Math.max(maxArea,h*w);
        }
        return maxArea;
    }
    public int largestRectangleAreaOptimal(int[] heights) { // single pass
        Deque<Integer> st = new ArrayDeque<>();
        int max =  0 , n = heights.length;
        st.push(-1);
        for(int i = 0 ; i < n ; i++){
            int ce = heights[i];
            while(st.peek()!=-1 && heights[st.peek()] >= ce ){
                int h = heights[st.pop()];
                int nsr = i;
                int nsl = st.peek();
                int w = nsr-nsl-1;
                max = Math.max(max,h*w);
            }
            st.push(i);
        }
        while(st.peek()!=-1){
            int h = heights[st.pop()];
            int nsr = n;
            int nsl = st.peek();
            int w = nsr-nsl-1;
            max = Math.max(max,h*w);
        }
        return max;
    }
}


public class DailyTemp {
    //https://leetcode.com/problems/daily-temperatures/description/
    public int[] dailyTemperatures(int[] temp) {
        int n = temp.length;
       int[] ans = new int[n];
       Arrays.fill(ans,0);
       Deque<Integer> st = new ArrayDeque<>();
       
      
       for(int i = n - 1 ; i >=0 ; i--){
            int ce = temp[i];
            // as we are traversing in same direction possans will in stack and elimiate wrong ele =>
            //   remove ele less than ce 
            //int cnt = 0 ;
            // int cnt = 0;
            
            while(!st.isEmpty() &&  ce >= temp[st.peek()]){
                st.pop();
                // cnt++;  
                // popCount++; 
            }
            
              ans[i] =  st.isEmpty() ? 0 : st.peek()-i;
             st.push(i);
           
       }  
       return ans;
    }
}

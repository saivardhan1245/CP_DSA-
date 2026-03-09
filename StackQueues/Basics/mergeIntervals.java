
// si------------ ei
// ----ci---------------------ef   ei >= ci => ci =si ef remains same
//-----ci---ef          ef = ei  
import java.util.Arrays;
import java.util.Stack;
 class Pair{
    int si;
    int ei;
    public Pair(int si,int ei){
        this.si = si;
        this.ei = ei;
    }
 }
 //https://leetcode.com/problems/merge-intervals/
class mergeInrervals {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        Stack<Pair> st = new Stack<>();
        int n  = intervals.length;
        Pair[] ti = new Pair[n];
        for( int i = 0 ; i < n ; i++){
            ti[i] = new Pair(intervals[i][0],intervals[i][1]);
        }
        for(int i = 0 ; i < n ; i++){
            Pair curr = ti[i];
            while(!st.isEmpty()   && curr.si <= st.peek().ei ){
                Pair prev = st.pop();
                curr.si = prev.si;
                curr.ei = Math.max(curr.ei,prev.ei);
            }
            st.push(curr);
        }
        int[][] ans = new int[st.size()][2];
        for(int i = st.size()-1  ; i >=0  ; i-- ){
            if(!st.isEmpty()){
                Pair res = st.pop();
                ans[i][0] = res.si;
                ans[i][1] = res.ei;
            }
        }
        return ans;
    }
}

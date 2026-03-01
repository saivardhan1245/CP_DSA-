package StackQueues.Medium;

import java.util.ArrayDeque;
import java.util.Deque;

public class recentCalls {
    /*
    problem : https://leetcode.com/problems/number-of-recent-calls/description/
    concept :
    After inserting the new element t,
    the deque must contain ONLY elements in the range [t−3000, t].
    Anything outside this range must be popped
     */
    class RecentCounter {
    Deque<Integer> que;
    int req;
    public RecentCounter() {
        que = new ArrayDeque<>();
        req = 0; 
    }
    
    public int ping(int t) {
        // int val = Math.max(t-3000,t);
        // if(t-3000>=3000){
        //     que.add(val);
        //     que.pollFirst();
        // }
        // else{
        //     que.add(val);
        // }
        que.offerLast(t);
        while(!que.isEmpty() && que.peekFirst() < t - 3000){
            que.pollFirst();
        }
        return que.size();
        }
        
        
}


/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */
}

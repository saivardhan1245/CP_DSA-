package StackQueues.Medium;

import java.util.ArrayDeque;
import java.util.Deque;

public class DesignHitCounter {
    /*
    problem : https://www.lintcode.com/problem/3662/
     */
    public class HitCounter {
    Deque<Integer> que;
    public HitCounter() {
        que = new ArrayDeque<>();
    }

    /**
     * @param timestamp: the timestamp
     * @return: nothing
     */
    public void hit(int timestamp) {
        que.offerLast(timestamp);
        while(!que.isEmpty()  && que.peekFirst() <= timestamp-300){
            que.pollFirst();
        }
    }

    /**
     * @param timestamp: the timestamp
     * @return: the count of hits in recent 300 seconds
     */
    public int getHits(int timestamp) {
        while(!que.isEmpty() && que.peekLast() < timestamp){
           
            hit(timestamp);
             que.pollFirst();
        }
        return que.size();
    }
}
}

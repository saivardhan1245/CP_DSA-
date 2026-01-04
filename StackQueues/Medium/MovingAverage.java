package StackQueues.Medium;

import java.util.ArrayDeque;
import java.util.Deque;
//https://www.lintcode.com/problem/642/
//moving average from data stream
public class MovingAverage {
    Deque<Long> que;
    Long capacity;
    Long sum ;
    /*
    * @param size: An integer
    */public MovingAverage(int size) {
        // do intialization if necessary
        que = new ArrayDeque<>();
        capacity = size*1L;
        sum = 0L ; 
    }

    /*
     * @param val: An integer
     * @return:  
     */
    public double next(int val) {
        // write your code here
        // if(que.size()< capacity){
        //     que.offerLast(val);
        // }
        // while(que.size()>=capacity){
        //     que.removeFirst();
        //     que.offerLast(val);
        // }
        // int sum = 0 , size = que.size();
        // while(!que.isEmpty()){
        //     sum+= que.peekFirst();
        //     que.pollFirst();
        //     System.out.println(sum);
        // }
        
        // double res = sum/size;
        que.offerLast(val*1L);
        sum += val;

        if(que.size()>capacity){
            sum -= que.pollFirst();
        }

        return (double)sum/que.size();
    }
}

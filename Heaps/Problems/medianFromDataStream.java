package Heaps.Problems;

import java.util.Collections;
import java.util.PriorityQueue;

public class medianFromDataStream {
 //
//  https://leetcode.com/problems/find-median-from-data-stream/description/
class MedianFinder {
    PriorityQueue<Integer> l; // max pq
    PriorityQueue<Integer> r; // min pq

    public MedianFinder() {
        l = new PriorityQueue<>(Collections.reverseOrder());
        r = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        
        if(l.size() ==  0  || num <= l.peek() ){
            l.add(num);
        }else{
            r.add(num);
        }
        if (l.size() < r.size() ){
            l.add(r.remove());
            return;
        }
        if(l.size() - r.size() > 1 ){
            r.add(l.remove());
            return;
        }


    }
    
    public double findMedian() {
        if(l.size() == r.size() ){
            return ( l.peek() + r.peek() ) * 1.0  / 2;
        } else {
            return l.peek();
        }
    }
}   
}

package HashmapHeap.Heaps;

import java.util.Collections;
import java.util.PriorityQueue;
//
public class KlargestSmallest {
    //https://leetcode.com/problems/kth-largest-element-in-an-array/
    public int findKthLargest(int[] nums, int k) {
        // Arrays.sort(nums);
        // return nums[nums.length-k];
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int ele:nums){
            pq.add(ele);
            if(pq.size()>k){
                pq.remove();
            }
        }
        return pq.peek();
        
        
    }
    //https://www.geeksforgeeks.org/problems/kth-smallest-element5635/1
    public int kthSmallest(int[] nums, int k) {
        // Code here
         PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int ele:nums){
            pq.add(ele);
            if(pq.size()>k){
                pq.remove();
            }
        }
        return pq.peek();
    }
}

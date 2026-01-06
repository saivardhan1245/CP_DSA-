package HashmapHeap.Heaps;

import java.util.PriorityQueue;

public class NearlySorted {
    public void nearlySorted(int[] arr, int k) {
        // code here
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int idx = 0 ;
        for(int i = 0 ; i < arr.length ; i++){
            pq.add(arr[i]);
            while(pq.size()>k){
                arr[idx++] = pq.remove();
            }
        }
        while(idx < arr.length){
            arr[idx++] = pq.remove();
        }
    }
}

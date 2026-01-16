package HashmapHeap.Heaps;

import java.util.PriorityQueue;
//https://leetcode.com/problems/merge-k-sorted-lists/
public class MergeKsorted {
     class ListNode {
       int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((ListNode a, ListNode b) -> {
            return a.val - b.val;
        });
        ListNode dummy = new ListNode(-1);
        ListNode currNode = dummy;
        for(ListNode list : lists){
            if(list!=null){
                pq.add(list);
            }
        }
        
        while(pq.size()>0){
            ListNode top = pq.remove();
            ListNode nextnode = top.next;
            top.next = null;
            if(nextnode!=null){
                pq.add(nextnode);
            }
            currNode.next = top;
            currNode = top;
        }
        return dummy.next;
    }
}

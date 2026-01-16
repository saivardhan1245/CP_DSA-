//package Heaps.Construction;

import java.util.ArrayList;

class PriorityQueue{
    ArrayList<Integer> data;
    boolean isMinHeap;
    public PriorityQueue(boolean isMinHeap){
        data = new ArrayList<>();
        this.isMinHeap = isMinHeap;
    }
    public void swap(int i , int j){
        int ith = data.get(i);
        int jth = data.get(j);
        data.set(i,jth);
        data.set(j,ith);
    }
    public boolean isMorePrior(int i , int j){  // c , p 
        if(isMinHeap){ // smallest should be on top ( p < c )
            return data.get(i)<data.get(j); // checks if  c < p  
        }else{
            return data.get(i)>data.get(j);
        }
    }
    public void upHeapify(int childIdx){
        if(childIdx==0){
            return;
        }
        int parentIdx = (childIdx-1)/2;
        if(isMorePrior(childIdx, parentIdx)){
            swap(parentIdx,childIdx);
            upHeapify(parentIdx);
        }
    }
    public void add(int val){
        
        data.add(val);
        upHeapify(data.size()-1);
    }
    public void downHeapify(int parentIdx){
        int leftChild = 2*parentIdx+1;
        int rightChild = 2*parentIdx+2;
        int minIdx= parentIdx;
        if(leftChild < data.size() && isMorePrior(leftChild, minIdx) ){
            minIdx = leftChild;
        }
        if(rightChild < data.size() && isMorePrior(rightChild, minIdx)){
            minIdx = rightChild;
        }
        if(parentIdx!=minIdx){
            swap(parentIdx, minIdx);
            downHeapify(minIdx);
        }
        
    }
    public int remove(){
        if(data.size()==0){
            System.out.println("pq is empty ");
            return -1;
        }
        swap(0,data.size()-1);
        int val = data.remove((data.size()-1));
        downHeapify(0);
        return val;
    }
    public int peek(){
        return data.get(0);
    }
}
public class HeapMain {
    public static void main(String[] args) {
      // PriorityQueue pq = new PriorityQueue(false);
        PriorityQueue pq = new PriorityQueue(true);
        pq.add(1);
        pq.add(2);
        pq.add(3);
        pq.add(4);
        System.out.println(pq.remove());
        System.out.println(pq.remove());
        System.out.println(pq.remove());
        System.out.println(pq.remove());
    }
    
    
}

//package Heaps.Construction;

import java.util.ArrayList;

class PriorityQueue{
    ArrayList<Integer> data;
    public PriorityQueue(){
        data = new ArrayList<>();
    }
    public void swap(int i , int j){
        int ith = data.get(i);
        int jth = data.get(j);
        data.set(i,jth);
        data.set(j,ith);
    }
    public void upHeapify(int childIdx){
        if(childIdx==0){
            return;
        }
        int parentIdx = (childIdx-1)/2;
        if(data.get(parentIdx)>data.get(childIdx)){
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
        if(leftChild < data.size() && data.get(leftChild) < data.get(parentIdx) ){
            minIdx = leftChild;
        }
        if(rightChild < data.size() && data.get(rightChild) < data.get(minIdx)){
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
       PriorityQueue pq = new PriorityQueue();
        pq.add(10);
        pq.add(5);
        pq.add((int)-1e5);
        pq.add((int)-1e5);
        System.out.println(pq.remove()); 
        System.out.println(pq.remove()); 
        System.out.println(pq.remove()); 
        System.out.println(pq.remove()); 
        System.out.println(pq.remove()); 
    }
    
    
}

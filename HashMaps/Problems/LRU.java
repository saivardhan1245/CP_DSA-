import java.util.HashMap;
import java.util.Map;
//https://leetcode.com/problems/lru-cache/
class LRUCache {
    class Node {
        int key;
        int value;
        Node prev;
        Node next;

        public Node(int key, int val) {
            this.key = key;
            this.value = val;
        }
    }
    Node head;
    Node tail;
    int  size;
    int maxCapacity;
    Map<Integer, Node> map;

    public LRUCache(int capacity) {
        head = null;
        tail = null;
        size = 0 ;
        maxCapacity = capacity;
        map = new HashMap<>();
        
    }
    
    // map contains key , before returing value ; 
    //  (remove Node first  connect prev,next of node )  addlast to dll  ;then value 
    public void removeFirst(){
        Node temp  = head;
       
        if(head==tail){
            head = null;
            tail = null;

        }else {
            head = head.next;
            head.prev = null;   
        }
         map.remove(temp.key);
        size--;
    }
    public void addLast(Node nn){
        if(head==null){
            head = tail = nn;
        }else{
            tail.next = nn;
            nn.prev = tail;
            tail = nn;
        }
        size++;
    }
    public void removeNode(Node toRemove){
        if(head == tail){
            head = tail = null;
            
        }
        else if(head == toRemove){
            head = head.next;

        } else if(tail == toRemove){
            
            tail = tail.prev;
            tail.next = null;
           
        } else {
            Node fnode = toRemove.prev;
            Node nnode = toRemove.next;
            fnode.next = nnode;
            nnode.prev = fnode;
           
        }
        size--;
    }
    // map contains key , before returing value ; 
    //  (remove Node first  connect prev,next of node )  addlast to dll  ;then value 
    public int get(int key) {
        if(!map.containsKey(key)){
            return -1;
        }
        Node nn = map.get(key);
        removeNode(nn);
        addLast(nn);
        return nn.value;
    }

    // if within cap addlast() ,
    // if exceed capacity removeFirst() , then add <k,v> to addlast()
    public void put(int key, int value) {
        //
        if(map.containsKey(key)){
            Node nn = map.get(key);
            nn.value = value;
            map.put(key,nn);


            get(key);
        
        } else {
            Node nn = new Node(key,value);
            addLast(nn);
            map.put(key,nn);
            if(size > maxCapacity){
                Node temp = head;
                map.remove(temp.key);
                removeFirst();
            }
        }

    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
package HashMaps.Construction;

import java.util.LinkedList;

public class Main {
    class HashMap<K,V>{
        class HashMapNode<K,V>{
        K key;
        V value;
        public HashMapNode(K key, V value){
            this.key = key;
            this.value = value;
        }
        }
        private LinkedList<HashMapNode>[] buckets;
        private int size ;
        private int no_of_buckets = 4 ;
        public HashMap(){
            size = 0 ;
            initializeBuckets();
        }
        public void initializeBuckets(){
            buckets = new LinkedList[no_of_buckets];
            for(int i = 0 ; i < no_of_buckets ; i++){
                buckets[i] = new LinkedList<>();
            }
        }
        private int findBucketIndex(K key){
            int hc = key.hashCode(); // -16 || 5;
            int bucketIndex = Math.abs(hc) % no_of_buckets;

            return bucketIndex;
        }
        public void put(K key , V value){

        }
    }
    
}

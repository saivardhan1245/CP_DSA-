public class getRandomo(1) {
    //https://leetcode.com/problems/insert-delete-getrandom-o1/
    class RandomizedSet {
    List<Integer> data;
    HashMap<Integer,Integer> map;
    public RandomizedSet() {
        data = new ArrayList<>();
        map =  new HashMap<>();
    }
    
    public boolean insert(int val) {
        if(map.containsKey(val)){
            return false;
        }
        map.put(val,data.size());
        data.add(val);
        return true;
        
    }
    
    public boolean remove(int val) {
        if(!map.containsKey(val)){
            return false;
        }
        int remIdx = map.get(val);

        int lIdx = data.size()-1;
        int lastval = data.get(lIdx);
        swap(remIdx,lIdx);
        map.put(lastval,remIdx);
        map.remove(val);
        data.remove(lIdx);
        return true;
    }
    public void swap(int i , int j){
        int valI = data.get(i);
        int valJ = data.get(j);
        data.set(i,valJ);
        data.set(j,valI);
        return;
    }
    public int getRandom() {
        int ridx = (int)(Math.random() *  data.size());
        return data.get(ridx);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
}

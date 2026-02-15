import java.util.HashMap;
import java.util.Map;

public class firstEleUniqFreq {
    //https://leetcode.com/problems/first-element-with-unique-frequency/description/
    public int firstUniqueFreq(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int ele:nums){
            map.put(ele,map.getOrDefault(ele,0)+1);
            
        }
        Map<Integer,Integer> unq = new HashMap<>();
        for(int val:map.values()){
            unq.put(val,unq.getOrDefault(val,0)+1);
        }
       
        for(int i = 0 ; i < nums.length ; i++){
            int ele = nums[i];
            int f = map.get(ele);
            int ff = unq.get(f);
            if(ff==1){
                return ele;
            }
        }
        return -1 ;
    }
}

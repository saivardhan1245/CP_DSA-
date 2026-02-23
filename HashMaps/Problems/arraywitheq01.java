package HashMaps.Problems;

import java.util.HashMap;
import java.util.Map;

public class arraywitheq01 {
    //https://leetcode.com/problems/contiguous-array/description/
    public int findMaxLength(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        int maxLen = 0 ;
        map.put(0,-1);
        int csum = 0 ;
        for(int i = 0 ; i < nums.length ; i++){
            int ele = nums[i];
            csum += (ele>0)?1:-1;
            if(map.containsKey(csum)){
                maxLen = Math.max(maxLen, i - map.get(csum));
            }
            if(!map.containsKey(csum)){
                map.put(csum,i);
            }
        }
        return maxLen;
    }
}

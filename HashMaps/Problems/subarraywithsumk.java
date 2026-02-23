package HashMaps.Problems;

import java.util.HashMap;
import java.util.Map;

public class subarraywithsumk {

    
    // https://leetcode.com/problems/subarray-sum-equals-k/description/
     public int subarraySum(int[] nums, int k) {
         Map<Integer,Integer> map = new HashMap<>();
        
        map.put(0,1);
        int csum = 0;
        int cnt = 0;

        for(int i = 0; i < nums.length; i++){
            csum += nums[i];

            if(map.containsKey(csum - k)){
                cnt += map.get(csum - k);
            }

            if(map.containsKey(csum)){
                map.put(csum, map.get(csum) + 1);
            } else {
                map.put(csum, 1);
            }
        }

        return cnt;
    }
    //https://www.geeksforgeeks.org/problems/longest-sub-array-with-sum-k0809/1
    public int longestSubarray(int[] nums, int k) {
       Map<Integer,Integer> map = new HashMap<>();
       int ml = 0 ;
       map.put(0,-1);
       int csum = 0 ;
       for(int i = 0 ; i < nums.length ; i++){
          csum += nums[i];
          if(map.containsKey(csum-k)){
            ml = Math.max(ml, i - map.get(csum-k));
          }
          if(!map.containsKey(csum)){
             map.put(csum , i );
          }
       }
       return ml;
    }
    //https://leetcode.com/problems/subarray-sums-divisible-by-k/submissions/1928723574/
    public int subarraysDivByK(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        // x + (a+b+c) = y => x%k + 0 = y  
        int cnt = 0 , csum = 0 ;
        map.put(0,1);
        for(int ele:nums){
            csum += ele;
            int rem = csum%k;
            if(rem < 0 ){
                rem += k ;
            }
            if(map.containsKey(rem)){
                cnt+= map.get(rem);
            }
            if(!map.containsKey(rem)){
                map.put(rem,1);
            }else{
                map.put(rem,map.get(rem)+1);
            }
            
        }
        return cnt;
    }
}

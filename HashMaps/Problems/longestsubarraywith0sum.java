package HashMaps.Problems;

import java.util.HashMap;
import java.util.Map;

public class longestsubarraywith0sum {
    //https://www.geeksforgeeks.org/problems/largest-subarray-with-0-sum/1
    int maxLength(int arr[]) {
        // code here
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,-1);
        int maxLen = 0 , csum = 0 ;
        for(int i = 0 ; i < arr.length ; i++){
            csum+=arr[i];
            if(!map.containsKey(csum)){
                map.put(csum,i);
            }else{
                maxLen = Math.max(maxLen , i - map.get(csum));
            }
        }
        return maxLen;
    }
    //https://www.geeksforgeeks.org/problems/zero-sum-subarrays1825/1
    class Solution {
    public int findSubarray(int[] arr) {
        // code here.
        HashMap<Integer,Integer> map = new HashMap<>();
        int ans = 0 , csum = 0  ;
        map.put(0,1);
        for(int i = 0 ; i < arr.length ; i++){
            csum += arr[i];
            if(!map.containsKey(csum)){
                map.put(csum, 1);
            }else{
                // ans += map.get(csum);
                // map.put(csum,map.get(csum)+1);
               ans += map.getOrDefault(csum,0);
              map.put(csum, map.getOrDefault(csum,0)+1);
            }
        }
        return ans;
    }
}

}

package HashMaps.Problems;

import java.util.HashMap;
import java.util.Map;

public class subarrayprob {
    //https://www.geeksforgeeks.org/problems/largest-subarray-with-0-sum/1

    //x + (a+b+c) = x then a+b+c = 0 
    int maxLength(int arr[]) {
        // code here
        Map<Long,Integer> map = new HashMap<>();
        int maxLen = 0 ;
        Long csum = 0L  ;
        map.put(0L,-1);
        for(int i = 0 ; i < arr.length ; i++){
            csum += arr[i];
            if(map.containsKey(csum)){
                maxLen = Math.max(maxLen , i - map.get(csum));
            }else{
                map.put(csum,i);
            }
        }
        return maxLen;
    }
    //https://www.geeksforgeeks.org/problems/zero-sum-subarrays1825/1
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
                ans += map.get(csum);
                map.put(csum,map.get(csum)+1);
               
            }
        }
        return ans;
    }
}

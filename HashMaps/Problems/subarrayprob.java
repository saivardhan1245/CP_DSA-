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
}

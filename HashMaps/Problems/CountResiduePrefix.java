package HashmapHeap.Hashing.HashmapHeap;

import java.util.HashSet;
import java.util.Set;

public class CountResiduePrefix {
    //https://leetcode.com/problems/count-residue-prefixes/description/
    public int residuePrefixes(String s) {
        Set<Character> unq = new HashSet<>();
        int cnt = 0 ;
        for(int i = 0 ; i < s.length() ; i++){
            char ele = s.charAt(i);
            unq.add(ele);
            if((i+1)%3 == unq.size()){
                cnt++;
            }
        }
        return cnt;
    }
    // https://leetcode.com/problems/number-of-centered-subarrays/
    public int centeredSubarrays(int[] nums) {      
        int cnt = 0; 
        for(int i = 0 ; i < nums.length ; i++){
            Set<Integer> map = new HashSet<>();
            int sum = 0 ;
            for(int j = i ; j < nums.length  ; j++){
                sum += nums[j];
                map.add(nums[j]);
                if(map.contains(sum)){
                    cnt++;
                }
            }
        }
        return cnt;
    }
}

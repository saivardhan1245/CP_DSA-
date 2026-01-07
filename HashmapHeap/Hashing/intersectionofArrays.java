package Arrays.Hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class intersectionofArrays {
    
  //  https://leetcode.com/problems/intersection-of-two-arrays/
  //. Intersection of Two Arrays

  public int[] intersection(int[] nums1, int[] nums2) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int ele:nums1){
            map.put(ele,1);
        }
        List<Integer> res = new ArrayList<>();
        for(int ele:nums2){
            if(map.containsKey(ele)){
                res.add(ele);
                map.remove(ele);
            }
        }
        int[] ans = new int[res.size()];
        for(int i = 0 ; i < ans.length ; i++){
            ans[i]= res.get(i);
        }
        return ans;
    }
}

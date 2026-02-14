import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class IntersectionofEle {


    //https://leetcode.com/problems/intersection-of-two-arrays/description/
    public int[] intersection(int[] nums1, int[] nums2) {
        // using hashset
        Set<Integer> h = new HashSet<>();
        for(int ele:nums1){
            h.add(ele);
        }
        Set<Integer> ans = new HashSet<>();
        for(int ele:nums2){
            if(h.contains(ele)){
                ans.add(ele);
            }
        }
        return  ans.stream().mapToInt(i->i).toArray();
    }// using hashmaps
    class Solution {
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
        
        return res.stream().mapToInt(i->i).toArray();
    }
}
}

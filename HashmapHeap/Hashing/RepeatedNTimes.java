package Arrays.BasicQuestions;

import java.util.HashMap;
import java.util.Map;

public class RepeatedNTimes {
    /*
    PROBLEM :
    You are given an integer array nums with the following properties:
    nums.length == 2 * n.
    nums contains n + 1 unique elements.
    Exactly one element of nums is repeated n times.
    Return the element that is repeated n times.


CONCEPT :
    count the ele which appear n times through map 

LINK :
    https://leetcode.com/problems/n-repeated-element-in-size-2n-array/description/?envType=daily-question&envId=2026-01-02

     */
    public int repeatedNTimes(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        int maxC = nums.length/2;
        for(int i = 0 ; i < nums.length ; i++){
            int ele = nums[i];
            map.put(ele,map.getOrDefault(ele,0)+1);
        }
        for(Map.Entry<Integer,Integer> e : map.entrySet()){
            if(e.getValue()==maxC){
                return e.getKey();
            }
            // System.out.println(e.getValue()+" ");
        }
        return -1;
    }
}

package Arrays.Hashing;

import java.util.HashMap;
import java.util.Map;

/*
Problem : SubArray with sum k 

link : https://leetcode.com/problems/subarray-sum-equals-k/description/

concept :

At each index i, we count how many previous prefix sums equal prefix[i] − k.

Let the prefix sum up to index i be x.
Any subarray ending at i with sum k must start after an index where the prefix sum was x − k.
Therefore,
 the number of subarrays ending at index i with sum k is equal 
 to the frequency of the prefix sum x − k seen so far.

 T.C:O(N)
 S.C:O(N)

 */
public class Subarraywithsumk {
     public int subarraySum(int[] nums, int k) {
       Map<Integer,Integer> map = new HashMap<>();
       int pref_sum = 0 ;
       int cnt = 0 ;
       map.put(0,1);
       for(int ele:nums){
          pref_sum+=ele;
          cnt += map.getOrDefault(pref_sum-k,0);
          map.put(pref_sum,map.getOrDefault(pref_sum,0)+1);
       }
       return cnt;
    }
}

package HashMaps.Problems;

import java.util.HashMap;

public class ArrDivbyK {
    //https://leetcode.com/problems/check-if-array-pairs-are-divisible-by-k/description/
    /*(a + b) % k = 0
      (a % k + b % k) % k = 0
      b % k ≡ - (a % k) (mod k)
      compRem = (k - rem) % k;


 */
    public boolean canArrange(int[] arr, int k) {
       HashMap<Integer,Integer> map = new HashMap<>();
       for(int i = 0 ; i < arr.length ; i++){
          int rem = arr[i]%k;
          if(rem<0){
            rem+=k;
          }
          int compRem = (k-rem)%k;
          if(map.containsKey(compRem) && map.get(compRem)>0){
            map.put(compRem,map.get(compRem)-1);
          }else{
            map.put(rem,map.getOrDefault(rem,0)+1);
          }
       }
       for(int val:map.keySet()){
          if(map.get(val)!=0){
            return false;
          }
       }
       return true;
    }
}

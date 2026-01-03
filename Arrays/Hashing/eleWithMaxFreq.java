package Arrays.BasicQuestions;

import java.util.HashMap;
import java.util.Map;

public class eleWithMaxFreq {
    /*
    Count Elements With Maximum Frequency
    https://leetcode.com/problems/count-elements-with-maximum-frequency/description/
     */
    public int maxFrequencyElements(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();int ans = 0 ;
        for(int ele:nums){
            map.put(ele,map.getOrDefault(ele,0)+1);
        }
        int maxfreq = 0 ;
        for(int freq:map.values()){
            maxfreq = Math.max(freq,maxfreq);
        }
        for(int freq:map.values()){
            if(freq  == maxfreq){
                ans += freq;
            }
        }
        return ans;
    }
}

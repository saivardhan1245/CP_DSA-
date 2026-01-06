import java.util.HashSet;
import java.util.Set;

public class LongestConseqseq {
    //https://leetcode.com/problems/longest-consecutive-sequence/
   public int longestConsecutive(int[] nums) {
        Set<Integer> s = new HashSet<>();
        for(int ele:nums){
            s.add(ele);
        }
        int  mc = 0 ;
        for(int ele:nums){
            if(s.contains(ele)==false) continue;
            int left = ele - 1 , right = ele + 1 ;
            while(s.contains(left)){
                s.remove(left);
                left--;
            }
            while(s.contains(right)){
                s.remove(right);
                right++;
            }
            mc = Math.max(mc,right-left-1);
            s.remove(ele);
        }
        return mc;
    } 
}

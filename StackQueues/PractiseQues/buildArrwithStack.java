import java.util.ArrayList;
import java.util.List;
//https://leetcode.com/problems/build-an-array-with-stack-operations/description/
public class buildArrwithStack {
    class Solution {
    public List<String> buildArray(int[] target, int n) {
        List<String> res = new ArrayList<>();
        // int[] arr = new int[n+1];
        // for(int i = 1; i <= n ; i++){
        //     arr[i] = i;
        // }
        int t = target.length;
        int stop = target[target.length-1];
        int j = 0;
        for(int i = 1 ; i <= n; i++){
            res.add("Push");
            if(i ==target[j]){
                j++;
                
            }
            else{
                res.add("Pop");
            }
            if(i==stop){
                break;
            }
        }
        return res;
    }
}
}

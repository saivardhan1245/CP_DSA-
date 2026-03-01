import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class toggleBulbs {
    //https://leetcode.com/problems/toggle-light-bulbs/description/
    public List<Integer> toggleLightBulbs(List<Integer> bulbs) {
       Map<Integer,Boolean> map = new HashMap<>();
        Boolean toggle = false;
        for(int ele:bulbs){
            if(map.containsKey(ele)){
                Boolean oldFlag = map.get(ele);
                map.put(ele,!oldFlag);
            }
            else{
                map.put(ele,true);
            }
        }
        List<Integer> ans = new ArrayList<>();
        for(Map.Entry<Integer,Boolean> e : map.entrySet()){
            Integer val  = e.getKey();
            Boolean flag = e.getValue();
            if(flag){
                ans.add(val);
            }
        }
        Collections.sort(ans);
         return ans;
    }  
}

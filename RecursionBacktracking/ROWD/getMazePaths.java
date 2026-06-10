

import java.util.*;

public class getMazePaths {
    public static List<String> getPathsHV(int sr,int sc,int dr,int dc){

        if(sr>dr || sc>dc){
            List<String> bArr = new ArrayList<>();
            return bArr;
        }
        if(sr==dr && sc==dc){
            List<String> bArr = new ArrayList<>();
            bArr.add("");
            return bArr;
        }
        //after h steps
        List<String> afterHsteps = getPathsHV(sr,sc+1,dr,dc);
        //after v steps
        List<String> afterVsteps = getPathsHV(sr+1,sc,dr,dc);
        List<String> res = new ArrayList<>();
        for(String ele:afterHsteps){
            res.add("h"+ele);
        }
        for(String ele:afterVsteps){
            res.add("v"+ele);
        }
        return res;
    }
    public static void main(String[] args){
        System.out.println(getPathsHV(0,0,2,2));
        //[hhvv, hvhv, hvvh, vhhv, vhvh, vvhh]
    }
}

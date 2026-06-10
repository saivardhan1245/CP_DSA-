package RecursionBacktracking.ROWD;

import java.util.*;

public class getSubSeq {
    public static List<String> getSubSeq(String str){
        if(str.length() == 0 ){
            List<String> a = new ArrayList<>();
            a.add("");
            return a;
        }
        char ch = str.charAt(0);
        String smallstr = str.substring(1);
        List<String> smallAns = getSubSeq(smallstr);
        List<String> res = new ArrayList<>();
        // if ch says no
        for(String ele:smallAns){
            res.add(ele);
        }
        // if ch says yes
        for(String ele:smallAns){
            res.add(ch+ele);
        }
        return res;
    }
    public static void main(String[] args) {
        
        System.out.println(getSubSeq("abc"));
        // output [, c, b, bc, a, ac, ab, abc]
    }
}